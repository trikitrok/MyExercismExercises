 (ns accumulate)

 (defn accumulate [func coll]
   (reduce #(conj %1 (func %2)) [] coll))
