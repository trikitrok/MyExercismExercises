(ns space-age)

(defn on-earth [seconds]
  (let 
    [seconds-per-earth-year 31557600.0]
    (/ seconds seconds-per-earth-year)))

(defn on-mercury [seconds] 
  (let 
    [orbital-period-in-earth-years 0.2408467]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-venus [seconds] 
  (let
    [orbital-period-in-earth-years 0.61519726]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-mars [seconds] 
  (let
    [orbital-period-in-earth-years 1.8808158]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-jupiter [seconds] 
  (let
    [orbital-period-in-earth-years 11.862615]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-saturn [seconds] 
  (let
    [orbital-period-in-earth-years 29.447498]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-uranus [seconds] 
  (let
    [orbital-period-in-earth-years 84.016846]
    (/ (on-earth seconds) orbital-period-in-earth-years)))

(defn on-neptune [seconds] 
  (let
    [orbital-period-in-earth-years 164.79132]
    (/ (on-earth seconds) orbital-period-in-earth-years)))
