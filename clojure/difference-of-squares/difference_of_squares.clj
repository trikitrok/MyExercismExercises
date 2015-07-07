(ns difference-of-squares)

(def ^:private naturals
  (drop 1 (range)))

(def ^:private sum
  (partial reduce +))

(defn- square [n]
  (* n n))

(def ^:private square-all
  (partial map square))

(defn square-of-sums [n]
  (->> (take n naturals)
       sum
       square))

(defn sum-of-squares [n]
  (->> (take n naturals)
       square-all
       sum))

(defn difference [n]
  (- (square-of-sums n)
     (sum-of-squares n)))