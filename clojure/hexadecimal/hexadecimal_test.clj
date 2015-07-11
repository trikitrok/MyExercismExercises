(ns hexadecimal-test
  (:require [clojure.test :refer :all]))

(load-file "hexadecimal.clj")

(deftest hex-to-int-one-digit-test
  (is (= [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]
         (map hexadecimal/hex-to-int ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9" "a" "b" "c" "d" "e" "f"]))))

(deftest hex-to-int-several-digits-test
  (is (= 16 (hexadecimal/hex-to-int "10")))
  (is (= 175 (hexadecimal/hex-to-int "af")))
  (is (= 256 (hexadecimal/hex-to-int "100")))
  (is (= 105166 (hexadecimal/hex-to-int "19ace")))
  (is (= 16777215 (hexadecimal/hex-to-int "ffffff")))
  (is (= 16776960 (hexadecimal/hex-to-int "ffff00")))
  (is (= 0 (hexadecimal/hex-to-int "000000"))))

(deftest hex-to-int-invalid-hex
  (is (= 0 (hexadecimal/hex-to-int "carrot"))))

(run-tests)

