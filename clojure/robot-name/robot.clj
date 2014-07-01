(ns robot)

(defn robot []
  (atom {:name ""}))

(defn robot-name [robot]
  (let
    [
     current-name 
     (:name @robot)
     
     random-name
     (fn [] 
       (let 
         [
          capital-letters 
          (map char (range (int \A) (+ (int \Z) 1)))
          
          num-letters 
          (count capital-letters)]
         
         (apply 
           str 
           (concat 
             (repeatedly 
               2 
               #(nth capital-letters (rand-int num-letters)))
             (repeatedly 
               3 
               #(rand-int 10))))))]
    
    (if (empty? current-name)
      (:name (swap! robot assoc :name (random-name)))
      current-name)))

(defn reset-name [robot]
  (swap! robot assoc :name ""))