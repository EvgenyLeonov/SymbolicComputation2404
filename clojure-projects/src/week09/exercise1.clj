(ns week09.exercise1)

(println "1."  (= '((0 1) (2 3)) (partition 2 (range 4))))

(println "2."  (= '((:a :b :c)) (partition 3 [:a :b :c :d :e])))

(println "3."  (= '((0 1 2) (3 4)) (partition-all 3 (range 5))))

(println "4."  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 5 (range 13))))

(println "5."  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [:hello] (range 7))))

(println "6."  (= '((0 1 2) (3 4 5) (6 :these :are)) (partition 3 3 [:these :are "my" "words"] (range 7))))

; (partition-by #(> (count %) 1)
(println "7."  (= '(("A") ("ABV") ("C") ("AB")) (partition-by count ["A" "ABV" "C" "AB"])))

(println "8."  (= '((\A \A) (\B \B \B) (\C \C) (\X \X) (\C \C \C)) (partition-by identity "AABBBCCXXCCC")))


