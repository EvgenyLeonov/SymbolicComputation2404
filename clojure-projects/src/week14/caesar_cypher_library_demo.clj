(ns week14.caesar-cypher-library-demo
  (:require [week14.caesar_cypher_library :as library])
  )

(def phrase_to_encode "per aspera ad astra")
(def cypher_key 3)

(println "phrase to encode=" phrase_to_encode)
(def encoded_phrase (library/encrypt phrase_to_encode cypher_key))
(println "encoded phrase=" encoded_phrase)
(def decoded_phrase (library/decrypt encoded_phrase cypher_key))
(println "decoded phrase=" decoded_phrase)
