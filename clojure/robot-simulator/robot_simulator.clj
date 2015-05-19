(ns robot-simulator)

(defn robot [coordinates bearing]
  {:coordinates coordinates
   :bearing bearing})

(def ^:private turns
  {:right {:north :east
           :east :south
           :south :west
           :west :north}
   :left {:north :west
          :east :north
          :south :east
          :west :south}})

(defn- turn [direction current-bearing]
  (get-in turns [direction current-bearing]))

(defn turn-right [bearing]
  (turn :right bearing))

(defn turn-left [bearing]
  (turn :left bearing))

(def ^:private displacements
  {:north [0 1]
   :east [1 0]
   :south [0 -1]
   :west [-1 0]})

(defn- advance [{{:keys [x y]} :coordinates bearing :bearing}]
  (let [displacement (get displacements bearing [0 0])
        [x y] (map + [x y] displacement)]
    (robot {:x x :y y} bearing)))

(defn- right [{bearing :bearing :as rb}]
  (assoc rb :bearing (turn-right bearing)))

(defn- left [{bearing :bearing :as rb}]
  (assoc rb :bearing (turn-left bearing)))

(def ^:private commands
  {\R right
   \A advance
   \L left})

(defn simulate [[first-msg & rest-msg] rb]
  (if-let [comm (get commands first-msg)]
    (recur rest-msg (comm rb))
    rb))