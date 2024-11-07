(ns week07.binary-tree-data)

(defrecord Node [name left_node right_node])

(defn create_tree_advanced []
  (let [node1  (Node. "1" nil nil)
        node3  (Node. "3" nil nil)
        node2  (Node. "2" node1 node3)
        node6  (Node. "6" nil nil)
        node7  (Node. "7" nil nil)
        node5  (Node. "5" node6 node7)
        node4  (Node. "4" node2 node5)
        ]
    node4
    )
  )

(defn create_tree_simple []
  (let [node1  (Node. "1" nil nil)
        node3  (Node. "3" nil nil)
        node2  (Node. "2" node1 node3)
        ]
    node2
    )
  )
