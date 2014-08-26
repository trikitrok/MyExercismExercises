(ns roman-numerals.test (:require [clojure.test :refer :all]))
(load-file "roman_numerals.clj")

(deftest one
  (is (= "I" (roman-numerals/numerals 1))))

(deftest two
  (is (= "II" (roman-numerals/numerals 2))))

(deftest three
  (is (= "III" (roman-numerals/numerals 3))))

(deftest four
  (is (= "IV" (roman-numerals/numerals 4))))

(deftest five
  (is (= "V" (roman-numerals/numerals 5))))

(deftest six
  (is (= "VI" (roman-numerals/numerals 6))))

(deftest nine
  (is (= "IX" (roman-numerals/numerals 9))))

(deftest twenty-seven
  (is (= "XXVII" (roman-numerals/numerals 27))))

(deftest forty-eight
  (is (= "XLVIII" (roman-numerals/numerals 48))))

(deftest fifty-nine
  (is (= "LIX" (roman-numerals/numerals 59))))

(deftest ninety-three
  (is (= "XCIII" (roman-numerals/numerals 93))))

(deftest one-hundred-forty-one
  (is (= "CXLI" (roman-numerals/numerals 141))))

(deftest one-hundred-sixty-three
  (is (= "CLXIII" (roman-numerals/numerals 163))))

(deftest four-hundred-two
  (is (= "CDII" (roman-numerals/numerals 402))))

(deftest five-hundred-seventy-five
  (is (= "DLXXV" (roman-numerals/numerals 575))))

(deftest nine-hundred-eleven
  (is (= "CMXI" (roman-numerals/numerals 911))))

(deftest one-thousand-twenty-four
  (is (= "MXXIV" (roman-numerals/numerals 1024))))

(deftest three-thousand
  (is (= "MMM" (roman-numerals/numerals 3000))))

(deftest three-thousand-four-hundred
  (is (= "MMMCD" (roman-numerals/numerals 3400))))

(deftest three-thousand-four-hundred-and-ninety-nine
  (is (= "MMMCDXCIX" (roman-numerals/numerals 3499))))

(deftest three-thousand-five-hundred
  (is (= "MMMD" (roman-numerals/numerals 3500))))

(deftest three-thousand-eight-hundred-and-ninety-nine
  (is (= "MMMDCCCXCIX" (roman-numerals/numerals 3899))))

(deftest three-thousand-nine-hundred
  (is (= "MMMCM" (roman-numerals/numerals 3900))))

(deftest three-thousand-nine-hundred-and-ninety-nine
  (is (= "MMMCMXCIX" (roman-numerals/numerals 3999))))

(deftest four-thousand
  (is (= "--\nIV" (roman-numerals/numerals 4000))))

(deftest four-thousand
  (is (= "--\nIVI" (roman-numerals/numerals 4001))))

(deftest huge-number-1
  (is (= "---------\nMMMCMXCIXV" (roman-numerals/numerals 3999005))))

(deftest four-millions
  (is (= "--\n--\nIV" (roman-numerals/numerals 4000000))))

(deftest four-millions-and-twenty-five
  (is (= "--\n--\nIVXXV" (roman-numerals/numerals 4000025))))

(deftest four-millions-one-hundred-and-fifty
  (is (= "--\n--\nIVCL" (roman-numerals/numerals 4000150))))

(deftest huge-number-2
  (is (= "---------\n---------\nMMMCMXCIXCL" (roman-numerals/numerals 3999000150))))

(run-tests)
