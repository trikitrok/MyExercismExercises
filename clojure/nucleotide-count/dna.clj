(ns dna)

(def dna-nucleotides #{\A, \T, \C, \G})

(def nucleotides (conj dna-nucleotides \U))

(defn nucleotide-counts [strand]
  (let
    [counted-nucleotides 
     (zipmap dna-nucleotides (repeat (count dna-nucleotides) 0))
     
     count 
     (fn [counted-nucleotides nucleotide]
       (assoc 
         counted-nucleotides 
         nucleotide
         (+ (get counted-nucleotides nucleotide) 1)))]
    
    (reduce count counted-nucleotides strand)))

(defn count [nucleotide strand] 
  (if (contains? nucleotides nucleotide)
    (get (nucleotide-counts strand) nucleotide 0)
    (throw (Exception. "invalid nucleotide"))))
