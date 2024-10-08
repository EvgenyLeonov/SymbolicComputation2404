(ns week03.conditions)

(defn if-else [x]
  (if (= x 5)
    (println "x equals 5")
    (println "x not equals 5")
    )
  )

(defn if-else-mult [x]
  (if (= x 5)
    (do
      (println "x equals 5")
      (println "bla bla")
      )
    (println "x not equals 5")
    )
  )

(defn cond-example [x]
  (cond
    (< x 3) "x is less than 3"
    (= x 5) "x equals 5"
    :else "x is something else"
    )
  )

;(if-else 5)

;(if-else-mult 5)

(println (cond-example 1000))
