(ns week12.read_dataset_example)

(defn read_superheroes_dataset []
  (with-open [rdr (clojure.java.io/reader "src/week12/superheroes_dataset.txt")]
    (reduce conj [] (line-seq rdr)))
  )

; DEBUG
; (for [line (read_superheroes_dataset)]  (println line)  )
