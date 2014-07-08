(ns robot)

(def ^:private capital-letters 
  (map char (range (int \A) (+ (int \Z) 1))))

(defn- random-name [] 
  (str 
    (rand-nth capital-letters)
    (rand-nth capital-letters)
    (rand-int 1000)))

(defn robot []
  (atom {:name ""}))

(defn robot-name [robot]
  (let
    [current-name (:name @robot)]
    (if (empty? current-name)
      (:name (swap! robot assoc :name (random-name)))
      current-name)))

(defn reset-name [robot]
  (swap! robot assoc :name ""))