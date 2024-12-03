(ns week11.agents)

(defn incrementation [current_value new_value]
  (Thread/sleep 1000)
  (println "----------------")
  (println "current value is" current_value)
  (+ current_value new_value)
  )

(defn watch_handler [key ref old_val new_val]
  (println "key =" key)
  (println "ref =" ref)
  (println "old_val =" old_val)
  (println "new_val =" new_val)
  )

(def agent1 (agent 0))
(add-watch agent1 :agentWatcher watch_handler)
(send agent1 incrementation 100)
;(remove-watch agent1 :agentWatcher)
(send agent1 incrementation 1000)
(println "I am waiting")
(await-for 3000 agent1)
(println "-----")
(println "result =" @agent1)




