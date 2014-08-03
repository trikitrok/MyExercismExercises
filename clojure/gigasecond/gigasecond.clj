(ns gigasecond
  (:require [clojure.string :as str])
  (:import [java.util Calendar]
           [java.text SimpleDateFormat]))

(defn- date [year month day]
  (let 
    [calendar (Calendar/getInstance)]
    (.setTime 
      calendar 
      (.parse 
        (SimpleDateFormat. "yyyy-MM-dd") 
        (str year "-" month "-" day)))
    calendar))

(defn- add-days [date days] 
  (.add date (Calendar/DATE) days)
  date)

(defn- date-to-vec [date] 
  [(.get date (Calendar/YEAR))
   (+ (.get date (Calendar/MONTH)) 1)
   (.get date (Calendar/DATE))])

(def GS_IN_DAYS 
  (/ (reduce * (repeat 9 10))
     (* 60 60 24)))

(defn from [year month day]
  (-> 
    (date year month day)
    (add-days GS_IN_DAYS)
    date-to-vec))
