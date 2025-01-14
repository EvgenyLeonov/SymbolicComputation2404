(ns week14.caesar-cypher-brute-force-demo
  (:require [week14.caesar_cypher_library :as library])
  (:require [week14.caesar-cypher-brute-force :as cracker])
  )

(def text "Lincoln was born into poverty in a log cabin in Kentucky and was raised on the frontier")

(def key_for_text 5)

(def text_encrypted (library/encrypt text key_for_text))

(println "text encrypted =" text_encrypted)

; (println (cracker/english_word? "poverty" (english_words/read_english_words)))

(def exposed_key (cracker/reveal_key text_encrypted))

(println "I discovered your key is" exposed_key)

(def text_decrypted (library/decrypt text_encrypted exposed_key))

(println "=============")
(println "Your secret text:" text_decrypted)




