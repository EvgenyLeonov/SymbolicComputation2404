(ns week05.exercise1)

; HINT: zero is even number
(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n
         acc true]
    (if (= n 0)
      acc
      (recur (dec n) (not acc)))))

; HINT please don't use "reverse" function
(defn recursive-reverse [coll]
  (loop [index (dec (count coll))
         result []]
    (if (< index 0)
      result
      (recur (dec index) (conj result (get coll index)))
      )
    )
  )

; (println "recursive-reverse =" (recursive-reverse [1 2 3]))

(println "recursive-reverse set simple =" (recursive-reverse (sorted-set 5 7 2 7)))
(println "recursive-reverse set =" (apply list (recursive-reverse (vec (sorted-set 5 7 2 7)))))

(println "1." (= true (is-even? 0)))

(println "2." (= false (is-even? 1)))

(println "3." (= false (is-even-bigint? 100003N)))

(println "4." (= [1] (recursive-reverse [1])))

(println "5." (= [6 5 4 3 2] (recursive-reverse [2 3 4 5 6])))

; NOTE create your own functions for tasks 6-8. Please don't use "reverse" function

(println "6." (= (recursive-reverse [1 2 3 4 5]) [5 4 3 2 1]))

(println "7." (= (apply list (recursive-reverse (vec (sorted-set 5 7 2 7)))) '(7 5 2)))

(println "8." (= (recursive-reverse [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))
