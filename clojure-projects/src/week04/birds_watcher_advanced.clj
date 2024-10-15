(ns week04.birds-watcher-advanced)

; # 1
(def birds [0 2 5 3 7 8 4])

; #2
(defn n-days-count [birds number_of_days]
  (apply + (take number_of_days birds))
  )

(println "n-days-count =" (n-days-count birds 4))

; # 3
(defn average [numbers]
  (/ (apply + numbers) (count numbers))
  )

(defn average_count [birds]
  (average (filter #(> % 0) birds))
  )

(println "days WITH birds =" (filter #(> % 0) birds))
(println "average_count =" (average_count birds))


