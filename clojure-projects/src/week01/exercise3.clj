(ns week01.exercise3
  (:require [clojure.string :as string]))

(println "1." (= "Cool right?" (str __)))

(println "2." (= __ (= "hello" :hello 'hello)))

(println "3." (= :hello (keyword __)))

(println "4." (= 'hello (symbol __)))

(println "5." (= __ (count "Hello World")))

(println "6." (= __ (string/join '(1 2 3))))

(println "7." (= "1, 2, 3" (string/join __ '(1 2 3))))

(println "8." (= __ (char? \c)))

(println "9." (= __ (char? "a")))

(println "10." (= __ (string? \b)))

(println "11." (= __ (string? "")))

(println "12." (= __ (string/blank? "")))

(println "13." (= __ (string/blank? " \n \t  ")))

(println "14." (= __ (string/blank? " \n \t  ")))

(println "15." (= __ (or (= 2 2) (not true))))




