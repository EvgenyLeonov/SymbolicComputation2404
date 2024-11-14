(ns week08.graph-of-might-magic)

; id - integer
(defrecord Node [id name])

(defrecord Edge [node_from node_to price])


(def all_nodes
  [(Node. 1 "Ore Mine")
   (Node. 2 "Blacksmith")
   (Node. 3 "Tavern")
   (Node. 4 "Well")
   (Node. 5 "House")
   (Node. 6 "Statue")
   (Node. 7 "Church")
   (Node. 8 "Foundry")]
  )

(def all_edges
  [(Edge. 1 2 9)
   (Edge. 1 3 2)
   (Edge. 2 4 4)
   (Edge. 3 4 3)
   (Edge. 3 5 5)
   (Edge. 5 6 6)
   (Edge. 4 6 6)
   (Edge. 4 7 8)
   (Edge. 6 8 4)]
  )

; DFS approach

(def routes (atom []))

(defn get_edges_for_node [node_id all_edges]
  (filterv #(or (= node_id (:node_from %)) (= node_id (:node_to %))) all_edges)
  )

; returns node_id (int)
(defn get_another_node_for_edge [node_id edge]
  (if (= node_id (:node_from edge))
    (:node_to edge)
    (:node_from edge)
    )
  )

(defn not-in? [coll item]
  (nil? (some #(= item %) coll))
  )

(defn filter_children_by_history [node_id edges history]
  (filterv #(not-in? history (get_another_node_for_edge node_id %)) edges)
  )

; history is a vector of node_ids (integers)
(defn process_node [node_id history all_edges target_node_id]
  (let [history_updated (conj history node_id)
        edges_from_this_node (get_edges_for_node node_id all_edges)
        children_to_go (filter_children_by_history node_id edges_from_this_node history_updated)
        ]
    (println "node_id =" node_id "; history_updated =" history_updated)
    (if (= node_id target_node_id)
      (swap! routes conj history_updated)
      ; child is Edge
      (doseq [child children_to_go]
        (process_node (get_another_node_for_edge node_id child) history_updated all_edges target_node_id)
        )
      )
    history_updated
    )
  )

; ore mine
(def start_node 1)

; foundry
(def target_node 8)

(process_node start_node [] all_edges target_node)

(println "routes:")
(println @routes)

(defn get_node_by_id [node_id all_nodes]
  (first (filter #(= (:id %) node_id) all_nodes))
  )

(defn get_edge_for_nodes [node1_id node2_id all_edges]
  (first
    (filter #(or
               (and (= node1_id (:node_from %)) (= node2_id (:node_to %)))
               (and (= node2_id (:node_from %)) (= node1_id (:node_to %)))
               ) all_edges))
  )

; example [1 2 4 6 8]
(defn calculate_route [route all_nodes all_edges]
  (loop [index 0
         price_total 0
         path ""]
    (if (< index (dec (count route)))
      (let [node_id (nth route index)
            node_next_id (nth route (inc index))
            node_name (:name (get_node_by_id node_id all_nodes))
            node_name_next (:name (get_node_by_id node_next_id all_nodes))
            edge (get_edge_for_nodes node_id node_next_id all_edges)
            price (:price edge)
            path_segment (str node_name " > " node_name_next " [" price "] | ")]
        (recur (inc index) (+ price_total price) (str path path_segment))
        )
      (vector path price_total (count route))
      )
    )
  )

(def routes_calculated (map #(calculate_route % all_nodes all_edges) @routes))

(println "routes calculates:")
(doseq [r routes_calculated]
  (println r)
  )


; DEBUG

; (println (get_edges_for_node start_node all_edges))

; (println (get_another_node_for_edge 3 (Edge. 1 3 2)))

; (println (filter_children_by_history start_node [(Edge. 1 2 9) (Edge. 1 3 2)] [2 3]))




