(ns school)

(defn grade [school grade-num]
  (get school grade-num []))

(defn add [school name grade-num]
  (assoc 
    school 
    grade-num 
    (conj (grade school grade-num) name)))

(defn sorted [school]
  (into {} 
        (map 
          (fn [[grade students]] 
            [grade (sort students)])
          (sort-by key school))))