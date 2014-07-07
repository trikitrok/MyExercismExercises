(ns space-age)

(defn on-earth [seconds]
  (let 
    [seconds-per-earth-year 31557600.0]
  (/ seconds seconds-per-earth-year)))

(defn on-mercury [seconds] 
  (/ (on-earth seconds) 0.2408467))

(defn on-venus [seconds] 
  (/ (on-earth seconds) 0.61519726))

(defn on-mars [seconds] 
  (/ (on-earth seconds) 1.8808158))

(defn on-jupiter [seconds] 
  (/ (on-earth seconds) 11.862615))

(defn on-saturn [seconds] 
  (/ (on-earth seconds) 29.447498))

(defn on-uranus [seconds] 
  (/ (on-earth seconds) 84.016846))

(defn on-neptune [seconds] 
  (/ (on-earth seconds) 164.79132))