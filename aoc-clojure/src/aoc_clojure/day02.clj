(ns aoc-clojure.day02 (:require [aoc-clojure.core :refer :all]))

(defn get-deltas [input]
  (->> (partition 2 1 input)
       (map #(- (second %) (first %)))))

(defn are-deltas-within-range? [input min max]
  (every? #(and (>= % min) (<= % max)) (get-deltas input)))

(defn is-safe? [input] (or (are-deltas-within-range? input 1 3) (are-deltas-within-range? input -3 -1)))

(defn solve-part-1 [file]
  (let [input (parse-lists-of-longs file)]
    (->> input
         (filter #(is-safe? %))
         (count)
         )))

(defn -mainx []
  (print (filter #(and (>= % 1) (<= % 3)) (get-deltas [1 2 5 8 9])) ) )

(defn -main []
  (doseq [i [(solve-part-1 "../resources/test/Day02.txt")
             (solve-part-1 "../resources/main/Day02.txt")
             ;(solve-part-2 "../resources/test/Day01.txt")
             ;(solve-part-2 "../resources/main/Day01.txt")
             ]]
    (println i)))