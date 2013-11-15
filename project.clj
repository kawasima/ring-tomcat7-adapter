(defproject net.unit8/ring-tomcat7-adapter "0.1.0-SNAPSHOT"
  :description "Ring Tomcat adapter."
  :url "https://github.com/kawasima/ring-tomcat-adapter"
  :license { :name "The MITLicense"
             :url  "http://opensource.org/licenses/MIT"}
  :dependencies [ [ring/ring-core "1.2.1"]
                  [ring/ring-servlet "1.2.1"]
                  [org.apache.tomcat.embed/tomcat-embed-core "7.0.47"]
                  [org.apache.tomcat.embed/tomcat-embed-logging-juli "7.0.47"]]
  :profiles
  { :dev {:dependencies [[clj-http "0.6.4"]]}
    :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
    :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}})
