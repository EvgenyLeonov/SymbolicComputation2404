(ns week09.rle-encoding)

; https://en.wikipedia.org/wiki/Run-length_encoding

(defn rle_encoding [text]
  (->> text
       (partition-by identity)
       ; % -> (B B B)
       (map #(if (= (count %) 1)
               (vector (first %))
               (vector (count %) (first %))
               ))
       ; % -> [3 B]
       (map #(apply str %))
       (apply str))
  )

(println (rle_encoding "AABBBCCXXCCCX"))



