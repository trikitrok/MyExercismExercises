(ns anagram
  [:require [clojure.string :as str]])

(defn anagram? [word possible-anagram]
  (and 
    (not= word possible-anagram)
    (= (sort possible-anagram)
       (sort word))))

(defn case-insensitive-anagram? [word possible-anagram]
  (anagram? 
    (str/lower-case word) 
    (str/lower-case possible-anagram)))

(defn anagrams-for [word word-list]
  (vec 
    (filter 
      #(case-insensitive-anagram? word %) 
      word-list)))