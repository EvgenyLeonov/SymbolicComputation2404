(ns week04.decameron
  (:require [clojure.string :as str])
  )

(defn narrator [text]
  (doseq [x (str/split text #"")]
    (Thread/sleep 100)
    (print x)
    (flush))
  )

(narrator "A Sicilian woman cunningly conveys from a merchant that which he has brought to Palermo. He made a show of being come back with far greater store of goods than before. The merchant borrows money of her, and leaves her in lieu thereof water and tow.")
