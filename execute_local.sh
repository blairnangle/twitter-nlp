#!/usr/bin/env bash

source ./auth.config

lein exec -p src/twitter_nlp/execute.clj ${api_key} ${api_secret_key} ${access_token} ${access_token_secret}

exit 0
