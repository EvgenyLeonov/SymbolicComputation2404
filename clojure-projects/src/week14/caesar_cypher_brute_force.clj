(ns week14.caesar-cypher-brute-force
  (:require [week14.caesar_cypher_read_english_words :as english_words])
  (:require [week14.caesar_cypher_library :as library])
  (:require [week14.caesar-cypher-init-data :as caesar_data])
  (:require [clojure.string :as string])
  )

(defn english_word?
  [word_to_check all_english_words]
  (if (true? (contains? all_english_words (string/upper-case word_to_check)))
    1 0
    ))

(defn reveal_key
  [encrypted_text]
  (let [alphabet_size (count caesar_data/alphabet)
        all_english_words (english_words/read_english_words)
        ]
    (loop [key? 1]
      (let [text_candidate (library/decrypt encrypted_text key?)
            words_in_text (string/split text_candidate #" ")
            words_count (count words_in_text)
            words_prep (map #(english_word? % all_english_words) words_in_text)
            words_english_count (reduce + words_prep)
            found? (> (float (/ words_english_count words_count)) 0.5)]
        (println "----------------")
        (println "key? =" key?)
        (println "text candidate =" text_candidate)
        (println "words count =" words_count)
        (println "words english count =" words_english_count)

        (if (true? found?)
          key?
          (when (< key? (dec alphabet_size))
            (recur (inc key?))
            )
          )
        )
      )
    )
  )







