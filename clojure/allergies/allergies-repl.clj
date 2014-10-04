(ns allergies (:require [clojure.test :refer :all]))

(def ^:private allergies-by-score
  { 1 "eggs"
   2 "peanuts"
   4 "shellfish"
   8 "strawberries"
   16 "tomatoes"
   32 "chocolate"
   64 "pollen"
   128 "cats"})

(defn- search [score allergy-scores]
  (loop [s score
         n (dec (count allergy-scores))
         acc #{}]
    (if (or (zero? s) (neg? n))
      acc
      (let [allergy-score (nth allergy-scores n)]
        (if (>= s allergy-score)
          (recur (- s allergy-score) n (conj acc allergy-score))
          (recur s (dec n) acc))))))

(defn list [score]
  (let [possible-allergies-ids (filter #(<= % score) (keys allergies-by-score))]
    (vec (map #(get allergies-by-score %)
         (search score possible-allergies-ids)))))

(allergies/list 248)

(defn allergic_to? [score stuff]
  (some #{stuff} (list score)))


(allergies/list 509)


(defn same-content? [xs ys]
  (= (sort xs) (sort ys)))

(deftest no-allergies-at-all
  (is (= [] (allergies/list 0))))

(deftest allergic-to-just-eggs
  (is (= ["eggs"] (allergies/list 1))))

(deftest allergic-to-just-peanuts
  (is (= ["peanuts"] (allergies/list 2))))

(deftest allergic-to-just-strawberries
  (is (= ["strawberries"] (allergies/list 8))))

(deftest allergic-to-eggs-and-peanuts
  (is (same-content? ["eggs", "peanuts"] (allergies/list 3))))

(deftest allergic-to-more-than-eggs-but-not-peanuts
  (is (same-content? ["eggs", "shellfish"] (allergies/list 5))))

(deftest allergic-to-lots-of-stuff
  (is (same-content? ["strawberries", "tomatoes", "chocolate", "pollen", "cats"] (allergies/list 248))))

(deftest allergic-to-everything
  (is (same-content? ["eggs", "peanuts", "shellfish", "strawberries", "tomatoes", "chocolate", "pollen", "cats"] (allergies/list 255))))

(deftest no-allergies-means-not-allergic
  (is (not (allergies/allergic_to? 0 "peanuts")))
  (is (not (allergies/allergic_to? 0 "cats")))
  (is (not (allergies/allergic_to? 0 "strawberries"))))

(deftest is-allergic-to-eggs
  (is (allergies/allergic_to? 1 "eggs")))

(deftest allergic-to-eggs-in-addition-to-other-stuff
  (is (allergies/allergic_to? 5 "eggs")))

(deftest ignore-non-allergen-score-parts
  (is (same-content? ["eggs", "shellfish", "strawberries", "tomatoes", "chocolate", "pollen", "cats"] (allergies/list 509))))

(run-tests)

