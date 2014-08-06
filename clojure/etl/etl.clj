(ns etl 
  (:require [clojure.string :as str]))

(defn- associate-score-to-letters 
  [scores-per-letter [letters score]]
  (let
    [associate-score-to-letter
     (fn [scores-per-letter letter]
       (assoc 
         scores-per-letter 
         (str/lower-case letter)
         score))]
    (reduce
      associate-score-to-letter
      scores-per-letter
      letters)))

(defn transform [letters-per-score]
  (reduce 
    associate-score-to-letters
    {}
    (zipmap 
      (vals letters-per-score) 
      (keys letters-per-score))))