(ns dna)

(def ^:private dna-nucleotides #{\A, \T, \C, \G})

(def ^:private nucleotides (conj dna-nucleotides \U))

(defn nucleotide-counts [strand]
  (merge {\A 0, \T 0, \C 0, \G 0} (frequencies strand)))

(defn count [nucleotide strand] 
  (if (contains? nucleotides nucleotide)
    (get (nucleotide-counts strand) nucleotide 0)
    (throw (Exception. "invalid nucleotide"))))
