(ns bob
  (:require [clojure.string :as str]))

(defn response-for [sentence]
  (let
    [shouting?
     (fn []
       (let
         [letters (filter #(Character/isLetter %) sentence)]
         (and (not (empty? letters))
              (every? #(Character/isUpperCase %) letters))))
     
     asking?
     (fn []
       (= (last sentence) \?))
     
     saying-nothing? #(str/blank? sentence)]
    
    (cond
      (shouting?) "Woah, chill out!"
      (asking?) "Sure."
      (saying-nothing?) "Fine. Be that way!"
      :else "Whatever.")))
