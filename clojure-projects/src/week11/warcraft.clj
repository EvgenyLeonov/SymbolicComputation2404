(ns week11.warcraft)

(def peasant_gold (agent 0))
(def peasant_lumber (agent 0))
(def barack (agent nil))

(defn peasant_gather_resources [current_value resource_name]
  (Thread/sleep (if (= resource_name "gold")
                  1500
                  2000
                  ))
  (println "peasant gathered" resource_name "(total=" (inc current_value) ")")
  (inc current_value)
  )

(defn train_footman [current_value unit_name]
  (println "Training....")
  (Thread/sleep 10000)
  (println unit_name "is trained")
  )

(defn if_enough_resources [key ref old_val new_val]
  (let [gold (if (= key :gold)
               new_val
               @peasant_gold)
        lumber (if (= key :lumber)
                 new_val
                 @peasant_lumber)]
    (if (and (>= gold 2) (>= lumber 1))
      (do
        (remove-watch peasant_gold :gold)
        (remove-watch peasant_lumber :lumber)
        (send barack train_footman "Footman")
        )
      (do
        (send peasant_gold peasant_gather_resources "gold")
        (send peasant_lumber peasant_gather_resources "lumber")
        )
      )
    )
  )

(add-watch peasant_gold :gold if_enough_resources)
(add-watch peasant_lumber :lumber if_enough_resources)

(println "Game started")

(send peasant_gold peasant_gather_resources "gold")
(send peasant_gold peasant_gather_resources "lumber")