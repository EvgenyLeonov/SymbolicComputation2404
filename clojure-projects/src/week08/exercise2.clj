(ns week08.exercise2)


(println "1."  (= [95 96 97 98 99]
                  (drop __ (range 100))))

(println "2."  (= __ (take 8 (iterate (fn [x] (* x 2)) 1))))

(println "3."  (= [:a :a :a :a :a :a :a :a :a :a]
                  (repeat 10 __)))

(println "4."  (= (repeat 100 "hello")
                  (take 100 (iterate ___ "hello"))))

