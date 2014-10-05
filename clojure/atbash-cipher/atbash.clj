(ns atbash-cipher
  (:require [clojure.string :as string]))

(def ^:private latin-alphabet "abcdefghijklmnopqrstuvwxyz")

(def ^:private cypher-by-letter 
  (zipmap latin-alphabet
          (reverse latin-alphabet)))

(defn- encode-char [c]
  (if (Character/isDigit c)
    c
    (get cypher-by-letter c)))

(defn- encode-chunk [chunk] 
  (apply 
    str
    (map encode-char 
         (string/lower-case chunk))))

(defn- extract-chunks [text]
  (map (partial apply str) 
       (partition 5 5 nil text)))

(defn- remove-punctuation [text]
  (filter 
    #(or (Character/isDigit %) (Character/isLetter %)) 
    text))

(def ^:private encode-chunks 
  (partial map encode-chunk))

(defn encode [text]
  (string/join 
    " " 
    (encode-chunks 
         (extract-chunks 
           (remove-punctuation text)))))

;; Same using ->> macro
; (defn encode [text]
;   (->> 
;     text
;     (remove-punctuation)
;     (extract-chunks)
;     (encode-chunks)
;     (string/join " ")))
