(ns week02.chain-of-functions)

(defn mult [a b]
  (* a b)
  )

; high-order function
(defn funcs_as_args
  [f1 f2 v1 v2]
  (f1 (f2 v1 v2))
  )

; f1 -- inc; f2 -- mult
(println "funcs_as_args [1] =" (funcs_as_args inc mult 9 9))

; #(/ % 9) -- anonymous func. with one argument
(println "funcs_as_args [2] =" (funcs_as_args #(/ % 9) mult 9 9))

(def func_with_comp
  (comp #(println "func_with_comp returns =" %) #(/ % 100) #(* % 5))
  )

(func_with_comp 100)