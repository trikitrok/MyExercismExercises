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
    [week-days {:MON 1 :TUE 2 :WED 3 :THU 4 :FRI 5 :SAT 6 :SUN 7}]
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

(def monteenth (day-teenth :MON))
(def tuesteenth (day-teenth :TUE))
(def wednesteenth (day-teenth :WED))
(def thursteenth (day-teenth :THU))
(def friteenth (day-teenth :FRI))
(def saturteenth (day-teenth :SAT))
(def sunteenth (day-teenth :SUN))

(defn get-week-day [pos week-day]
  (comp vec 
        vals 
        pos
        (days-of-month-that-is week-day)))

(def first-monday (get-week-day first :MON))
(def first-tuesday (get-week-day first :TUE))
(def first-wednesday (get-week-day first :WED))
(def first-thursday (get-week-day first :THU))
(def first-friday (get-week-day first :FRI))
(def first-saturday (get-week-day first :SAT))
(def first-sunday (get-week-day first :SUN))

(def second-monday (get-week-day second :MON))
(def second-tuesday (get-week-day second :TUE))
(def second-wednesday (get-week-day second :WED))
(def second-thursday (get-week-day second :THU))
(def second-friday (get-week-day second :FRI))
(def second-saturday (get-week-day second :SAT))
(def second-sunday (get-week-day second :SUN))

(defn third [ls] (nth ls 2))

(def third-monday (get-week-day third :MON))
(def third-tuesday (get-week-day third :TUE))
(def third-wednesday (get-week-day third :WED))
(def third-thursday (get-week-day third :THU))
(def third-friday (get-week-day third :FRI))
(def third-saturday (get-week-day third :SAT))
(def third-sunday (get-week-day third :SUN))

(defn fourth [ls] (nth ls 3))

(def fourth-monday (get-week-day fourth :MON))
(def fourth-tuesday (get-week-day fourth :TUE))
(def fourth-wednesday (get-week-day fourth :WED))
(def fourth-thursday (get-week-day fourth :THU))
(def fourth-friday (get-week-day fourth :FRI))
(def fourth-saturday (get-week-day fourth :SAT))
(def fourth-sunday (get-week-day fourth :SUN))

(def last-monday (get-week-day last :MON))
(def last-tuesday (get-week-day last :TUE))
(def last-wednesday (get-week-day last :WED))
(def last-thursday (get-week-day last :THU))
(def last-friday (get-week-day last :FRI))
(def last-saturday (get-week-day last :SAT))
(def last-sunday (get-week-day last :SUN))