(ns beer
  (:require [clojure.string :as str]))

(defn no-more-bottles? [num-of-bottles]
  (= num-of-bottles 0))

(defn one-bottle? [num-of-bottles]
  (= num-of-bottles 1))

(defn bottles [num-of-bottles] 
  (cond  
    (no-more-bottles? num-of-bottles) "no more bottles"
    (one-bottle? num-of-bottles) (str num-of-bottles " bottle")
    :else (str num-of-bottles " bottles")))

(defn bottles-of-beer [num-of-bottles]
  (str (bottles num-of-bottles) " of beer"))

(defn bottles-on-the-wall [num-of-bottles]    
  (str (bottles-of-beer num-of-bottles) " on the wall"))

(defn phrase1 [num-of-bottles]
  (str (str/capitalize (bottles-on-the-wall num-of-bottles))
       ", "
       (bottles-of-beer num-of-bottles)
       ".\n"))

(defn take-down [num-of-bottles]
  (str 
    "Take "
    (if (one-bottle? num-of-bottles) "it" "one")
    " down and pass it around, "))

(defn action [num-of-bottles] 
  (if (no-more-bottles? num-of-bottles)
    "Go to the store and buy some more, "
    (take-down num-of-bottles)))

(defn remaining-bottles [num-of-bottles]
  (if (no-more-bottles? num-of-bottles) 
    99 
    (- num-of-bottles 1)))

(defn phrase2 [num-of-bottles]
  (str (action num-of-bottles)
       (bottles-on-the-wall 
         (remaining-bottles num-of-bottles))
       ".\n"))

(defn verse [num-of-bottles]
  (str (phrase1 num-of-bottles)
       (phrase2 num-of-bottles)))

(defn closed-descending-range [from to]
  (reverse (range to (inc from))))

(defn sing 
  ([from] 
   (sing from 0))
  ([from to]
   (str/join 
     "\n" 
     (map verse (closed-descending-range from to)))))