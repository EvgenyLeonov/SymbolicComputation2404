(ns week07.tree-data)

(defrecord Node [name find_me])

(defrecord Edge [node1 node2])

(def all_nodes
  [(Node. "root" false)
   (Node. "1" false)
   (Node. "2" false)
   (Node. "3" false)
   (Node. "4" true)
   (Node. "5" false)
   (Node. "6" false)
   (Node. "7" false)]
  )

(def all_edges
  [(Edge. "root" "1")
   (Edge. "root" "5")
   (Edge. "root" "7")
   (Edge. "1" "2")
   (Edge. "2" "3")
   (Edge. "2" "4")
   (Edge. "5" "6")]
  )

(defn get_node_by_name [node_name all_nodes]
  (first (filter #(= (:name %) node_name) all_nodes))
  )

;(println (get_node_by_name "root" all_nodes))

(defn get_edges_for_node [node_name all_edges]
  (filter #(= (:node1 %) node_name) all_edges)
  )

;(println "edges for root" (get_edges_for_node "root" all_edges))

; it returns nodes, not their name
(defn get_children_for_node [node_name all_nodes all_edges]
  (let [edges_for_this_node (get_edges_for_node node_name all_edges)
        children (map #(get_node_by_name (:node2 %) all_nodes) edges_for_this_node)]
    children
    )
  )

;(println "children for root" (get_children_for_node "root" all_nodes all_edges))


