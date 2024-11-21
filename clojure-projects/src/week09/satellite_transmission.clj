(ns week09.satellite-transmission)

; https://en.wikipedia.org/wiki/Word_(computer_architecture)
; https://www.pcmag.com/encyclopedia/term/word#:~:text=Word%20%22size%22%20refers%20to%20the,8%2C%2016%20or%2032%20bits.

(defn transmit [input max_size]
  (loop [current_data (sort #(compare %2 %1) input)
         all_chunks []
         current_chunk []]
      (println "current_data =" current_data)
      (if (empty? current_data)
        ; no more pieces left
        (conj all_chunks current_chunk)

        ; we still have pieces to process
        (let [next_piece (first current_data)
              candidate_sum (+ next_piece (reduce + current_chunk))]
          (if (< candidate_sum max_size)
            ; current_chunk is not full yet
            (recur
              (rest current_data)
              all_chunks
              (conj current_chunk next_piece)
              )

            ; current_chunk is full, let's add it to all_chunks
            (recur
              (rest current_data)
              (conj all_chunks (conj current_chunk next_piece))
              []
              )
            )
          )
        )
    )
  )

(println (transmit [64 64 128 32 16 8 16 32 128 245] 256))




