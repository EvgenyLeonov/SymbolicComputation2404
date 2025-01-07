(ns week13.symbolic-computations)

; https://clojure.org/guides/weird_character

; run all of this in REPL

; quote
'(1 3 4)

; syntax quote
`(1 2 3)

; unquote
; ~ calculates the form
`(1 2 3 ~(+ 4 5))

(def l [4 5 6])

`(1 2 3 ~l)

; Unquote splicing
`(1 2 3 ~@l)

(def my_funcs [inc dec last])

`(1 2 3 ~@my_funcs)


