(ns week11.arabic-to-roman)

(def roman ["M" "CM" "D" "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"])
(def arabic [1000 900 500 400 100 90 50 40 10 9 5 4 1])

(defn arabic_to_roman [arabic_num]
  (let [current_value (atom arabic_num)
        roman_result (atom "")]
    (while (> @current_value 0)
      (loop [index 0]
        (if (< index (count arabic))
          (let [value (get arabic index)
                letter (get roman index)]
            (if (>= @current_value value)
              (do
                (swap! current_value - value)
                (swap! roman_result str letter)
                )
              (recur (inc index))
              )
            )
          )
        )
      )
    @roman_result
    )
  )

(println (arabic_to_roman 5))
(println (arabic_to_roman 9))
(println (arabic_to_roman 21))
(println (arabic_to_roman 1576))
