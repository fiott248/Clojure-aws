(ns s3app.layout
  (:use [hiccup.page :only (html5 include-css include-js)]
        [hiccup.form]
        [hiccup.element :only (link-to)]))


(defn application [title & content]
"Header layout"
  (html5 {:ng-app "myApp" :lang "en"}
         [:head
          [:title title]
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")
          (include-js "js/ui-bootstrap-tpls-0.7.0.min.js")
          (include-js "js/script.js")

          [:body
           [:div {:class "container"} content ]]]))

(defn upload-form []
  "body layout of index page"
   [:div {:class "well-large"}
    [:form
      {:enctype "multipart/form-data", :method "post", :action ""}
      [:label {:class "control-label"} "Bucket name"]
      [:input {:name "bucket", :type "text"}]
      [:label {:class "control-label"} "Upload File"]
      [:input#fileToUpload {:name "file", :type "file"}]
      [:input {:name "submit", :value "Upload Image", :type "submit"}]]]
  )


(defn not-found []
  "page not found layout"
  [:div
   [:h1 {:class "info-warning"} "Page Not Found"]
   [:p "There's no requested page. "]
   (link-to {:class "btn btn-primary"} "/" "Take me to Home")])
