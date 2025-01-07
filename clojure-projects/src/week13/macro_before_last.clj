(ns week13.macro-before-last)

(defmacro before_last
  [coll]
  `(if (> (count ~coll) 1)
     (nth ~coll (dec (dec (count ~coll))))
     nil
     )
  )

(println (before_last [1 2 3]))
(println (before_last []))
(println (before_last [1]))
