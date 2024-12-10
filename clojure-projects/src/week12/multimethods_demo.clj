(ns week12.multimethods-demo)

(defmulti area (fn [shape] (:type shape)))

(defmethod area :circle [c]
  (* Math/PI (:r c) (:r c))
  )

(defmethod area :square [s]
  (* (:a s) (:a s))
  )

(println "area of circle =" (area {:type :circle, :r 10}))
(println "area of square =" (area {:type :square, :a 20}))