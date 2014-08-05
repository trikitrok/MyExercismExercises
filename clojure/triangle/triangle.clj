(ns triangle)

(defn- equilateral? [a b c]
  (= a b c))

(defn- isosceles? [a b c]
  (or (= a b) (= b c) (= a c)))

(defn- triangle? [a b c]
  (and
    (< a (+ b c))
    (< b (+ a c))
    (< c (+ b a))))

(defn type [a b c]
  (cond 
    (not (triangle? a b c)) :illogical
    (equilateral? a b c) :equilateral
    (isosceles? a b c) :isosceles
    :else :scalene))