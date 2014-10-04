(ns allergies)
(declare allergies-by-score several-allergies, search-subset, searc-helper)

(defn list [score]
  (if-let [one-match (get allergies-by-score score)]
    [one-match]
    (several-allergies score)))

(defn allergic_to? [score stuff]
  (some #{stuff} (list score)))

(def ^:private allergies-by-score
  { 1 "eggs"
   2 "peanuts"
   4 "shellfish"
   8 "strawberries"
   16 "tomatoes"
   32 "chocolate"
   64 "pollen"
   128 "cats"})

(defn- several-allergies [score] 
  (let [possible-allergies-ids (filter #(< % score) (keys allergies-by-score))]
    (if (empty? possible-allergies-ids)
      []
      (map #(get allergies-by-score %)
           (search-subset 
             score 
             possible-allergies-ids)))))

(defn- searc-helper [score num-set nums]
  (if (> score (reduce + (keys allergies-by-score)))
    (let [max-num (apply max nums)]
      (searc-helper (- score max-num) 
                    (conj num-set max-num) 
                    nums))
    (if (empty? nums) 
      false
      (let [current-num (first nums)
            sum (+ current-num (reduce + num-set))
            num-set-with-current-num (conj num-set current-num)] 
        (cond (= score sum) num-set-with-current-num
              (> score sum) (if-let [res (searc-helper score num-set-with-current-num (rest nums))]
                              res 
                              (searc-helper score num-set (rest nums)))
              (< score sum) (searc-helper score num-set (rest nums)))))))

(defn search-subset [score nums]
  (searc-helper score #{} nums))
