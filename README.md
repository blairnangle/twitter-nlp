# twitter-nlp

Fetches and analyses tweets to [@isthisasentence](https://twitter.com/isthisasentence) and replies to the sender of the
original tweet. Currently, it just replies with a message thanking the tweeter for their tweet.

## Usage

The program uses [`lein exec`](https://github.com/kumarshantanu/lein-exec) to run from the command line. Locally:

```bash
$ ./execute_local.sh
```

Provided the Twitter authentication credentials are stored in `./auth.config` in this format:

```bash
api_key="your api key"
api_secret_key="your api secret key"
access_token="your access token"
access_token_secret="your access token secret"
```
