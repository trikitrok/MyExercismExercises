(ns accumulate)

(defn accumulate [func coll]
  (for [x coll] (func x)))

;(defn accumulate [func coll]
;  (reduce #(conj %1 (func %2)) [] coll))
;
;(defn accumulate [func coll]
;  (let [accumulate-rec
;        (fn [acc [first-elem & rest-elems]]
;          (if (nil? first-elem)
;            acc
;            (recur (conj acc (func first-elem))
;                   rest-elems)))]
;    (accumulate-rec [] coll)))