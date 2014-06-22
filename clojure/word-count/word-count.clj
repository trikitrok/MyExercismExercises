(ns word-count
  (:require [clojure.string :as str]))

(defn word-count [sentence]
  (let 
    [count-word-occurrences 
     (fn [counted-words word] 
       (let 
         [add-new-word 
          (fn [] (assoc counted-words word 1))
          
          add-occurrence-to-word 
          (fn [] (assoc counted-words word 
                   (+ (get counted-words word) 1)))]
         
         (if (contains? counted-words word)
           (add-occurrence-to-word)
           (add-new-word))))
     
     extract-words-from 
     (fn [sentence] 
       (let
         [remove-punctuation (comp (partial apply str)
                                   (partial filter 
                                            #(or (Character/isLetter %) 
                                                 (Character/isSpace %)
                                                 (Character/isDigit %))))]
         
         (str/split (remove-punctuation (str/lower-case sentence)) #"\s+")))]
    
    (reduce count-word-occurrences {} (extract-words-from sentence))))