(ns etl (:require [clojure.string :as str]))

(defn transform [data-set]
  (let 
    [assoc-pairs 
     (fn [data [letters num]]
       (reduce
         #(assoc %1 (str/lower-case %2) num)
         data
         letters))]
    (reduce 
      assoc-pairs
      {}
      (zipmap (vals data-set) (keys data-set)))))