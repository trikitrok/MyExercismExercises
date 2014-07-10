(ns grains)

(defn grains []  
  (letfn
    [(f [n]
        (seq [n (fn [] (f (* 2 n)))]))]
    (f 1N)))

(defn stream-for-n-steps [stream n]
  (letfn 
    [(f [i stream-rest]
        (let 
          [pair (stream-rest)]
          (when (not= i 0) 
            (cons (first pair)
                  (f (- i 1) (second pair))))))]
    (f n stream)))

(defn square [sqr-num]
  (last (stream-for-n-steps grains sqr-num)))

(defn total []
  (reduce + 0 (stream-for-n-steps grains 64)))