(ns week03.exercise2)

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(println "1." (= 81 (square 9)))

(println "2." (= 20 (multiply-by-ten 2)))

(println "3." (= 10 ((fn [n] (* 5 n)) 2)))

(println "4." (= 60 (#(* 15 %) 4)))

(println "5." (= 15 (#(+ %1 %2 %3) 4 5 6)))

(println "6." (= "AACC" (#(str "AA" %2) "bb" "CC")))

; HINT: one function can return another (not execute!)
(println "7." (= 9 (((fn [] +)) 4 5)))

; HINT you may use function as argument
(println "8." (= 20 ((fn [f] (f 4 5)) *)))

; HINT write another function that accepts this one (with n) as argument
(println "9." (= 25 (#(% 5) (fn [n] (* n n)))))

; HINT see the previous one
(println "10." (= 25 (#(% 5) square)))

