#lang racket

(define (grains)
  (letrec
      ([f 
        (lambda (n) 
          (cons n 
                (lambda () (f (* 2 n)) )))])
    (f 1)))

(define (stream-for-n-steps stream n) 
  (letrec ([f 
            (lambda(i stream-rest)  
              (if (= i 0) 
                  empty
                  (cons (car (stream-rest)) 
                        (f (- i 1) (cdr (stream-rest))))))])
    (f n stream)))

(define (square sqr-num)
  (last (stream-for-n-steps grains sqr-num)))

(define total-grains
  (lambda ()
    (foldr + 0 (stream-for-n-steps grains 64))))
