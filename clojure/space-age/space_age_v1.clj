(ns space-age)

(defn on-earth [seconds]
  (let 
    [seconds-per-earth-year 31557600.0]
  (/ seconds seconds-per-earth-year)))

(defn make-on-planet-function [orbital-period-in-earth-years]
  (let 
    [inv-period (/ 1.0 orbital-period-in-earth-years)]
  (comp (partial * inv-period) on-earth)))

(def on-mercury (make-on-planet-function 0.2408467))

(def on-venus (make-on-planet-function 0.61519726))

(def on-mars (make-on-planet-function 1.8808158))

(def on-jupiter (make-on-planet-function 11.862615))

(def on-saturn (make-on-planet-function 29.447498))

(def on-uranus (make-on-planet-function 84.016846))

(def on-neptune (make-on-planet-function 164.79132))