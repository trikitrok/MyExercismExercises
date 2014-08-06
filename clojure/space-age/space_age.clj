(ns space-age)

(def ^:private planets 
  ['mercury
   'venus
   'mars
   'jupiter
   'saturn
   'uranus
   'neptune])

(def ^:private orbital-periods-in-earth-years 
  (zipmap 
    planets 
    [0.2408467
     0.61519726
     1.8808158
     11.862615
     29.447498
     84.016846
     164.79132]))

(defn on-earth [seconds]
  (let
    [seconds-per-earth-year 31557600.0]
    (/ seconds seconds-per-earth-year)))

(defn- make-on-planet-function [orbital-period-in-earth-years]
  (fn [seconds]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(doall
  (map 
    #(intern 
       'space-age 
       (symbol (str "on-" (name %))) 
       (make-on-planet-function 
         (% orbital-periods-in-earth-years))) 
    planets))