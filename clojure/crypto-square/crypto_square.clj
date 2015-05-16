(ns crypto-square
  (:require [clojure.string :as clj-str]))

(defn- remove-punctuation [text]
  (apply str (re-seq #"\w+" text)))

(defn normalize-plaintext [text]
  (->> text
       remove-punctuation
       clj-str/lower-case))

(defn square-size [text]
  (int (Math/ceil (Math/sqrt (count text)))))

(defn plaintext-segments [text]
  (let [normalized-text (normalize-plaintext text)
        segment-size (square-size normalized-text)]
    (map clj-str/join (partition-all segment-size normalized-text))))

(defn- pad-segments [segments segments-size]
  (map #(format (str "%-" segments-size "s") %) segments))

(defn- segments-in-columns [text]
  (let [segments (plaintext-segments text)
        segment-size (count (first segments))]
    (apply map
           #(clj-str/trim (apply str %&))
           (pad-segments segments segment-size))))

(defn- remove-spaces [text]
  (clj-str/replace text " " ""))

(defn normalize-ciphertext [text]
  (->> text
       segments-in-columns
       (clj-str/join " ")))

(defn ciphertext [text]
  (remove-spaces (normalize-ciphertext text)))