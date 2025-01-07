(ns week13.macros-ternary)

(defmacro ?
  [cond true_clause false_clause]
  `(if ~cond
     ~true_clause
     ~false_clause
     )
  )

(? (> 6 5) (println "this is true") (println "this is false"))

