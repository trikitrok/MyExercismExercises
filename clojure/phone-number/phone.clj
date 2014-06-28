(ns phone)

(defn extract-digits [phone-number]
  (let 
    [digits (filter #(Character/isDigit %) phone-number)
     digits-length (count digits)]
    (cond 
      (= digits-length 10) digits
      (and (= digits-length 11) 
           (= (first digits) \1)) (rest digits)
      :else (repeat 10 0))))

(defn number [phone-number]
  (apply str (extract-digits phone-number)))

(defn area-code-digits [phone-number]
  (take 3 (extract-digits phone-number)))

(defn area-code [phone-number]
  (apply str (area-code-digits phone-number)))

(defn pretty-print [number-to-print]
  (let 
    [digits (extract-digits number-to-print)]
    (apply str 
           (concat "(" (area-code-digits digits) ") "
             (drop 3 (take 6 digits))
             "-"
             (drop 6 (take 10 digits))))))