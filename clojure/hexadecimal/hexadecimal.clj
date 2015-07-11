(ns hexadecimal
  (:require [clojure.string :as str]))

(def ^:private ints-by-hex-digit
  (zipmap ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "a" "b" "c" "d" "e" "f"]
          [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]))

(defn- hex-digits [hex]
  (drop 1 (str/split hex #"")))

(defn hex-digit->int-digit [hex-digit]
  (get ints-by-hex-digit hex-digit))

(defn- valid-hex? [hex-digits]
  (every? (complement nil?)
          (map hex-digit->int-digit hex-digits)))

(defn- pow [base exp]
  (reduce * (repeat exp base)))

(defn- hex-in-position->int
  [position hex-digit]
  (* (hex-digit->int-digit hex-digit)
     (pow 16 position)))

(defn- reversed-hex-digits->int
  [reversed-hex-digits]
  (if (valid-hex? reversed-hex-digits)
    (reduce + (map-indexed hex-in-position->int
                           reversed-hex-digits))
    0))

(defn hex-to-int [hex]
  (->> hex
       hex-digits
       reverse
       reversed-hex-digits->int))