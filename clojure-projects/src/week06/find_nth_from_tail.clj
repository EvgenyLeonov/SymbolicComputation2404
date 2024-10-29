(ns week06.find-nth-from-tail
  (:require [week06.linked-list :as ll])
  )

(defn move_fast_pointer_to_nth_from_head [head n]
  (loop [pointer head
         index 0]
    (if (< index n)
      (recur (:next_node pointer) (inc index))
      pointer
      )
    )
  )

(defn find_nth_from_tail [head n]
  (loop [slow head
         fast (move_fast_pointer_to_nth_from_head head n)]
    (println "slow = " (:name slow))
    (println "fast = " (:name fast))

    (if (and (some? fast) (some? (:next_node fast)))
      (recur (:next_node slow) (:next_node fast))
      (println "n =" n "; nth from tail = " (:name slow))
      )
    )
  )

(find_nth_from_tail (ll/create_linked_list) 3)
