(ns etl)

(defn transform [data-set]
  (reduce 
    (fn [data [letters num]] 
      (reduce
        (fn [data letter]
          (assoc 
            data
            (clojure.string/lower-case letter) 
            num))
        data
        letters))
    {}
    (zipmap (vals data-set) (keys data-set))))