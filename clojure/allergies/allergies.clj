(ns allergies)

(def ^:private allergies-by-score
  (sorted-map 1 "eggs"
              2 "peanuts"
              4 "shellfish"
              8 "strawberries"
              16 "tomatoes"
              32 "chocolate"
              64 "pollen"
              128 "cats"))

(defn- sum-subset [sum nums]
  (loop [s sum
         i (dec (count nums))
         acc-set #{}]
    (if (or (zero? s) (neg? i))
      acc-set
      (let [num (nth nums i)]
        (if (>= s num)
          (recur (- s num) i (conj acc-set num))
          (recur s (dec i) acc-set))))))

(defn list [score]
  (let [possible-allergies-ids (filter #(<= % score) (keys allergies-by-score))]
    (vec (map #(get allergies-by-score %)
              (sum-subset score possible-allergies-ids)))))

(defn allergic_to? [score stuff]
  (some #{stuff} (list score)))