(ns week05.fibonacci)

(defn fibonacci [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))
    )
  )

(println (fibonacci 40))

;takes too much time
;(println (fibonacci 40))


