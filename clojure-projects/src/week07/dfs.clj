(ns week07.dfs
  (:require [week07.tree-data :as tree-data])
  )

(defn dfs [node all_nodes all_edges]
  (if (true? (:find_me node))
    (do
      (println "found" (:name node))
      node
      )
    (let [children (tree-data/get_children_for_node (:name node) all_nodes all_edges)
          last_index (dec (count children))]
      (loop [index 0]
        (when (<= index last_index)
          (let [node_child (nth children index)
                _ (println (:name node_child) "visited")
                node_found (dfs node_child all_nodes all_edges)]
            (if (nil? node_found)
              (recur (inc index))
              node_found
              )
            )
          )
        )
      )
    )
  )

(def root_node (tree-data/get_node_by_name "root" tree-data/all_nodes))

(dfs root_node tree-data/all_nodes tree-data/all_edges)
