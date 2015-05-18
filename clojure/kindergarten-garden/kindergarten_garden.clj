(ns kindergarten-garden)

(def ^:private plants
  {\R :radishes \C :clover \G :grass \V :violets})

(def ^:private default-children
  [:alice :bob :charlie :david
   :eve :fred :ginny :harriet
   :ileana :joseph :kincaid :larry])

(def ^:private get-plants
  (partial map #(get plants %)))

(defn- plants-rows [diagram]
  (map #(vec (get-plants %))
       (clojure.string/split diagram #"\n")))

(defn- plants-per-child-in-rows [child-index rows]
  (vec
    (flatten
      (map #(vector (get % child-index) (get % (inc child-index))) rows))))

(defn- plants-per-child [diagram]
  (let [num-cols (.indexOf diagram "\n")]
    (map #(plants-per-child-in-rows (* 2 %) (plants-rows diagram))
         (range 0 (quot num-cols 2)))))

(def ^:private lowercase-all
  (partial map #(clojure.string/lower-case %)))

(def ^:private strs->keys
  (partial map #(keyword %)))

(defn- children-keys [children-strs]
  (->> children-strs
       lowercase-all
       sort
       strs->keys))

(defn- make-garden [children diagram]
  (zipmap children (plants-per-child diagram)))

(defn garden
  ([diagram]
   (make-garden default-children diagram))

  ([diagram children-strs]
   (make-garden (children-keys children-strs) diagram)))