(ns week08.exercise1)

(def a-list
  '(1 2 3 4 5))

(def a-list-with-maps
  '({:a 1} {:a 2} {:a 3}))

(defn function-that-takes-a-map [map a b]
  (get map :a))

(defn function-that-takes-a-coll [a b coll]
  (map :a coll))

(println "1."  (= __
                  (-> {}
                      (assoc :a 1))))

(println "2."   (= __
                   (-> "Hello world"
                       (str ", and moon")
                       (str ", and stars"))))

(println "3."  (= __
                  (-> "String with a trailing space "
                      clojure.string/trim)))

(println "4."  (= __
                  (-> {}
                      (assoc :a 1)
                      (assoc :b 2)
                      (assoc :c {:d 4
                                 :e 5})
                      (update-in [:c :e] inc)
                      (get-in [:c :e]))))

(println "5."  (= __
                  (-> {}
                      (assoc :a 1)
                      (function-that-takes-a-map "hello" "there"))))

(println "6."  (= __
                  (->> [1 2 3]
                       (map inc))))

(println "7."  (= __
                  (->> a-list
                       (map inc)
                       (filter even?)
                       (into [])
                       (reduce +))))

(println "8."  (= __
                  (->> a-list-with-maps
                       (function-that-takes-a-coll "hello" "there")
                       (into []))))

