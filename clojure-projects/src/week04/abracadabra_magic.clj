(ns week04.abracadabra-magic)

(defn print_abracadabra [magic_word]
  (loop [word magic_word]
    (println (apply str word))
    (if (> (count word) 0)
      (recur (rest word))
      )
    )
  )

(print_abracadabra "abracadabra")
