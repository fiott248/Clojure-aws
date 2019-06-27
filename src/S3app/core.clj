(ns s3app.core
  (:require [s3app.aws.func :as func]
            [s3app.layout :as layout]
            [compojure.core :refer [defroutes GET POST ANY]]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defroutes routes
  (GET "/" [] (layout/application "upload" (layout/upload-form)))
    (POST "/" [file bucket] (func/fileupload file bucket)  {:status 302 :headers {"Location" "/"}})
  (route/resources "/")
  (ANY "*" [] (route/not-found (layout/application "Page Not Found" (layout/not-found)))))

(def application (handler/site routes))

(defn -main []
 (let [port (Integer/parseInt (or (System/getenv "PORT") "8090"))]
  (jetty/run-jetty application {:port port :join? false})))
