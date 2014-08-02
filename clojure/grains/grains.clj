(ns grains)

(def grains (iterate #(* 2 %) 1N))

(defn square [sqr-num]
  (nth grains (- sqr-num 1)))

(defn total []
   (reduce + 0 (take 64 grains)))