(ns week13.excel)

; reactive programming. Propagation of values

; value = current value; func = what we need to do with current and parent values
(defrecord Cell [address value cells func])


(defn update_cell [cell parent_value new_value]
  (Cell. (:address cell)
         (if (nil? (:func cell))
           new_value
           ((:func cell) parent_value new_value)
           )
         (:cells cell)
         (:func cell))
  )

(defn reaction [cell new_value]
  (let [cell_updated (update_cell cell nil new_value)
        ; update dependencies
        updated_cells (map #(update_cell % (:value cell_updated) (:value %)) (:cells cell))
        ]
    (conj updated_cells cell_updated)
    )
  )

(def cell2 (Cell. "B1" 1 [] +))
(def cell3 (Cell. "C1" 2 [] *))
(def cell1 (Cell. "A1" 0 [cell2 cell3] nil))

(->> (reaction cell1 100)
     (map #(println (:address %) ">>" (:value %))))







