(ns week05.exercise2)

(def atomic-clock (atom 0))

(println "1."  (= __ @atomic-clock))

(println "2."  (= __ (do
                       (swap! atomic-clock inc)
                       @atomic-clock)))

(println "3."  (= 5 (do
                      __
                      @atomic-clock)))

(println "4."  (= __ (do
                       (swap! atomic-clock + 1 2 3 4 5)
                       @atomic-clock)))

(println "5."  (= __ (do
                       (compare-and-set! atomic-clock 100 :fin)
                       @atomic-clock)))

(println "6."  (= :fin (do
                         (compare-and-set! __ __ __)
                         @atomic-clock)))


