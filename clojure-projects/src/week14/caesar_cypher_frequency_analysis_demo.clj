(ns week14.caesar-cypher-frequency-analysis-demo
  (:require [week14.caesar_cypher_library :as library])
  (:require [week14.caesar-cypher-frequency-analysis :as cracker])
  )

(def text "CAESAR WAS AN ACCOMPLISHED AUTHOR AND HISTORIAN AS WELL AS A STATESMAN MUCH OF HIS LIFE IS KNOWN FROM HIS OWN ACCOUNTS OF HIS MILITARY CAMPAIGNS")

(def key_for_text 10)

(def text_encrypted (library/encrypt text key_for_text))

(println "text_encrypted =" text_encrypted)

(def secret_key (cracker/break text_encrypted))

(println "your key is" secret_key)

(println "original text =" (library/decrypt text_encrypted secret_key))



