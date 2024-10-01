(ns week01.exercise3
  (:require [clojure.string :as string]))

(println "1." (= "Cool right?" (str "Cool right?")))

(println "2." (= false (= "hello" :hello 'hello)))

(println "3." (= :hello (keyword "hello")))

(println "4." (= 'hello (symbol "hello")))

; strings also collections. You may think about them as about a collection of strings
; each of these strings in collection contains one letter: "h", "e" ...
(println "5." (= 11 (count "Hello World")))

; '(1 2 3) is suppressed by ' symbol. string/join executes it (literally, calculates)
(println "6." (= "123" (string/join '(1 2 3))))

; you may use this pattern to convert some collection to string with delimiters
; without any loops
(println "7." (= "1, 2, 3" (string/join ", " '(1 2 3))))

(println "8." (= true (char? \c)))

(println "9." (= false (char? "a")))

(println "10." (= false (string? \b)))

(println "11." (= true (string? "")))

(println "12." (= true (string/blank? "")))

(println "13." (= true (string/blank? " \n \t  ")))

(println "14." (= true (or (= 2 2) (not true))))




