(ns week03.sorting-hat
  (:use [clojure.repl :only [doc source]])
  )

(defn get_house [n]
  (cond
    (and (>= n 0) (< n 25)) "Gryffindor"
    (and (>= n 25) (< n 50)) "Ravenclaw"
    (and (>= n 50) (< n 75)) "Hufflepuff"
    :else "Slytherin"
    )
  )

(def students ["Harry" "Ron" "Draco"])

(doseq [student students]
  (let [rand (rand-int 100)
        house (get_house rand)]
    (println (str student " >> " house))
    )
  )

; (source doseq)

; (source loop)
