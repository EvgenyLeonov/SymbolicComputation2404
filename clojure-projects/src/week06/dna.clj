(ns week06.dna)

(def dna "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGGC")

; trivial solution 1
(println "frequencies =" (frequencies dna))
(println "---------------")

; trivial solution 2
; each letter we take from string is char, not string
(defn to_char [letter]
  (first (char-array letter))
  )

(defn count_letter [letter text]
  (count (filter #(= % letter) text))
  )

(println "A" (count_letter (to_char "A") dna))
(println "C" (count_letter (to_char "C") dna))
(println "T" (count_letter (to_char "T") dna))
(println "G" (count_letter (to_char "G") dna))
(println "---------------")

; solution with grouping

(defn count_letter_group [letter text]
  (-> #{letter}
      (group-by text)
      (get letter)
      (count)
      )
  )

(println "A" (count_letter_group (to_char "A") dna))
(println "C" (count_letter_group (to_char "C") dna))
(println "T" (count_letter_group (to_char "T") dna))
(println "G" (count_letter_group (to_char "G") dna))
(println "---------------")

; solution with high-order functions
(defn count_letter_high_order
  [dna]
  (reduce (fn [result letter]
            (->> dna
                 (count_letter letter)
                 (assoc result letter)
                 ))
          {}
          #{\A \C \T \G}))

(println "count_letter_high_order =" (count_letter_high_order dna))
