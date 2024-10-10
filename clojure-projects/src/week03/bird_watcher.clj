(ns week03.bird-watcher)

; #1
(def birds [0 2 5 3 7 8 4])

; #2
(defn today [birds]
  (last birds)
  )

; #3
(defn inc_bird [birds]
  (conj (vec (drop-last birds)) (inc (last birds)))
  )

; #4
(defn day-without-birds? [birds]
  (> (count (filter #(= % 0) birds)) 0)
  )

; #5
(defn busy-days [birds]
  (count (filter #(>= % 5) birds))
  )

(println "birds original =" birds)
(println "today =" (today birds))
(println "inc_bird =" (inc_bird birds))
(println "day-without-birds? =" (day-without-birds? birds))
(println "busy-days =" (busy-days birds))

