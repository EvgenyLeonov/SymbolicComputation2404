(ns week06.fast-slow-pointers
  (:require [week06.linked-list :as ll])
  )

(defn find_middle_node_atoms [head]
  (let [slow (atom head)
        fast (atom head)]
    (while (and (some? @fast) (some? (:next_node @fast)))
      (println "slow = " (:name @slow))
      (println "fast = " (:name @fast))
      (reset! slow (:next_node @slow))
      (reset! fast (:next_node (:next_node @fast)))
      )

    (println "middle = " (:name @slow))
    )
  )

(defn find_middle_node_recur [head]
  (loop [slow head
         fast head]
    (if (and (some? fast) (some? (:next_node fast)))
      (do
        (println "slow = " (:name slow))
        (println "fast = " (:name fast))
        (recur (:next_node slow) (:next_node (:next_node fast)))
        )
      (println "middle = " (:name slow))
      )
    )
  )

(find_middle_node_atoms (ll/create_linked_list))

(println "======")

(find_middle_node_recur (ll/create_linked_list))





