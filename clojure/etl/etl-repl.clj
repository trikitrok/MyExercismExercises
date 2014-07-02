(def data-set {1 ["APPLE" "ARTICHOKE"] 2 ["BOAT" "BALLERINA"] })

(zipmap (vals data-set) (keys data-set))

(reduce
 (fn [new-data-set [letters num]]
   (reduce
    (fn [new-data-set letter]
      (assoc
        new-data-set
        (clojure.string/lower-case letter)
        num))
    new-data-set
    letters))
 {}
 (zipmap (vals data-set) (keys data-set)))

