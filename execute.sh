#!/usr/bin/env bash

lein exec -p src/twitter_nlp/execute.clj ${1} ${2} ${3} ${4}

exit 0
