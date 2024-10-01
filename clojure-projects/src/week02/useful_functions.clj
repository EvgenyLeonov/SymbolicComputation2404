(ns week02.useful-functions
  (:use [clojure.repl :only [doc source]])
  )

; prints documentation about any function/macro
(doc empty?)

; prints source about any function/macro
; this is a function (defn "keyword"/function)
(source empty?)

; this is a macro (defmacro "keyword"/function)
; we can use macro to enhance the core language
(source while)
