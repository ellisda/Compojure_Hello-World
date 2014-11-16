(ns hello-world.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]))

(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET  "/widgets" [] (response [{:name "Widget 1"} {:name "Widget 2"}]))
  (GET "/clojure" [] str (re-seq #"\d+" "123 456 789"))
  (GET "/user/:id" [id] (str "<h1>Hello user " (+ 10 (parse-int id)) " (we added 10) </h1>"))
  (GET "/ip" {ip :remote-addr} (str "<h1>Hello client IP " ip "  </h1>"))
  (GET "/requestmap" request (str request))
  (route/not-found "Not Found"))

; NEW CODE - attempting to play with Middleware functions
(defn wrap-content-type [handler content-type]
  (fn [request]
      (let [response (handler request)]
            (assoc-in response [:headers "Content-Type"] content-type))))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))


; Rev2  (wrap-content-type app-routes "text/html"))

;ORIG -  (wrap-defaults app-routes site-defaults))
  ;image/jpeg

