(ns meetup)

(defn leap? [year]
  (let
    [divisible-by? (comp zero? (partial rem year))]    
    (or 
      (divisible-by? 400)
      (and 
        (divisible-by? 4)
        (not (divisible-by? 100))))))

(defn get-months-accum-days-moduli [year month]
  (let
    [months-accum-days-moduli-year
     [0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5]
     months-accum-days-moduli-leap-year
     [0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6]]
    (if (leap? year) 
      (nth months-accum-days-moduli-leap-year (- month 1))
      (nth months-accum-days-moduli-year (- month 1)))))

(defrecord Date [year month day])

(defn compute-week-day [{year :year month :month day :day}]
  (let
    [div1 (quot (- year 1) 4)
     div2 (quot (- year 1) 100)
     div3 (quot (+ div2 1) 4)
     div4 (int (- div1 (* 3 div3)))
     week-day (rem 
                (+ (rem (- year 1) 7)
                   (rem div4 7)
                   (get-months-accum-days-moduli year month)
                   (rem day 7)) 
                7)]
    (if (zero? week-day) 7 week-day)))

(defn last-day-in-month [month year]
  (let
    [last-days-in-months
     [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
     last-day (nth last-days-in-months (- month 1))]
    (if (and (leap? year) (= month 2))
      (+ 1 last-day)
      last-day)))

(defn dates-in-month [month year] 
  (map (fn [day] (Date. year month day)) 
       (range 1 (+ (last-day-in-month month year) 1))))

(defn is-week-day? [week-day date]
  (let
    [week-days {'mon 1 'tues 2 'wednes 3 'thurs 4 'fri 5 'satur 6 'sun 7}]
    (= (week-days week-day) (compute-week-day date))))

(defn is-teenth? [{day :day}] 
  (let
    [teenth-days (set (range 13 20))]
    (teenth-days day)))

(defn days-of-month-that-is [week-day]
  (comp (partial filter (partial is-week-day? week-day)) dates-in-month))

(defn day-teenth [week-day]
  (comp vec 
        vals 
        first
        (partial filter #(is-teenth? %))
        (days-of-month-that-is week-day)))

(defn third [ls] (nth ls 2))

(defn fourth [ls] (nth ls 3))

(defn get-week-day [pos week-day]
  (comp vec 
        vals 
        pos
        (days-of-month-that-is week-day)))

(def week-days-str ["mon" "tues" "wednes" "thurs" "fri" "satur" "sun"])

(doall
  (map 
    #(intern 'meetup (symbol (str % "teenth")) (day-teenth (symbol %))) 
    week-days-str))

(def func-names ["first" "second" "third" "fourth" "last"])

(doall
  (map 
    #(intern 
       'meetup 
       (symbol (str (first %) "-" (second %) "day"))
       (get-week-day (resolve (symbol(first %))) (symbol (second %)))) 
    (for [x func-names y week-days-str] [x y])))
