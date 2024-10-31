(ns week06.threading-macros)

(def v 24)

(defn f1 [x]
  (- (/ x 2) 8))

(println "f1 =" (f1 v))

(defn f2 [x]
  (-> x
      (/ 2)
      (- 8)
      )
  )

(println "f2 =" (f2 v))

(defn f3 [x]
  (->> x
      (/ 2)
      (- 8)
      )
  )

(println "f3 =" (f3 v))

(println (-> "a"
             (str "b")
             (str "c")
             ))

(println (->> "a"
             (str "b")
             (str "c")
             ))

(defn group_sort [coll]
  (-> odd?
      (group-by coll)
      (get true)
      (->> (sort >))
      )
  )

(println "group_sort =" (group_sort [1 2 3 4 5]))








