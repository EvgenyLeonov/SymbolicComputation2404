(ns week14.caesar-cypher-frequency-analysis
  (:require [week14.caesar_cypher_library :as library])
  (:require [week14.caesar-cypher-init-data :as caesar_data])
  (:require [week14.caesar_cypher_read_english_words :as english_words])
  (:require [clojure.string :as string])
  (:require [week14.caesar-cypher-brute-force :as brute-force])
  )

(defn get_sorted_vector
  [items]
  (into [] (sort-by val #(compare %2 %1) items)))

(defn letter_count
  [letter text]
  (count (filter #{letter} text)))

(defn all_letters_count
  [text]
  (reduce (fn [result letter]
            ; thread-last macro
            (->> text
                 (letter_count letter)
                 (assoc result letter)
                 ))
          {}
          (reduce conj #{} caesar_data/alphabet)))

(defn english_words_count_in_text_for_letter
  ; encrypted_text must be last because it used in macro
  [letter_candidate all_english_words alphabet encrypted_text]
  (let [; this is index of A letter (first is space, second is A)
        aIndex (string/index-of alphabet "A")
        letterIndex (string/index-of alphabet letter_candidate)
        key? (- letterIndex aIndex)
        text_candidate (library/decrypt encrypted_text key?)
        words_in_text (string/split text_candidate #" ")
        ; words_count (count words_in_text)
        words_prep (map #(brute-force/english_word? % all_english_words) words_in_text)
        words_english_count (reduce + words_prep)
        ; found? (> (float (/ words_english_count words_count)) 0.5)
        ]
    words_english_count
    ))

(defn english_words_count_in_text
  [encrypted_text frequencies_sorted all_english_words]
  (get_sorted_vector (reduce (fn [result letter]
                               ; thread-last macro
                               (->> encrypted_text
                                    (english_words_count_in_text_for_letter letter all_english_words caesar_data/alphabet)
                                    (assoc result letter)
                                    ))
                             {}
                             ; caesar_data/alphabet
                             (reduce conj #{} frequencies_sorted)))
  )

(defn get_letters_only [items]
  (into [] (map #(str (first %))) items))

(defn break
  [encrypted_text]

  (let [frequencies (all_letters_count encrypted_text)
        ; make an array from a sorted by descending value map
        frequencies_sorted (get_letters_only (get_sorted_vector frequencies))
        _ (println "frequencies_sorted =" frequencies_sorted)
        all_english_words (english_words/read_english_words)
        english_words_counts (english_words_count_in_text encrypted_text frequencies_sorted all_english_words)
        _ (println "english_words_count =" english_words_counts)
        best_letter (first (first english_words_counts))
        aIndex (string/index-of caesar_data/alphabet "A")
        letterIndex (string/index-of caesar_data/alphabet best_letter)
        key (- letterIndex aIndex)]
    key
    )
  )

