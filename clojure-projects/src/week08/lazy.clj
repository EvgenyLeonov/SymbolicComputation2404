(ns week08.lazy)

; get a random int [0; limit)
(defn random_ints [limit]
  (lazy-seq
    (println "request lazy number")
    (cons (rand-int limit) (random_ints limit))
    )
  )

(def values (take 1000 (random_ints 50)))

(println (nth values 500))


