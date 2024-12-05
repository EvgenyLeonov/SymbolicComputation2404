(ns week11.roman-to-arabic)

(def roman_letters {"I" 1, "V" 5, "X" 10, "L" 50, "C" 100, "D" 500, "M" 1000})

(defn roman_to_arabic [roman_num]
  (loop [index 0
         result 0]
    (if (< index (count roman_num))
      (let [letter (str (get roman_num index))
            letter_next (str (get roman_num (inc index)))
            val1 (get roman_letters letter)
            val2 (get roman_letters letter_next)]
        (recur
          (inc index)
          (cond
            (nil? val2) (+ result val1)
            (< val1 val2) (- result val1)
            :else (+ result val1)
            )
          )
        )
      result
      )
    )
  )

; 5
(println (roman_to_arabic "V"))
; 9
(println (roman_to_arabic "IX"))
; 21
(println (roman_to_arabic "XXI"))
; 1576
(println (roman_to_arabic "MDLXXVI"))
