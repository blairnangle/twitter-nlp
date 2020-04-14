(ns twitter-nlp.time
  (:require clj-time.core))

(defn month->numeric
  "Coverts a three-letter representation of a month to its two-digit equivalent"
  [month]
  ((keyword (clojure.string/lower-case month)) {
                                                :jan 1
                                                :feb 2
                                                :mar 3
                                                :apr 4
                                                :may 5
                                                :jun 6
                                                :jul 7
                                                :aug 8
                                                :sep 9
                                                :oct 10
                                                :nov 11
                                                :dec 12
                                                }))

(defn twitter->datetime
  "Converts a Twitter-formatted timestamp to a Java DateTime object in UTC"
  [twitter]
  (let [v (clojure.string/split twitter #" ")]
    (clj-time.core/date-time
      (Integer/parseInt (last v))                           ; year
      (month->numeric (nth v 1))                          ; month
      (Integer/parseInt (nth v 2))                          ; day
      (Integer/parseInt (subs (nth v 3) 0 2))               ; hour
      (Integer/parseInt (subs (nth v 3) 3 5))               ; minute
      (Integer/parseInt (subs (nth v 3) 6)))                ; second
    ))

(defn twitter->datetime-tz
  "Converts a Twitter-formatted timestamp to a Java DateTime object which includes the timezone offset"
  [twitter]
  (let [tz (nth (clojure.string/split twitter #" ") 4)]
    (clj-time.core/from-time-zone (twitter->datetime twitter) (clj-time.core/time-zone-for-offset (Integer/parseInt (subs tz 0 3)) (Integer/parseInt (subs tz 3 5))))))
