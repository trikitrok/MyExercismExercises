(ns space-age)

(defn on-earth [seconds]
  (let 
    [seconds-per-earth-year 31557600.0]
  (/ seconds seconds-per-earth-year)))

(defn on-planet [orbital-period-in-earth-years seconds]
  (/ (on-earth seconds) orbital-period-in-earth-years))

(defn on-mercury [seconds] 
  (on-planet 0.2408467 seconds))

(defn on-venus [seconds] 
  (on-planet 0.61519726 seconds))

(defn on-mars [seconds] 
  (on-planet 1.8808158 seconds))

(defn on-jupiter [seconds] 
  (on-planet 11.862615 seconds))

(defn on-saturn [seconds] 
  (on-planet 29.447498 seconds))

(defn on-uranus [seconds] 
  (on-planet 84.016846 seconds))

(defn on-neptune [seconds] 
  (on-planet 164.79132 seconds))