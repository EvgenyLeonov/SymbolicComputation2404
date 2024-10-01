(ns week02.anonymous-functions)

(println "5 * 7 =" ((fn [a b] (* a b)) 5 7))

(defn f1 [a b] (+ a b))

(def f2 (fn [a b] (+ a b)))

(def f3
  #(+ %1 %2)
  )

(def f4-negative
  #(- %)
  )

(println "f1 = " (f1 2 3))
(println "f2 = " (f2 2 3))
(println "f3 = " (f3 2 3))
(println "f4-negative = " (f4-negative 3))

(println "an. func. without variable =" (#(+ %1 %2) 10 20))

(let
  [internal_func (fn [a b] (println "result of internal function = " (* a b)))
   function_from_outer_scope f3
   _ (internal_func 2 3)
   _ (println "function_from_outer_scope =" (function_from_outer_scope 50 25))
   ]
  )

(internal_func 30 40)
