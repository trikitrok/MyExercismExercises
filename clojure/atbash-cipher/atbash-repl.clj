(ns atbash-cipher
  (:require [clojure.string :as string]))

(def latin-alphabet "abcdefghijklmnopqrstuvwxyz")

(seq latin-alphabet)

(reverse latin-alphabet)

(mapcat #(vector %1 %2)
     (seq latin-alphabet)
     (reverse latin-alphabet))

(zipmap
     (seq latin-alphabet)
     (reverse latin-alphabet))

(def cypher-by-letter
  (zipmap (seq latin-alphabet)
          (reverse latin-alphabet)))

(defn encode [text]
  (apply str (map #(get cypher-by-letter %) text)))

(encode "ml")

(encode "bvh")

(string/lower-case "O M G")

(defn- encode-chunk [chunk]
  (apply
    str
    (map #(get cypher-by-letter %)
         (string/lower-case chunk))))

(defn- extract-chunks [text]
  (map (partial apply str)
       (partition 5 5 nil text)))

(defn encode [text]
  (map encode-chunk
       (extract-chunks text)))

(extract-chunks "yes")

(extract-chunks "yesyesyes")

(encode-chunk "yes")

(encode "yes")
