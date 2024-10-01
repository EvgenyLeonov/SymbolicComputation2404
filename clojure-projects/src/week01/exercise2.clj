(ns week01.exercise2)

(println "1." (= nil nil))

(println "2." (= true (not (= 1 nil))))

(println "3." (= "hello" "hello"))

(println "4." (= "world" (str 'world)))

; char and strings are different types
; pay attention what exactly your function returns
(println "5." (= false (= \c "c")))




