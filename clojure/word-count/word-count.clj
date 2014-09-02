(ns word-count
  (:require [clojure.string :as str]))

(defn- remove-punctuation [sentence]
  (->> 
    sentence
    (filter #(or (Character/isLetter %) 
                 (Character/isSpace %)
                 (Character/isDigit %)))
    (apply str)))

(defn- extract-words-from [sentence] 
  (str/split (remove-punctuation (str/lower-case sentence)) #"\s+"))

(defn word-count [sentence]
  (frequencies (extract-words-from sentence)))