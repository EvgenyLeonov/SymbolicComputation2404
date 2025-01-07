(ns week13.labyrinth
  (:require [week13.labyrinth-data :as labyrinth-data]))

(defn dfs
  [current_node visited_nodes all_nodes all_edges]
  (when current_node
    (println (str "Visiting node: " (:name current_node)))
    (if (:find_me current_node)
      (println "Minotaur is here!")
      (doseq [edge all_edges
              :when (= (:node_from edge) (:name current_node))
              :let [next_node (first (filter #(= (:name %) (:node_to edge)) all_nodes))]
              :when (not (contains? visited_nodes next_node))
              :let [visited_nodes_updated (conj visited_nodes current_node)]
              ]
        (dfs next_node visited_nodes_updated all_nodes all_edges)))))

(defn dfs_search
  [start_node all_nodes all_edges]
  (dfs start_node (set [start_node]) all_nodes all_edges))

(def start_point (first labyrinth-data/all_nodes))
(dfs_search start_point labyrinth-data/all_nodes labyrinth-data/all_edges)

