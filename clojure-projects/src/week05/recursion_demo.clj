(ns week05.recursion-demo)

(defn head_recursion [n]
  (when (> n 0)
    (head_recursion (dec n))
    )
  (println n)
  )

(defn tail_recursion [n]
  (println n)
  (when (> n 0)
    (tail_recursion (dec n))
    )
  )

(println "-- HEAD --")
(head_recursion 5)

(println "-- TAIL --")
(tail_recursion 5)