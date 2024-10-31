(ns week06.dna)

(def dna "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGGC")

(defn count_letter [letter text]
  (count (filter #(= % letter) text))
  )

(defn to_char [letter]
  (first (char-array letter))
  )

(println "A" (count_letter (to_char "A") dna))

(defn count_letter_group [letter text]
  (-> #{letter}
      (group-by text)
      (get letter)
      (count)
      )
  )

(println "A" (count_letter_group (to_char "A") dna))

; #{\A \C \T \G}
; TODO reduce, map
