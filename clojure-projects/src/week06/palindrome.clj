(ns week06.palindrome
  (:require [clojure.string :as str])
  )

; abccba
(def my_word (clojure.string/lower-case "kayak"))

(defn palindrome?_reverse [word]
  (= word (apply str (reverse word)))
  )

(println "palindrome?-reverse =" (palindrome?_reverse my_word))

(defn palindrome?_two_pointers [word]
  (loop [p1 0
         p2 (dec (count word))]
    (let [l1 (get word p1)
          l2 (get word p2)]
      (println "p1 =" p1 "; l1 =" l1 "; p2 =" p2 "; l2 =" l2)
      (if (>= p1 p2)
        true
        (if (not= l1 l2)
          false
          (recur (inc p1) (dec p2))
          )
        )
      )
    )
  )

(println "palindrome?_two_pointers =" (palindrome?_two_pointers my_word))