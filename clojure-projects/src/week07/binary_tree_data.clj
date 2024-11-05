(ns week07.binary-tree-data)

(defrecord Node [name left_node right_node])

(defn create_binary_tree []
  (let [node4 (Node. "4" nil nil)
        node5 (Node. "5" nil nil)
        node6 (Node. "6" nil nil)
        node7 (Node. "7" nil nil)
        node8 (Node. "8" nil nil)
        node3 (Node. "3" node4 node5)
        node2 (Node. "2" node7 node8)
        node1 (Node. "1" node3 node6)
        root (Node. "root" node1 node2)]
    root
    )
  )
