(ns week14.caesar_cypher_library
  (:require [week14.caesar-cypher-init-data :as caesar_data])
  (:require [clojure.string :as string :only [split upper-case index-of]])
  )

(def alphabet_size (count caesar_data/alphabet))

(def encode_letter_routine
  (fn [letter_index key]
    (mod (+ letter_index key) alphabet_size)
  ))

(def decode_letter_routine
  (fn [letter_index key]
    (mod (- letter_index key) alphabet_size)
    ))


(defn conversion
  [phrase_to_encode key encoded_word routine]
  (let [first_letter (first phrase_to_encode)
        letter_index (string/index-of caesar_data/alphabet first_letter)
        encoded_index (routine letter_index key)
        encoded_letter (get caesar_data/alphabet encoded_index)
        ;_ (println first_letter ">" encoded_letter)
        ;_ (println "encoded_word =" encoded_word)
        ]
      (if (> (count phrase_to_encode) 1)
        (conversion (subs phrase_to_encode 1) key (str encoded_word encoded_letter) routine)
        (str encoded_word encoded_letter)
        )
    )
  )

(defn encrypt
  [phrase_to_encode cypher_key]
  (conversion (string/upper-case phrase_to_encode) cypher_key "" encode_letter_routine)
  )

(defn decrypt
  [phrase_to_decode cypher_key]
  (conversion (string/upper-case phrase_to_decode) cypher_key "" decode_letter_routine)
  )

