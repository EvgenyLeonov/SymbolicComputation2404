(ns week02.collections)

(def vect [1 2 3])

(def lst '(1 2 3))

(def sett #{1 2 3})

(def mapp {"a" 1 "b" 2, "c" 3})

(println "create a new vector >>" (vector 42 "a" :bb))

(println "create a new vector >>" (vec '(5 6 7)))

(let [vect2 (conj vect 4 5)]
  (println "add value to a vector >>" vect2)
  )

(println "vect variable >>" vect)

; unites multiply collections to one
(println "concat function >>" (concat vect [22 33]))

(println "get element by index >>" (nth vect 2))

(println "filter >>" (filter #(< % 3) vect))

(println "first >>" (first vect))

(println "second >>" (second vect))

(println "last >>" (last vect))

(println "rest >>" (rest vect))

(println "conj in list >>" (conj lst 5 6 7 7 6 5))

(println "conj in set >>" (conj sett 5 6 7 7 6 5))

(println "contains? >>" (contains? sett 8))

(println "add items in map >>" (assoc mapp "d" 100 "e" 200))

(println "remove items in map >>" (dissoc mapp "b" "x"))
