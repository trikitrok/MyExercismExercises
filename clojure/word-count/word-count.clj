(ns word-count
  (:require [clojure.string :as str]))

(def ^:private remove-punctuation 
  (comp (partial apply str)
        (partial filter 
                 #(or (Character/isLetter %) 
                      (Character/isSpace %)
                      (Character/isDigit %)))))

(defn- extract-words-from [sentence] 
  (str/split (remove-punctuation (str/lower-case sentence)) #"\s+"))

(defn word-count [sentence]
  (frequencies (extract-words-from sentence)))