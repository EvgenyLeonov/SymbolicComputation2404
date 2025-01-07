(ns week13.macros-demo)

(defmacro my_when
  [cond & body]
  `(if ~cond
     (do ~@body)
     )
  )

(my_when (> 6 5)
         (println "print 1")
         (println "print 2")
         (println "print 3")
         (println "print 4")
         (inc 1)
         )
; run this in REPL
; (macroexpand-1 '(my_when (> 6 5) (println "print 1") (inc 1)))
