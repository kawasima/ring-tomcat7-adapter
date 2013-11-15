(ns ring.adapter.tomcat
  "Adapter for the Tomcat webserver."
  (:import
    [org.apache.catalina.startup Tomcat]
    [org.apache.catalina.core AprLifecycleListener StandardServer]
    [javax.servlet.http HttpServlet])
  (:require [ring.util.servlet :as servlet]))

(defn- create-server
  "Construct a Tomcat Server instance."
  [options]
  (let [ tomcat (doto (Tomcat.)
                  (.setPort (options :port 8080))
                  (.setBaseDir "."))
         server (.getServer tomcat)]
    (. server addLifecycleListener (AprLifecycleListener.))
    (.. tomcat getHost (setAppBase "resources"))
    tomcat))

(defn run-tomcat [handler options]
  (let [ s (create-server (dissoc options :configurator))
         ctx (.addContext s "" ".")]
    (. s addServlet "" "ring-servlet" (servlet/servlet handler))
    (. ctx addServletMapping "/*" "ring-servlet")
    (.start s)
    (.. s getServer await)
    s))
