(ns week05.fibonacci-memo)

(def fnumber 40)

(defn fibonacci [n]
  (cond
    (= 0 n) 0
    (= 1 n) 1
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))))

(println (time (fibonacci fnumber)))

(def fibonacci_memo
  (memoize (fn [n]
             (cond
               (= 0 n) 0
               (= 1 n) 1
               :else (+ (fibonacci (dec n)) (fibonacci (- n 2))))
             )))

(println (time (fibonacci_memo fnumber)))

