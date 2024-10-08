(ns week02.exercise1
  (:require [clojure.set :as set])
  )

; LISTS

(println "1."  (= '(__ __ __ __ __) (list 1 2 3 4 5)))

(println "2." (= __ (first '(1 2 3 4 5))))

(println "3." (= __ (rest '(1 2 3 4 5))))

(println "4." (= __ (rest '(100))))

(println "5." (= __ (cons :a '(:b :c :d :e))))

(println "6." (= __ (conj '(:a :b :c :d) :e)))

; VECTORS

(println "7." (= __ (count [42])))

(println "8." (= __ (vec '(1))))

(println "9." (= __ (vector nil nil)))

(println "10." (= [1 __] (vec '(1 2))))

; Note: function 'conj' works differently for lists and for vectors

(println "11." (= __ (conj [111 222] 333)))

(println "12." (= __ (first [:peanut :butter :and :jelly])))

(println "13." (= __ (last [:peanut :butter :and :jelly])))

(println "14." (= __ (nth [:peanut :butter :and :jelly] 3)))

(println "15." (= __ (subvec [:peanut :butter :and :jelly] 1 3)))

(println "16." (= (list 1 2 3) (vector 1 2 __)))

; SETS

(println "17." (= #{3} (set __)))

(println "18." (= __ (count #{1 2 3})))

(println "19." (= __ (set '(1 1 2 2 3 3 4 4 5 5))))

(println "20." (= __ (set/union #{1 2 3 4} #{2 3 5})))

(println "21." (= __ (set/intersection #{1 2 3 4} #{2 3 5})))

(println "22." (= __ (set/difference #{1 2 3 4 5} #{2 3 5})))

; MAPS
(println "23." (= {:a 1 :b 2} (hash-map :a 1 __ __)))

(println "24." (= __ (count {:a 1 :b 2})))

(println "25." (= __ (get {:a 1 :b 2} :b)))

(println "26." (= __ ({:a 1 :b 2} :a)))

(println "27." (= __ (:a {:a 1 :b 2})))

(println "28." (= __ ({1980 "John" 1987 "Mary" 2004 "Mike"} 2004)))

(println "29." (= __ (get {:a 1 :b 2} :c :key-not-found)))

(println "30." (= __ (contains? {:a nil :b nil} :b)))

(println "31." (= __ (contains? {:a nil :b nil} :c)))

(println "32." (= {1 "January" 2 __} (assoc {1 "January"} 2 "February")))

(println "33." (= {__ __} (dissoc {1 "January" 2 "February"} 2)))

(println "34." (= {:a 1 :b 2 __ __} (merge {:a 1 :b 2} {:c 3})))


