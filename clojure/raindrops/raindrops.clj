(ns raindrops)

(declare prime-factors convert-factor)

(defn convert [n]
  (let 
    [factors (apply sorted-set (prime-factors n))]
    (if (some #(or (= % 3) (= % 5) (= % 7)) factors)
      (apply str (map convert-factor factors))
      (str n))))

(defn- convert-factor [factor]
  (cond 
    (= factor 3) "Pling"
    (= factor 5) "Plang"
    (= factor 7) "Plong"
    :else ""))

(def ^:private factor?
  (comp zero? rem))

(defn prime-factors [n]
  (loop [n n prime 2 factors []]
    (cond 
      (= n 1) factors
      (factor? n prime) (recur (/ n prime) prime (conj factors prime))
      :else (recur n (inc prime) factors))))