# twitter-nlp

![](https://github.com/blairnangle/twitter-nlp/workflows/CI/badge.svg) ![](https://github.com/blairnangle/twitter-nlp/workflows/Cron/badge.svg)

Fetches and analyses tweets to [@isthisasentence](https://twitter.com/isthisasentence) and replies to the sender of the
original tweet. Currently, it just replies with a message thanking the tweeter for their tweet.

Makes use of the [twitter-api](https://github.com/adamwynne/twitter-api) Clojure library.

## Prerequisites

* [Leiningen](https://github.com/technomancy/leiningen) (built with 2.9.1)
* [Clojure](https://github.com/clojure/clojure) 1.10.0
* [lein-exec](https://github.com/kumarshantanu/lein-exec) 0.3.7

## Installation

To fetch `:dependencies` listed in `project.clj`:

```bash
$ lein deps
```

## Usage

Making use of lein-exec, the program can be executed using a bash script. locally:

```bash
$ ./execute_local.sh
```

Provided the account's Twitter authentication credentials are stored in `./auth.config` in this format:

```bash
api_key="your api key"
api_secret_key="your api secret key"
access_token="your access token"
access_token_secret="your access token secret"
```

## Current Implementation

The program is executed on a cron schedule every thirty minutes by a GitHub Actions workflow. There is some logic 
within the code that means only tweets from the last thirty minutes are replied to.

This is bad for a number of reasons included the high chance of missing tweets due to a delay in cron execution and 
the inefficiency in checking the time for every tweet that the GET `statuses/mentions_timeline` API returns.

These issues could be solved by either:
* Using the Twitter streaming API and deploying the program as an always-up web application
* Regular executions backed by a persistent store of some sort that keeps track of which tweets have been replied to

## License

Distributed under [MIT License](./LICENSE).
