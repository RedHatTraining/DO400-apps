#!/usr/bin/env python

import sys
import time
import logging
import urllib.request


logging.basicConfig(
    format='%(asctime)s %(levelname)-8s %(message)s',
    level=logging.INFO,
    datefmt='%Y-%m-%d %H:%M:%S')


def request(url):
    try:
        response = urllib.request.urlopen(url)
        logging.info(response.read().decode())
    except urllib.error.HTTPError as error:
        logging.error(error)


if len(sys.argv) < 2:
    print("Please specify URL")
    print("  EXAMPLE: check.py http://your/url")
    exit(1)


URL = sys.argv[1]
print("Checking {}\n".format(URL))

while True:
    request(URL)
    time.sleep(1)
