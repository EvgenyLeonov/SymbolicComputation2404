(ns week14.caesar_cypher_read_english_words)

(defn read_english_words []
  (with-open [rdr (clojure.java.io/reader "src/week14/english_words.txt")]
    (reduce conj #{} (line-seq rdr)))
  )

