(ns week01.exercise1)

(println "1." (= true true))

(println "2." (= 2 (+ 1 1)))

(println "3." (= (+ 3 4) 7 (+ 2 5)))

; 2/1 is fraction but it equals 2
(println "4." (= true (= 2 2/1)))

; please check documentation about difference
; between = and == (remember difference === and == in JS)

(println "5." (= false (= 2 2.0)))

(println "6." (= true (== 2.0 2)))


