(ns beer
  (:require [clojure.string :as str]))

(def on-the-wall " on the wall")

(def of-beer " of beer")

(defn sth-of-beer [text]
  (str text of-beer))

(defn sth-on-the-wall [text]    
  (str (sth-of-beer text) on-the-wall))

(defn take-down [which]
  (str "Take " which " down and pass it around"))

(defn beer-phrase 
  ([f text]
   (beer-phrase f text ""))
  ([f text plural]
   (f (str text " bottle" plural))))

(defn paragraph [phrase1 phrase2]
  (str phrase1 ", " phrase2 ".\n"))

(defn first-paragraph
  ([text]
   (first-paragraph text ""))
  ([text plural]
   (paragraph 
     (str/capitalize (beer-phrase sth-on-the-wall text plural))
     (beer-phrase sth-of-beer text plural))))

(defn second-paragraph
  ([action text]
   (second-paragraph action text ""))
  ([action text plural]
   (paragraph 
     action
     (beer-phrase sth-on-the-wall text plural))))

(defmulti verse identity)

(defmethod verse 0 [_]
  (str 
    (first-paragraph "no more" "s")
    (second-paragraph 
      "Go to the store and buy some more" 99 "s")))

(defmethod verse 1 [num-of-bottles]
  (str 
    (first-paragraph num-of-bottles)
    (second-paragraph 
      (take-down "it") "no more" "s")))

(defmethod verse 2 [num-of-bottles]
  (str 
    (first-paragraph num-of-bottles "s")
    (second-paragraph 
      (take-down "one") (- num-of-bottles 1))))

(defmethod verse :default [num-of-bottles]
  (str 
    (first-paragraph num-of-bottles "s")
    (second-paragraph 
      (take-down "one") (- num-of-bottles 1) "s")))

(defn closed-descending-range [from to]
  (reverse (range to (inc from))))

(defn sing 
  ([from] 
   (sing from 0))
  ([from to]
   (str/join 
     "\n" 
     (map verse (closed-descending-range from to)))))