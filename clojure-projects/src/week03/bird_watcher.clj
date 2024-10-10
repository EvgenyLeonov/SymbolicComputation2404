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

; auxiliary functions (just for demo purposes)
; options above are preferable and more compact

(defn day-without-birds?-loop [birds]
  (let [birds-count (count birds)]
    (loop [index 0]
      (if (< index birds-count)
        (if (= 0 (nth birds index))
          true
          (recur (inc index))
          )
        false
        )
      )
    )
  )

(defn busy-days-loop [birds]
  (let [birds-count (count birds)]
    (loop [index 0
           current_busy_days_number 0]
      (if (< index birds-count)
        (if (>= (nth birds index) 5)
          (recur (inc index) (inc current_busy_days_number))
          (recur (inc index) current_busy_days_number)
          )
        current_busy_days_number
        )
      )
    )
  )

(println "birds original =" birds)
(println "today =" (today birds))
(println "inc_bird =" (inc_bird birds))
(println "day-without-birds? =" (day-without-birds? birds))
(println "busy-days =" (busy-days birds))

(println "--------")

(println "day-without-birds?-loop =" (day-without-birds?-loop birds))
(println "busy-days-loop =" (busy-days-loop birds))

