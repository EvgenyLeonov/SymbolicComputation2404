(ns week06.exercise1)

(defn get_odds_and_evens [coll]
  (let [{odds true evens false} (group-by __ coll)]
    [odds evens]))

(println "1."  (= __ (group-by count ["hello" "world" "foo" "bar"])))

(println "2."  (= (get_odds_and_evens [1 2 3 4 5])
                  ((juxt filter remove) odd? [1 2 3 4 5])
                  [[1 3 5] [2 4]]))

(println "3."  (= __
                  (group-by :id [{:id 1 :name "Bob"}
                                 {:id 2 :name "Jennifer"}
                                 {:id 1 :last-name "Smith"} ])))

(println "4."  (= {"Bob" [{:name "Bob" :id 1}]
                   "Jennifer" [{:name "Jennifer" :id 2}]
                   __ [{:last-name "Smith" :id 1}]}
                  (group-by :name [{:id 1 :name "Bob"}
                                   {:id 2 :name "Jennifer"}
                                   {:id 1 :last-name "Smith"}])))

(println "5."  (= __
                  (group-by #(if (:bad %) :naughty-list :nice-list)
                            [{:name "Jimmy" :bad true}
                             {:name "Jane" :bad false}
                             {:name "Joe" :bad true}])))


