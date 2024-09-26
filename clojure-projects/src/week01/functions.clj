(ns week01.functions)

(def foo "hello")

(defn function_with_local_variables
  [arg1 arg2]
  (let [first_local_var arg1
        second_local_var arg2
        sum_of_local_var (+ first_local_var second_local_var)
        _ (println "sum_of_local_var =" sum_of_local_var)
        ]

    sum_of_local_var
    )
  )
; is not visible outside of the function
;(println first_local_var)

;(println foo)

(def my_func_result (function_with_local_variables 20 30))

(println "my_func_result =" my_func_result)

