(ns week07.bfs
  (:require [week07.binary-tree-data :as tree-data])
  )

(defn prepare_new_queue [queue left_node right_node]
  (vec
    (filter #(not= % nil) (rest (conj queue left_node right_node)))
    )
  )

(defn bfs_traverse [root_node]
  (loop [queue (vector root_node)]
    (let [current_node (first queue)]
      (when-not (nil? current_node)
        (let [left_node (:left_node current_node)
              right_node (:right_node current_node)
              new_queue (prepare_new_queue queue left_node right_node)]
          (println "new_queue =" new_queue)
          (println (:name current_node) "is visited")

          (recur new_queue)
          )
        )
      )
    )
  )

(bfs_traverse (tree-data/create_tree_advanced))
