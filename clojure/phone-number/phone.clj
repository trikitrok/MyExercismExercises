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

(def to-str (partial apply str))

(def number (comp to-str extract-digits))

(def area-code-digits (comp (partial take 3) extract-digits))

(def area-code (comp to-str area-code-digits))

(def extension-digits (comp (partial drop 3) (partial take 10)))

(defn pretty-extension [extension-digits]
  (to-str 
    (concat 
      (take 3 extension-digits)
      "-"
      (drop 3 extension-digits))))

(defn pretty-area-code [area-code]
  (to-str "(" area-code ")"))

(defn pretty-print [number-to-print]
  (let 
    [digits (extract-digits number-to-print)]
    (to-str 
      (pretty-area-code (area-code digits))
      " "
      (pretty-extension (extension-digits digits)))))