(ns week13.permutation)

(defn permutation [nums]
  (if (> (count nums) 1)
    (for [num_left nums
          num_right (permutation (filter #(not= % num_left) nums))]
      (cons num_left num_right)
      )
    [nums]
    )
  )

(println (permutation #{1 2 3}))