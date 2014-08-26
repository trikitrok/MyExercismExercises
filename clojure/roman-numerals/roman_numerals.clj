(ns roman-numerals)

(declare huge-roman-numeral convert roman-symbols)

(defn numerals [arabic]
  (cond
    (<= arabic 10) (convert arabic :until-10)
    (<= arabic 100) (str (convert (quot arabic 10) :until-100) 
                         (numerals (mod arabic 10)))
    (<= arabic 1000) (str (convert (quot arabic 100) :until-1000)
                          (numerals (mod arabic 100)))
    (<= arabic 3999) (str (convert (quot arabic 1000) :until-3999)
                          (numerals (mod arabic 1000)))
    :else (huge-roman-numeral arabic)))

(def ^:private roman-symbols
  {:until-10 "IVX"
   :until-100 "XLC"
   :until-1000 "CDM"
   :until-3999 "M  "})

(defn- convert [arabic in-range]
  (let [[from medium to] (roman-symbols in-range)]
    (cond
      (= arabic 0) ""
      (= arabic 10) (str to (convert (- arabic 10) in-range))
      (= arabic 4) (str from medium)
      (>= arabic 9) (str from to (convert (- arabic 9) in-range))
      (>= arabic 5) (str medium (convert (- arabic 5) in-range))
      :else (str from (convert (- arabic 1) in-range)))))

(defn- thousand-bar [size]
  (str (apply str (repeat (count size) "-")) "\n"))

(defn- times-thousand [arabic]
  (loop [n arabic times 0]
    (if (<= n 3999)
      times
      (recur (quot n 1000) (+ times 1)))))

(defn- pow [m n]
  (reduce * (repeat n m)))

(defn- huge-roman-numeral [arabic]
  (let [times (times-thousand arabic)
        div (pow 1000 times)
        thousand-multiple (numerals (quot arabic div))
        horizontal-bar (thousand-bar thousand-multiple)]
    (str 
      (apply str (repeat times horizontal-bar))
      thousand-multiple
      (numerals (mod arabic div)))))