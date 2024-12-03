(ns week11.parentheses)

(def correct_string "var x=[{1, 2}];")
(def incorrect_string "var x=[{1, 2)];")

(defn validate_string  [string]
  (let [symbols-for-observing {"{" "}", "}" "{", "(" ")", ")" "(", "[" "]", "]" "["}
        stack (atom [])]

    (doseq [symbol string]
      (println "symbol =" symbol)
      (if (contains? symbols-for-observing (str symbol))
        (let [symbol_str (str symbol)]
          (if (or (empty? @stack)
                  (not= (last @stack) (get symbols-for-observing symbol_str)))
            (reset! stack (conj @stack symbol_str))
            (reset! stack (into [] (drop-last @stack)))
            )
          (println "stack =" @stack)
          )
        )
      )
    (= (count @stack) 0)
    )
  )

(println (validate_string correct_string))
(println (validate_string incorrect_string))

