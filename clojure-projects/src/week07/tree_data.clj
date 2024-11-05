(ns week07.tree-data)

(defrecord Node [name find_me])

(defrecord Edge [node1 node2])

(def all_nodes
  [(Node. "root" false)
   (Node. "1" false)
   (Node. "2" false)
   (Node. "3" false)
   (Node. "4" false)
   (Node. "5" false)
   (Node. "6" false)
   (Node. "7" false)]
  )

(def all_edges
  [(Edge. "root" "1")
   (Edge. "root" "5")
   (Edge. "root" "7")
   (Edge. "1" "2")
   (Edge. "2" "3")
   (Edge. "2" "4")
   (Edge. "5" "6")]
  )


