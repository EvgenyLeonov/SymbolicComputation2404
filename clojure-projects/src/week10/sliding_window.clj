(ns week10.sliding-window)

(defn find_longest_subset [input_vector sum]
  (loop [left_pointer 0
         right_pointer 1
         result []]
    (let [latest_index (dec (count input_vector))]
      (let [current_window (subvec input_vector left_pointer right_pointer)
            current_window_sum (apply + current_window)
            window_suits? (<= current_window_sum sum)
            finished? (or (= left_pointer latest_index) (= right_pointer latest_index))
            result_actualized (if (and window_suits? (> (count current_window) (count result)))
                                current_window
                                result)]
        (println "left_pointer =" left_pointer "; right_pointer =" right_pointer "; result =" result_actualized)
        (if finished?
          result_actualized
          (if window_suits?
            (recur left_pointer (inc right_pointer) result_actualized)
            (recur (inc left_pointer) right_pointer result_actualized)
            )
          )
        )
      )
    )
  )

(println (find_longest_subset [3 2 1 3 1 1] 5))
