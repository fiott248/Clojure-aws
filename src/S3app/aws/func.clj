(ns s3app.aws.func
  (:require [amazonica.core :refer [with-credential defcredential]]
            [amazonica.aws.s3 :as s3]
            [amazonica.aws.s3transfer :as s3transfer]))

(def creds
  {:access-key "local-access"
   :secret-key "local-secret"
   :endpoint "http://localhost:8000"})

(defn fileupload
  "upload file given to Amazon s3 bucket"
  [file & bucket]
  (let [upl (s3transfer/upload creds
                               bucket
                               file)]
  ((:add-progress-listener upl) #(println %))))
