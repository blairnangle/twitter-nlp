#!/usr/bin/env lein-exec

(require '[twitter-nlp.time]
         '[twitter.api.restful]
         '[clj-time.core])

(defn- get-mentions
  [creds]
  (:body (twitter.api.restful/statuses-mentions-timeline :oauth-creds creds)))

(defn- remove-at-isthisasentence
  [text]
  (clojure.string/join " " (remove #(= "@isthisasentence" %) (clojure.string/split text #" "))))

(defn- reply-to-tweet
  [tweet creds]
  (when (clj-time.core/after? (twitter-nlp.time/twitter->datetime-tz (:created_at tweet)) (-> 30 clj-time.core/minutes clj-time.core/ago))
    (twitter.api.restful/statuses-update :oauth-creds creds
                                         :params
                                         {
                                          :status                (str "@" (get-in tweet [:user :screen_name]) " Thanks for tweeting \"" (remove-at-isthisasentence (:text tweet)) "\" at me!")
                                          :in-reply-to-status-id (:id_str tweet)
                                          })))

(defn- reply-to-tweets
  [tweets creds]
  (doall (map #(reply-to-tweet % creds) tweets)))

(defn- execute
  [creds]
  (-> creds
      (get-mentions)
      (reply-to-tweets creds)))

(execute (twitter.oauth/make-oauth-creds (nth *command-line-args* 1) (nth *command-line-args* 2) (nth *command-line-args* 3) (nth *command-line-args* 4)))

(http.async.client/close (twitter.core/default-client))
