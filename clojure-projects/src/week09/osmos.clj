(ns week09.osmos)

(defrecord Molecule [name x y value])

(def other_molecules
  [(Molecule. "Yellow" 2 2 4)
   (Molecule. "Green" 3 1 3)
   (Molecule. "Orange" 3 4 5)
   (Molecule. "Red" 2 5 8)])

(def my_molecule (Molecule. "Blue" 1 1 7))

(defn print_molecules [mols]
  (if (empty? mols)
    (println "none")
    (doseq [m mols]
      (println (:name m) "x =" (:x m) "y =" (:y m) "value =" (:value m))
      )
    )
  )

(defn calculate_distance [my_mol another_mol]
  (let [my_mol_x (:x my_mol)
        my_mol_y (:y my_mol)
        my_mol_value (:value my_mol)
        another_mol_x (:x another_mol)
        another_mol_y (:y another_mol)
        another_mol_value (:value another_mol)
        distance (+ (abs (- another_mol_x my_mol_x)) (abs (- another_mol_y my_mol_y)))
        can_consume? (> my_mol_value (+ another_mol_value distance))
        profit (- another_mol_value distance)]
    (println "for" (:name another_mol) "distance =" distance "profit =" profit "can_consume? =" can_consume?)
    (vector can_consume? profit another_mol)
    )
  )

(defn get_options [my_mol other_mols]
  (map #(calculate_distance my_mol %) other_mols)
  )

; options is a vector from get_options
(defn get_best_option [options]
  (last (sort-by second (filter #(true? (first %)) options))))

(defn consume_others [my_molecule other_molecules]
  (loop [round 1
         my_mol my_molecule
         other_mols other_molecules]

    (println "--------------")
    (println "Round" round)
    (println "--------------")

    (println "My molecule x =" (:x my_mol) "y =" (:y my_mol) "value =" (:value my_mol))
    (print_molecules other_mols)

    (let [next_options (get_options my_mol other_mols)
          ;_ (println next_options)
          ; vector (can_consume? profit molecule)
          best_option (get_best_option next_options)
          best_option_mol (last best_option)
          best_option_name (:name best_option_mol)
          profit (second best_option)]
      (println "Best option" best_option_name "profit =" profit)
      (if (nil? best_option)
        (println "no other molecules")
        (do
          (println "go eat" best_option_name)
          (recur
            (inc round)
            (Molecule. "Blue"
                       (:x best_option_mol)
                       (:y best_option_mol)
                       (+ (:value my_mol) profit))
            (filter #(not= (:name %) best_option_name) other_mols)))))
    )
  )

(consume_others my_molecule other_molecules)

