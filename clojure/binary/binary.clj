(ns binary)

(declare binary-digits pow is-binary)

(defn to-decimal [number-as-string]
  (if (is-binary number-as-string)
    (let 
      [binaries (binary-digits number-as-string)] 
      (reduce 
        + 
        (map 
          #(* %1 (pow 2 %2)) 
          binaries 
          (iterate dec (- (count binaries) 1)))))
    0))

(defn- binary-digits [number-as-string]
  (map #(Integer/parseInt (str %)) number-as-string))

(defn- pow [m n]
  (reduce * (repeat n m)))

(defn- is-binary [number-as-string]
  (every? #(or (= % \0) (= % \1)) number-as-string))