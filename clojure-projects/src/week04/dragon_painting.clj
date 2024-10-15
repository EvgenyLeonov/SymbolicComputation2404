(ns week04.dragon-painting)

(def dragon_parts [[2 3] [5 4] [1 3]])

(defn get_area [rectangle]
  (* (first rectangle) (last rectangle))
  )

(defn total_area [dragon_parts]
  (apply + (map get_area dragon_parts))
  )

(defn total_area_an [dragon_parts]
  (apply + (map #(* (first %) (last %)) dragon_parts))
  )

(println "total_area =" (total_area dragon_parts) "m2")
(println "cans number =" (* 2 (total_area_an dragon_parts)) "pcs")


