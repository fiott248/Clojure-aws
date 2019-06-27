(defproject s3-bucket "0.1.0-SNAPSHOT"
  :description "S3-upload"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [amazonica "0.3.143"]
                 [hiccup "1.0.5"]
                 [compojure "1.1.6"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [ring/ring-core "1.7.1"]]
  :repl-options {:init-ns s3app.core}
  :main s3app.core
  :ring {:handler s3app.core/application}
  :java-source-paths ["src/cmp/java"])
