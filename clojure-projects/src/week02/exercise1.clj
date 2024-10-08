(ns week02.exercise1
  (:require [clojure.set :as set])
  )

; LISTS

(println "1."  (= '(1 2 3 4 5) (list 1 2 3 4 5)))

(println "2." (= 1 (first '(1 2 3 4 5))))

(println "3." (= '(2 3 4 5) (rest '(1 2 3 4 5))))

(println "4." (= '() (rest '(100))))

(println "5." (= '(:a :b :c :d :e) (cons :a '(:b :c :d :e))))

(println "6." (= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e)))

; VECTORS

(println "7." (= 1 (count [42])))

(println "8." (= [1] (vec '(1))))

(println "9." (= [nil nil] (vector nil nil)))

(println "10." (= [1 2] (vec '(1 2))))

; Note: function 'conj' works differently for lists and for vectors

(println "11." (= [111 222 333] (conj [111 222] 333)))

(println "12." (= :peanut (first [:peanut :butter :and :jelly])))

(println "13." (= :jelly (last [:peanut :butter :and :jelly])))

(println "14." (= :jelly (nth [:peanut :butter :and :jelly] 3)))

(println "15." (= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3)))

(println "16." (= (list 1 2 3) (vector 1 2 3)))

; SETS

(println "17." (= #{3} (set '(3))))

(println "18." (= 3 (count #{1 2 3})))

(println "19." (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5))))

(println "20." (= #{1 2 3 4 5} (set/union #{1 2 3 4} #{2 3 5})))

(println "21." (= #{2 3} (set/intersection #{1 2 3 4} #{2 3 5})))

(println "22." (= #{1 4} (set/difference #{1 2 3 4 5} #{2 3 5})))

; MAPS
(println "23." (= {:a 1 :b 2} (hash-map :a 1 :b 2)))

(println "24." (= 2 (count {:a 1 :b 2})))

(println "25." (= 2 (get {:a 1 :b 2} :b)))

(println "26." (= 1 ({:a 1 :b 2} :a)))

(println "27." (= 1 (:a {:a 1 :b 2})))

(println "28." (= "Mike" ({1980 "John" 1987 "Mary" 2004 "Mike"} 2004)))

(println "29." (= :key-not-found (get {:a 1 :b 2} :c :key-not-found)))

(println "30." (= true (contains? {:a nil :b nil} :b)))

(println "31." (= false (contains? {:a nil :b nil} :c)))

(println "32." (= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February")))

(println "33." (= {1 "January"} (dissoc {1 "January" 2 "February"} 2)))

(println "34." (= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3})))


