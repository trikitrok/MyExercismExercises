(ns largest-series-product)

(defn digits [string-of-digits]
  (map #(Integer/parseInt (str %))
       string-of-digits))

(defn slices [size string-of-digits]
  (partition size 1 (digits string-of-digits)))

(defn- compute-largest-product [size string-of-digits]
  (->> string-of-digits
       (slices size)
       (map (partial apply *))
       (apply max)))

(defn largest-product [size string-of-digits]
  (if (or (clojure.string/blank? string-of-digits)
          (> size (count string-of-digits)))
    1
    (compute-largest-product size string-of-digits)))