(ns dna)

(defn hamming-distance [strand1 strand2]
  (reduce + 
          (map 
            (fn [base1 base2]
              (if (= base1 base2) 0 1))
            strand1 
            strand2)))