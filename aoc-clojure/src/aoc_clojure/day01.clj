(ns aoc-clojure.day01 (:require [aoc-clojure.core :refer :all]))

(defn get-sorted-lefts [input] (sort (map first input)))
(defn get-sorted-rights [input] (sort (map last input)))

(defn solve-part-1 [file]
  (let [input (parse-lists-of-longs file)
        left (get-sorted-lefts input)
        right (get-sorted-rights input)]
    (->> (map vector left right)
         (map #(abs (apply - %)))
         (apply +))))

(defn solve-part-2 [file]
  (let [input (parse-lists-of-longs file)
        left (get-sorted-lefts input)
        right (get-sorted-rights input)
        freq (frequencies right)]
    (->> left
         (map #(* % (or (freq %) 0)))
         (apply +))
    ))

(defn -main []
  (doseq [i [(solve-part-1 "../resources/test/Day01.txt")
             (solve-part-1 "../resources/main/Day01.txt")
             (solve-part-2 "../resources/test/Day01.txt")
             (solve-part-2 "../resources/main/Day01.txt")]]
    (println i)))