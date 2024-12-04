(ns aoc-clojure.day03)

(defn solve-part-1 [file]
  "Solve for part 1"
  (->> (slurp file)
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)")
       (map #(* (parse-long (second %)) (parse-long (last %))))
       (apply +)
       ))

(defn mark-disabled [instructions]
  (reduce
    (fn [acc i]
      (conj acc (cond
                   (= (first i) "do()") (conj i true)       ;flip to enabled
                   (= (first i) "don't()") (conj i false)   ;flip to disabled
                   (empty? acc) (conj i true)               ;first value, always true
                   :else (conj i (last (first acc)))        ;repeat the prev value
                   )))
    ()
    instructions)
  )

(defn solve-part-2 [file]
  "Solve for part 1"
  (->> (slurp file)
       (re-seq #"mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)")
       (mark-disabled)
       (filter #(and (last %) (not (nil? (second %)))))
       (map #(* (parse-long (nth % 1)) (parse-long (nth % 2))))
       (apply +)
       ))

(defn -main []
  (println (solve-part-1 "../resources/test/Day03.txt"))
  (println (solve-part-1 "../resources/main/Day03.txt"))
  (println (solve-part-2 "../resources/test/Day03b.txt"))
  (println (solve-part-2 "../resources/main/Day03.txt"))
  )