(ns week04.exercise1)

(println "1." (= [__ __ __] (map (fn [x] (* 4 x)) [1 2 3])))

(println "2." (= [1 4 9 16 25] (map (fn [x] __) [1 2 3 4 5])))

(println "3." (= __ (map nil? [:a :b nil :c :d])))

(println "4." (= __ (filter (fn [x] false) '(:anything :goes :here))))

(println "5." (= __ (filter (fn [x] true) '(:anything :goes :here))))

(println "6." (= [10 20 30] (filter (fn [x] __) [10 20 30 40 50 60 70 80])))

(println "7." (= [10 20 30] (map (fn [x] __) (filter (fn [x] __) [1 2 3 4 5 6 7 8]))))

(println "8." (= __ (reduce (fn [a b] (* a b)) [1 2 3 4])))

(println "9." (= 2400 (reduce (fn [a b] (* a b)) __ [1 2 3 4])))

(println "10." (= "longest" (reduce (fn [a b]
                                     (if (< __ __) b a))
                                   ["which" "word" "is" "longest"])))