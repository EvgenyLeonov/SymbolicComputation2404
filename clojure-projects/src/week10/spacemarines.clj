(ns week10.spacemarines)

(defrecord Node [id name population])

; capacity -- transport capacity
(defrecord Edge [node_from node_to capacity])

(def all_nodes
  [
   (Node. 1 "Aurelia" 1000)
   (Node. 2 "Bracada" 1000)
   (Node. 3 "Celestia" 1000)
   (Node. 4 "Spaceport" 0)
   ]
  )

(def edges_by_hours [
                     [
                      (Edge. 1 2 100)
                      (Edge. 1 3 200)
                      (Edge. 2 3 200)
                      (Edge. 2 4 300)
                      (Edge. 3 4 100)
                      ]
                     [
                      (Edge. 1 2 100)
                      (Edge. 1 3 200)
                      (Edge. 2 4 300)
                      (Edge. 3 4 100)
                      ]
                     [
                      (Edge. 1 2 100)
                      (Edge. 1 3 200)
                      (Edge. 2 4 300)
                      ]
                     ])

(defn get_node_by_id [node_id all_nodes]
  (first (filter #(= (:id %) node_id) all_nodes))
  )

(defn get_cities_population [all_nodes]
  (apply str (map #(str (:name %) "=" (:population %) "; ") all_nodes))
  )

(defn get_edges_for_node [node_id all_edges]
  (filterv #(or (= node_id (:node_from %)) (= node_id (:node_to %))) all_edges)
  )

(defn not-in? [coll item]
  (nil? (some #(= item %) coll))
  )

(defn get_another_node_for_edge [node_id edge]
  (if (= node_id (:node_from edge))
    (:node_to edge)
    (:node_from edge)
    )
  )

(defn filter_children_by_history [node_id edges history]
  (filterv #(not-in? history (get_another_node_for_edge node_id %)) edges)
  )

(defn process_node [node_id history all_edges target_node_id routes]
  (let [history_updated (conj history node_id)
        edges_from_this_node (get_edges_for_node node_id all_edges)
        children_to_go (filter_children_by_history node_id edges_from_this_node history_updated)
        ]
    ;(println "node_id =" node_id "; history_updated =" history_updated)
    (if (= node_id target_node_id)
      (swap! routes conj history_updated)
      ; child is Edge
      (doseq [child children_to_go]
        (process_node (get_another_node_for_edge node_id child) history_updated all_edges target_node_id routes)
        )
      )
    history_updated
    )
  )

(defn get_edge_for_nodes [node1_id node2_id all_edges]
  (first
    (filter #(or
               (and (= node1_id (:node_from %)) (= node2_id (:node_to %)))
               (and (= node2_id (:node_from %)) (= node1_id (:node_to %)))
               ) all_edges))
  )

; input: routes as this => [1 2 3 4]
; output:
; list of edges (objects);
; path like Aurelia > Bracada (400) ...
; (count route) means numbers of visited stations
; capacity_total like 800 passengers
(defn evaluate_route [route all_nodes all_edges]
  (loop [index 0
         capacity_total 0
         path ""
         edges_of_route []]
    (if (< index (dec (count route)))
      (let [node_id (nth route index)
            node_next_id (nth route (inc index))
            node_name (:name (get_node_by_id node_id all_nodes))
            node_name_next (:name (get_node_by_id node_next_id all_nodes))
            edge (get_edge_for_nodes node_id node_next_id all_edges)
            capacity (:capacity edge)
            path_segment (str node_name " > " node_name_next " [" capacity "] | ")]
        (recur (inc index) (+ capacity_total capacity) (str path path_segment) (conj edges_of_route edge))
        )
      (vector edges_of_route path (count route) capacity_total)
      )
    )

  )

(defn find_all_routes [start_node_id target_node_id all_nodes all_edges]
  (let [routes (atom [])]
    ; it returns the list of possible routes like this:
    ; [[1 2 3 4] [1 2 4] [1 3 2 4] [1 3 4]]
    (process_node start_node_id [] all_edges target_node_id routes)
    ;(println @routes)
    (map #(evaluate_route % all_nodes all_edges) @routes)
    )
  )

(defn get_potential_passengers [node_city spaceport_node_id all_nodes all_edges]
  (let [city_id (:id node_city)
        city_name (:name node_city)
        city_population (:population node_city)
        ; vector like this:
        ; (vector edges_of_route path (count route) capacity_total)
        route_most_profitable (->> (find_all_routes city_id spaceport_node_id all_nodes all_edges)
                                   (sort-by last)
                                   (last))
        ; this is list of edges (objects)
        route_best (first route_most_profitable)
        route_best_profit (last route_most_profitable)
        route_best_path (second route_most_profitable)
        passengers_can_transfer (if (>= city_population route_best_profit)
                                  route_best_profit
                                  city_population)]
    (println city_name "can transfer" passengers_can_transfer "passengers. Route is" route_best_path)
    (vector node_city route_best passengers_can_transfer)
    )
  )

(defn analyze_city [node_city spaceport_node_id all_nodes all_edges]
  (when-not (= (:id node_city) spaceport_node_id)
    (get_potential_passengers node_city spaceport_node_id all_nodes all_edges)
    )
  )

(defn evacuation [all_nodes all_edges spaceport_node_id]
  (loop [hour 0
         current_nodes all_nodes]
    (if (<= hour 2)
      (let [current_edges (get all_edges hour)]
        (println "--------------")
        (println "Hour" (inc hour))
        (println "--------------")
        (println (get_cities_population current_nodes))
        (let [cities_and_passengers (map #(analyze_city % spaceport_node_id current_nodes current_edges) current_nodes)
              city_of_choice_metadata (last (sort-by last (filter #(some? %) cities_and_passengers)))
              city_of_choice (first city_of_choice_metadata)
              city_of_choice_id (:id city_of_choice)
              city_of_choice_name (:name city_of_choice)
              city_of_choice_population (:population city_of_choice)

              passengers_to_go (last city_of_choice_metadata)

              spaceport_node (get_node_by_id spaceport_node_id current_nodes)
              spaceport_node_name (:name spaceport_node)
              spaceport_node_population (:population spaceport_node)

              updated_nodes (conj
                              (vec (filter #(and (not= (:id %) spaceport_node_id) (not= (:id %) city_of_choice_id)) current_nodes))
                              (Node. city_of_choice_id city_of_choice_name (- city_of_choice_population passengers_to_go))
                              (Node. spaceport_node_id spaceport_node_name (+ spaceport_node_population passengers_to_go))
                              )]
          (println "city of choice =" city_of_choice_name)
          (recur (inc hour) updated_nodes))
        )
      (do
        (println "--------------")
        (println (get_cities_population current_nodes))
        (println "Finally evacuated" (:population (get_node_by_id spaceport_node_id all_nodes) "passengers"))
        )
      )
    )
  )

(def spaceport_node_id 4)
(evacuation all_nodes edges_by_hours spaceport_node_id)


; DEBUG
;(println (find_all_routes 1 spaceport_node_id all_nodes (get edges_by_hours 1)))
;(find_all_routes 1 spaceport_node_id all_nodes (get edges_by_hours 1))

