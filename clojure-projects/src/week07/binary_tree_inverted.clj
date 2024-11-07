(ns week07.binary-tree-inverted
  (:require [week07.binary-tree-data :as tree-data])
  )

(defrecord Node [name left_node right_node])

; BFS

(defn prepare_new_queue [queue left_node right_node]
  (vec
    (filter #(not= % nil) (rest (conj queue left_node right_node)))
    )
  )

(defn print_binary_tree [root_node]
  (loop [queue (vector root_node)]
    (let [current_node (first queue)]
      (when-not (nil? current_node)
        (let [left_node (:left_node current_node)
              right_node (:right_node current_node)
              new_queue (prepare_new_queue queue left_node right_node)]
          (print (:name current_node))

          (recur new_queue)
          )
        )
      )
    )
  (println)
  )

(def tree_root_node (tree-data/create_tree_advanced))

(println "original tree:")
(print_binary_tree tree_root_node)


; DFS

(defn invert_binary_tree [node]
  (when (some? node)
    (let [node_name (:name node)
          left_node (:left_node node)
          right_node (:right_node node)
          left_node_inverted (invert_binary_tree left_node)
          right_node_inverted (invert_binary_tree right_node)
          ]
      (Node. node_name right_node_inverted left_node_inverted)
      )
    )
  )

(println "inverted tree:")
(print_binary_tree (invert_binary_tree tree_root_node))




