(ns dna)

(defn to-rna [nucleotides]
  (let 
    [transcribe-one 
     (fn [nucleotide]
       (let [transcriptions {\C \G 
                             \G \C
                             \A \U
                             \T \A}
             transcribed (get transcriptions nucleotide)]
         (if (nil? transcribed)
           (throw (AssertionError.))
           transcribed)))
     
     transcribe (comp (partial apply str) 
                      (partial map transcribe-one))]
    
    (transcribe nucleotides)))

