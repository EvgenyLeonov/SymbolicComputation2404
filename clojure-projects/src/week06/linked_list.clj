(ns week06.linked-list)

(defrecord Node [name next_node])

; node1 -- head
; node6 -- tail

(defn create_linked_list []
  (let [node6 (Node. "6" nil)
        node5 (Node. "5" node6)
        node4 (Node. "4" node5)
        node3 (Node. "3" node4)
        node2 (Node. "2" node3)
        node1 (Node. "1" node2)]
    node1
    )
  )
