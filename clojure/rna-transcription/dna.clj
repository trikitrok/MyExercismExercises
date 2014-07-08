(ns dna)

(def ^:private transcriptions 
  {\C \G 
   \G \C
   \A \U
   \T \A})

(defn- transcribe [nucleotide]
  (if-let 
    [transcribed (get transcriptions nucleotide)]
    transcribed
    (throw (AssertionError.))))

(defn to-rna [nucleotides]
  (apply str (map transcribe nucleotides)))