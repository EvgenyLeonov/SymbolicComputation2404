(ns week04.high-order-functions)

(def numbers [0 -3 10 40])

; MAP
(defn inc-all [numbers]
  (map inc numbers)
  )

(println "inc-all =" (inc-all numbers))

; REDUCE
(defn max-of-vector [numbers]
  (reduce max numbers)
  )

(println "max-of-vector =" (max-of-vector numbers))

; APPLY
(defn average [numbers]
  (/ (apply + numbers) (count numbers))
  )

(println "average =" (average numbers))

; also can be used for string concatenation
(println "numbers str #1 =" (str numbers))
(println "numbers str #2 =" (apply str numbers))

(defn multy [a b & args]
  (apply * a b args)
  )

(println "multy =" (multy 2 4 56 78 49 193 4995 32))

; PARTIAL
(defn inc_all_with_term
  [numbers term]
  (map (partial + term) numbers)
  )

(println "inc_all_with_term (partial) =" (inc_all_with_term numbers 1000))

(defn inc_all_with_term_2
  [numbers term]
  (map #(+ term %) numbers)
  )

(println "inc_all_with_term (anonymous function) =" (inc_all_with_term_2 numbers 1000))

