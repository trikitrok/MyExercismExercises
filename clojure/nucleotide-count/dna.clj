(ns dna)

(def nucleotides #{\A, \T, \C, \G, \U})

(defn nucleotide-counts [strand]
  (let
    [count 
     (fn [counted-nucleotides nucleotide]
       (assoc 
         counted-nucleotides 
         nucleotide
         (+ (get counted-nucleotides nucleotide) 1)))]
    
    (reduce count {\A 0, \T 0, \C 0, \G 0} strand)))

(defn count [nucleotide strand] 
  (if (contains? nucleotides nucleotide)
    (get (nucleotide-counts strand) nucleotide 0)
    (throw (Exception. "invalid nucleotide"))))
