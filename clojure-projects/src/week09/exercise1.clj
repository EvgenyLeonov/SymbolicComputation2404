(ns week09.exercise1)

(println "1."  (= '((0 1) (2 3)) (__ 2 (range 4))))

(println "2."  (= '(__) (partition 3 [:a :b :c :d :e])))

(println "3."  (= __ (partition-all 3 (range 5))))

(println "4."  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 __ (range 13))))

(println "5."  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [__] (range 7))))

(println "6."  (= '((0 1 2) (3 4 5) __) (partition 3 3 [:these :are "my" "words"] (range 7))))

(println "7."  (= '(("A") ("ABV") ("C") ("AB")) (partition-by __ ["A" "ABV" "C" "AB"])))

(println "8."  (= '(__) (partition-by identity "AABBBCCXXCCC")))


