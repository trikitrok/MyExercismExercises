

(defn grains []
  (letfn
    [(f [n]
      (seq [n
            (fn [] (f (* 2 n)))]
            ))]
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

 (defn total-grains []
   (reduce + 0 (stream-for-n-steps grains 64)))

 (cons 3 (cons 4 nil))

 (first (grains))
 (first ((second (grains))) )
 (first ((second ((second (grains))))))


(stream-for-n-steps grains 8)

(square 1)
(square 2)
(square 3)
(square 4)

(total-grains)


