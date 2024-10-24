(ns week05.atoms-demo)

(def x (atom "a"))
(def y (atom 10))

(println "x =" x)
(println "y =" y)

(println "@x =" @x)
(println "@y =" @y)

(while (>= @y 0)
  (println "y =" @y)
  (swap! y dec)
  )

(reset! x [1 3 4])

(println "x =" x)
(println "@x =" @x)

