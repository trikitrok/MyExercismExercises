(ns binary-search-tree)

(defn singleton [val]
  {:value val})

(def value :value)
(def left :left)
(def right :right)

(defn insert [val tree]
  (let [add-node
        (fn [location node]
          (assoc tree location
                      (if node (insert val node)
                               (singleton val))))]
    (if (<= val (value tree))
      (add-node :left (left tree))
      (add-node :right (right tree)))))

(defn from-list [[root & rest-nodes]]
  (reduce #(insert %2 %1) (singleton root) rest-nodes))

(defn to-list [tree]
  (if tree
    (concat (to-list (left tree))
            [(value tree)]
            (to-list (right tree)))
    []))

;(defn to-list
;  ([tree] (to-list [] tree))
;  ([acc tree]
;    (cond
;      (and (left tree) (not (right tree)))
;      (conj (to-list acc (left tree)) (value tree))
;
;      (and (not (left tree)) (right tree))
;      (to-list (conj acc (value tree)) (right tree))
;
;      (and (left tree) (right tree))
;      (to-list (conj (to-list acc (left tree)) (value tree)) (right tree))
;
;      :else (conj acc (value tree)))))