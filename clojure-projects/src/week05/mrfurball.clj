(ns week05.mrfurball)

(defn get_number_of_ancestors [generation]
  (cond
    (= generation 1) 2
    :else (* 2 (get_number_of_ancestors (dec generation)))
    )
  )

(def number_of_generation (quot 100 3))
(println "number_of_generation =" number_of_generation)
(println "numbers of cats for century =" (get_number_of_ancestors number_of_generation))
