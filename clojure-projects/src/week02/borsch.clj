(ns week02.borsch)

(defn boil
  [ingredient_name]
  (println ingredient_name "is boiled")
  )

(defn fry
  [ingredient_name]
  (println ingredient_name "is fried")
  )

(defn borsch []
  (println "Borsch!")
  (boil "beets")
  (boil "potatoes")
  (boil "carrots")
  (fry "beets")
  (fry "potatoes")
  (fry "carrots")
  (println "Mix it all together... Done!")
  )

; high-order function because it accepts a function as argument
(defn cook [dish]
  (println "Cooking...")
  (dish)
  (println "Bon appetite!")
  )

(cook borsch)
