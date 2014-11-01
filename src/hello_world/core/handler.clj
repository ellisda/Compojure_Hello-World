(ns hello-world.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/user/:id" [id] (str "<h1>Hello user " id " </h1>"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
