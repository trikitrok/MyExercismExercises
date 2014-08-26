(ns scrabble-score.test (:require [clojure.test :refer :all]))
(load-file "scrabble_score.clj")

(deftest lower-case-letter
  (is (= 1 (scrabble_score/score-letter "a"))))

(deftest upper-case-letter
  (is (= 1 (scrabble_score/score-letter "A"))))

(deftest letters-scoring-1
  (is (= 10 (scrabble_score/score-word "AEIOULNRST") (scrabble_score/score-word "aeioulnrst"))))

(deftest letters-scoring-2
  (is (= 4 (scrabble_score/score-word "DG") (scrabble_score/score-word "dg"))))

(deftest letters-scoring-3
  (is (= 12 (scrabble_score/score-word "BCMP") (scrabble_score/score-word "bcmp"))))

(deftest letters-scoring-4
  (is (= 20 (scrabble_score/score-word "FHVWY") (scrabble_score/score-word "fhvwy"))))

(deftest letters-scoring-5
  (is (= 5 (scrabble_score/score-word "K") (scrabble_score/score-word "k"))))

(deftest letters-scoring-8
  (is (= 16 (scrabble_score/score-word "JX") (scrabble_score/score-word "jx"))))

(deftest letters-scoring-10
  (is (= 20 (scrabble_score/score-word "QZ") (scrabble_score/score-word "qz"))))

(deftest two-letter-word
  (is (= 2 (scrabble_score/score-word "at"))))

(deftest bigger-word-1
  (is (= 6 (scrabble_score/score-word "street"))))

(deftest bigger-word-2
  (is (= 22 (scrabble_score/score-word "quirky"))))

(deftest all-upper-case-word
  (is (= 20 (scrabble_score/score-word "MULTIBILLIONAIRE"))))

(run-tests)
