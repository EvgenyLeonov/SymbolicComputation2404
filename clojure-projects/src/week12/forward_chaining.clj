(ns week12.forward_chaining
  (:require [clojure.string])
  (:require [clojure.string :as string]
            [week12.read_dataset_example :as data])
  )

;;;; FORWARD CHAINING ;;;;

(defn check_rule
  [dataset rule]
  (let [output_items (atom [])]
    (doseq [item dataset]
      (when (true? (rule item))
        (swap! output_items conj item)
        )
      )
    @output_items
    )
  )

(defn get_names [items]
  (into []
        (map #(first (string/split % #" ")) items)
        )
  )

(defn check_superpower [dataset sp_name]
  (check_rule dataset #(string/ends-with? % sp_name))
  )

(defmulti has_superpower (fn [sp] (:type sp)))

(defmethod has_superpower :has_extra_strength [args]
  (check_superpower (:dataset args) "extra strength")
  )

(defmethod has_superpower :has_bulletproof [args]
  (check_superpower (:dataset args) "bulletproof")
  )

(defmethod has_superpower :has_regeneration [args]
  (check_superpower (:dataset args) "regeneration")
  )

(defmethod has_superpower :has_telepathy [args]
  (check_superpower (:dataset args) "telepathy")
  )

(defmethod has_superpower :shape-shifter [args]
  (check_superpower (:dataset args) "shape-shifter")
  )

(defn and! [arg1 arg2]
  (let [names1 (get_names arg1)
        names2 (get_names arg2)
        names_output (atom [])]
    (doseq [n names1
            :when (.contains names2 n)
            ]
      (swap! names_output conj n)
      )
    @names_output
    )
  )

(defn or! [arg1 arg2]
  (distinct (concat arg1 arg2))
  )

(def dataset (data/read_superheroes_dataset))

(println "Super heroes with extra strength =" (get_names (has_superpower {:type :has_extra_strength :dataset dataset})))
(println "Super heroes who are a shape-shifter AND is bulletproof =" (get_names (and! (has_superpower {:type :shape-shifter :dataset dataset}) (has_superpower {:type :has_bulletproof :dataset dataset}))))
(println "Super heroes who has telepathy OR regeneration =" (get_names (or! (has_superpower {:type :has_telepathy :dataset dataset}) (has_superpower {:type :has_regeneration :dataset dataset}))))





