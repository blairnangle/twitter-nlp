(defproject twitter-nlp "0.1.0-SNAPSHOT"
  :description "Serves the Twitter bot @isthisasentence"
  :url "http://twitter.com/isthisasentence"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [twitter-api "1.8.0"]
                 [clj-time "0.15.2"]]
  :plugins [[lein-exec "0.3.7"]]
  :main ^:skip-aot twitter-nlp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
