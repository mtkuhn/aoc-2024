(ns aoc-clojure.day03)

(defn solve-part-1 [file]
  "Solve for part 1"
  (->> (slurp file)
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)")
       (map #(* (parse-long (second %)) (parse-long (last %))))
       (apply +)
       ))

(defn -main []
  (println (solve-part-1 "../resources/test/Day03.txt"))
  (println (solve-part-1 "../resources/main/Day03.txt"))
  ;(println (solve-part-2 "../resources/test/Day03.txt"))
  ;(println (solve-part-2 "../resources/main/Day03.txt"))
  )