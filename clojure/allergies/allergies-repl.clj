(def scores [1 2 4 8 16 32 64 128])

(filter #(> 3 %) scores)

(defn pairs-with [a ls]
  (map #(cons a [%]) ls))

(pairs-with 3 [1 2 3])


(defn all-pairs [ls]
  (cond (empty? ls) '()
        :else (concat (pairs-with (first ls) (rest ls))
                      (all-pairs (rest ls)))))

(all-pairs ["a" "b" "c"])

(all-pairs ["a" "b" "c" "d"])

(defn- searc-helper [score num-set nums]
  (if (empty? nums)
      false
      (let [current-num (first nums)
            sum (+ current-num (reduce + num-set))
            num-set-with-current-num (conj num-set current-num)]
        (cond (= score sum) num-set-with-current-num
              (> score sum) (if-let [res (searc-helper score num-set-with-current-num (rest nums))]
                              res
                              (searc-helper score num-set (rest nums)))
              (< score sum) (searc-helper score num-set (rest nums))))))

(defn search-subset [score nums]
  (searc-helper score #{} nums))

(search-subset 5 [1 3 4])

(search-subset 5 [3 3 4 2])

(def ^:private allergies-by-score
  {128 "cats"
    64 "pollen"
    32 "chocolate"
    16 "tomatoes"
    8 "strawberries"
    4 "shellfish"
    2 "peanuts"
   1 "eggs"})

(keys allergies-by-score)

(defn- several-allergies [score]
  (let [allergies-ids (keys allergies-by-score)]
    (map #(get allergies-by-score %)
         (search-subset score (filter #(< % score) allergies-ids)))))

(several-allergies 5)

(reduce + (keys allergies-by-score))

(several-allergies 253)

(several-allergies 254)

(several-allergies 255)
