(ns week03.exercise1)

(defn my-func [x]
  (case x
    :a "a"
    :b "b"
    :c "c"
    "something else"))

(println "1." (= :a (if (false? (= 4 5))
                      :a
                      :b)))

(println "2." (= [] (if (> 4 3)
                      [])))

(println "3." (= nil (if (nil? 0)
                      [:a :b :c])))

(println "4." (= :cat (if (not (empty? ()))
                          :dog
                          :cat)))

(let [x 10]
  (println "5." (= :parrot (cond (= x 100) :cat
                                    (= x 300) :dog
                                    :else :parrot)))
  )


(println "6." (= 'cat (if-not (zero? 100)
                         'cat
                         'dog)))

(println "7." (= "something else"
                 (my-func :blabla)))

(println "8." (= "b"
                 (my-func :b)))





