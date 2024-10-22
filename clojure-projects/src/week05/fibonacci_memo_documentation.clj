(ns week05.fibonacci-memo-documentation)

(def fnumber 40)

(defn fib [n]
  (condp = n
    0 0
    1 1
    (+ (fib (dec n)) (fib (- n 2)))))

(println (time (fib fnumber)))

;; "Elapsed time: 8179.04028 msecs"

;; Fibonacci number with recursion and memoize.
(def m-fib
  (memoize (fn [n]
             (condp = n
               0 0
               1 1
               (+ (m-fib (dec n)) (m-fib (- n 2)))))))

(println (time (m-fib fnumber)))



