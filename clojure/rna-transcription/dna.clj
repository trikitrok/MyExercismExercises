(ns dna)

(defn to-rna [nucleotides]
  (let 
    [transcribe 
     (fn [nucleotide]
       (let [transcriptions {\C \G 
                             \G \C
                             \A \U
                             \T \A}
             
             transcribed (get transcriptions nucleotide)]
         
         (if (nil? transcribed)
           (throw (AssertionError.))
           transcribed)))]
    
    (apply str (map transcribe nucleotides))))