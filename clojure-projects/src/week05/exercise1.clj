(ns week05.exercise1)

; HINT: zero is even number
(defn is-even? [n]
  (if (= n 0)
    __
    (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      __
      (recur (dec n) (not acc)))))

; HINT please don't use "reverse" function
(defn recursive-reverse [coll]
  __)

(println "1." (= __ (is-even? 0)))

(println "2." (= __ (is-even? 1)))

(println "3." (= __ (is-even-bigint? 100003N)))

(println "4." (= __ (recursive-reverse [1])))

(println "5." (= __ (recursive-reverse [2 3 4 5 6])))

; NOTE create your own functions for tasks 6-8. Please don't use "reverse" function

(println "6." (= (__ [1 2 3 4 5]) [5 4 3 2 1]))

(println "7." (= (__ (sorted-set 5 7 2 7)) '(7 5 2)))

(println "8." (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))




