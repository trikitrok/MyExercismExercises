(ns leap)

(defn leap-year? [year]
  (let
    [divisible-by? (comp zero? (partial rem year))]
    
    (or 
      (divisible-by? 400)
      (and 
        (divisible-by? 4)
        (not (divisible-by? 100))))))