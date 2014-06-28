(ns school)

(defn grade [school grade-num]
  (get school grade-num []))

(defn add [school name grade-num]
  (assoc 
    school 
    grade-num 
    (conj (grade school grade-num) name)))

(defn sorted [school]
  (let
    [sort-by-grades 
     (partial sort-by key)
     
     sort-students-by-name
     (partial map 
              (fn [[grade students]] 
                [grade (sort students)]))]
    
    (into 
      {}
      (->
        school
        sort-by-grades
        sort-students-by-name))))