(ns aoc-clojure.day02 (:require [aoc-clojure.core :refer :all]))

;part 1

(defn get-deltas [input]
  "Find the differences in values for a list of pairs"
  (->> (partition 2 1 input)
       (map #(- (second %) (first %)))))

(defn are-deltas-within-range? [input min max]
  "Ensure the deltas for the given list of pairs are within the bounds"
  (every? #(and (>= % min) (<= % max)) (get-deltas input)))

(defn is-safe? [input]
  "Returns true if the report is safe, false otherwise"
  (or (are-deltas-within-range? input 1 3) (are-deltas-within-range? input -3 -1)))

(defn solve-part-1 [file]
  "Solve for part 1"
  (let [input (parse-lists-of-longs file)]
    (->> input
         (filter #(is-safe? %))
         (count)
         )))

;part 2

(defn with-pos-removed [pos coll]
  "Return the same collection, but with the element at the index removed"
  (into (subvec (vec coll) 0 pos) (subvec (vec coll) (inc pos))))

(defn get-combos-with-one-removal [input]
  "Get all the combinations of removing one element from the collection"
  (->> (range 0 (count input))
       (map #(with-pos-removed % input))))

(defn is-safe-with-dampening? [input]
  "Returns true if the report is safe after considering dampeneing, false otherwise"
  (or (is-safe? input) (not (not-any? is-safe? (get-combos-with-one-removal input)))))

(defn solve-part-2 [file]
  "Solve for part 2"
  (let [input (parse-lists-of-longs file)]
    (->> input
         (filter #(is-safe-with-dampening? %))
         (count)
         )))

(defn -main []
  (println (solve-part-1 "../resources/test/Day02.txt"))
  (println (solve-part-1 "../resources/main/Day02.txt"))
  (println (solve-part-2 "../resources/test/Day02.txt"))
  (println (solve-part-2 "../resources/main/Day02.txt"))
)