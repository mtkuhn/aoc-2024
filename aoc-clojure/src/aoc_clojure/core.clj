(ns aoc-clojure.core)

(defn parse-lists-of-longs [file]
  (->> (slurp file)
       (clojure.string/split-lines)
       (map #(clojure.string/split % #"\s+"))
       (map #(map parse-long %))))

