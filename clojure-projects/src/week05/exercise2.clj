(ns week05.exercise2)

(def atomic-clock (atom 0))

(println "1."  (= 0 @atomic-clock))

(println "2."  (= 1 (do
                       (swap! atomic-clock inc)
                       @atomic-clock)))

(println "3."  (= 5 (do
                      (reset! atomic-clock 5)
                      @atomic-clock)))

(println "4."  (= 20 (do
                       (swap! atomic-clock + 1 2 3 4 5)
                       @atomic-clock)))

(println "5."  (= 20 (do
                       (compare-and-set! atomic-clock 100 :fin)
                       @atomic-clock)))

(println "6."  (= :fin (do
                         (compare-and-set! atomic-clock 20 :fin)
                         @atomic-clock)))


