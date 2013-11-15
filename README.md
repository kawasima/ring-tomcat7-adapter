Ring-Tomcat7-Adapter
===================

This adapter adds Tomcat7 support to Ring.

    (use 'ring.adapter.tomcat)
    
    (defn app [req]
      {:status  200
       :headers {"Content-Type" "text/html"}
       :body    "Hello World from Ring-Tomcat7"})
            
    (run-tomcat app {:port 8080})


