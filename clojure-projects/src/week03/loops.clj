(ns week03.loops)

(loop [x 0]
  (if (not= x 10)
    (do
      (println "x =" x)
      (recur (inc x))
      )
    )
  )

(for [x1 [1 2 3]
      x2 ["a" "b" "c"]]
  (println x1 "and" x2)
  )



