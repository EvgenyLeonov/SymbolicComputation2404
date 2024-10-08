(ns week03.exercise1)

(defn my-func [x]
  (case x
    :a "a"
    :b "b"
    :c "c"
    "something else"))

(println "1." (= __ (if (false? (= 4 5))
                      :a
                      :b)))

(println "2." (= __ (if (> 4 3)
                      [])))

(println "3." (= __ (if (nil? 0)
                      [:a :b :c])))

(println "4." (= :cat (if (not (empty? ()))
                          :dog
                          __)))

(let [x 10]
  (println "5." (= :parrot (cond (= x __) :cat
                                    (= x __) :dog
                                    :else __)))
  )


(println "6." (= 'cat (if-not (zero? __)
                         'cat
                         'dog)))

(println "7." (= "something else"
                 (my-func __)))

(println "8." (= __
                 (my-func :b)))





