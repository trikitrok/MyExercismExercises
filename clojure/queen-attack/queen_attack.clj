(ns queen-attack
  (:require [clojure.string :as clj-str]))

(def ^:private empty-board
  (vec (repeat 8 (vec (repeat 8 "O")))))

(defn- add-to-board [position representation board]
  (if position
    (assoc-in board position representation)
    board))

(defn- board [{white-queen-position :w black-queen-position :b}]
  (->> empty-board
       (add-to-board white-queen-position "W")
       (add-to-board black-queen-position "B")))

(defn board-string [queens]
  (str (clj-str/join
         "\n"
         (map #(clj-str/join " " %) (board queens)))
       "\n"))

(defn- in-same-rank? [[white-queen-rank _] [black-queen-rank _]]
  (= white-queen-rank black-queen-rank))

(defn- in-same-column? [[_ white-queen-col] [_ black-queen-col]]
  (= white-queen-col black-queen-col))

(defn- in-same-diagonal? [[white-queen-rank white-queen-col]
                          [black-queen-rank black-queen-col]]
  (= 1 (quot (- white-queen-rank black-queen-rank)
             (- white-queen-col black-queen-col))))

(defn can-attack [{white-queen-pos :w black-queen-pos :b}]
  (or (in-same-column? white-queen-pos black-queen-pos)
      (in-same-rank? white-queen-pos black-queen-pos)
      (in-same-diagonal? white-queen-pos black-queen-pos)))