(ns week12.exercise1)

(defmulti multimethod-without-args
          (fn [keyword-arg] keyword-arg))

(defmethod multimethod-without-args :first [_]
  (str "Hello, World!"))

(defmethod multimethod-without-args :second [_]
  (str "Hello there"))

(defmulti multimethod-with-args
          (fn [opt-one opt-two] opt-one))

(defmethod multimethod-with-args :path-one [_ opts]
  (:first-opt opts))

(defmethod multimethod-with-args :path-two [_ opts]
  (let [numbers (:second-opt opts)]
    (->> numbers
         (map inc)
         (reduce +))))

(defmethod multimethod-with-args :path-three [_])

(println "1."  (= "Hello, World!"
                  (multimethod-without-args :first)))

(println "2."  (= "Hello there"
                  (multimethod-without-args :second)))

(println "3."  (= 1
                  (multimethod-with-args :path-one {:first-opt 1
                                                    :second-opt 2})))

(println "4."  (= 6
                  (multimethod-with-args :path-two {:first-opt 1
                                                    :second-opt [0 1 2]})))

