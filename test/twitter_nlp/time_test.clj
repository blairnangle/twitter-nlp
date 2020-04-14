(ns twitter-nlp.time-test
  (:require [clojure.test :refer :all]
            [twitter-nlp.time]))

(deftest test-twitter-to-dt
  (is (= "2012-09-03T13:24:14.000Z" (str (twitter-nlp.time/twitter->datetime "Mon Sep 03 13:24:14 +0000 2012"))))
  (is (= "2012-09-03T00:24:14.000Z" (str (twitter-nlp.time/twitter->datetime "Mon Sep 03 00:24:14 +0000 2012"))))
  (is (= "2012-09-03T13:24:14.000Z" (str (twitter-nlp.time/twitter->datetime "Mon Sep 03 13:24:14 +0700 2012")))))

(deftest test-twitter-to-dt-tz
  (is (= "2012-09-03T13:24:14.000+01:00" (str (twitter-nlp.time/twitter->datetime-tz "Mon Sep 03 13:24:14 +0100 2012"))))
  (is (= "2012-09-03T13:24:14.000-08:30" (str (twitter-nlp.time/twitter->datetime-tz "Mon Sep 03 13:24:14 -0830 2012"))))
  (is (= "2012-12-01T13:24:14.000-09:47" (str (twitter-nlp.time/twitter->datetime-tz "Mon Dec 01 13:24:14 -0947 2012")))))
