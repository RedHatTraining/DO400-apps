#!/bin/bash

oc patch deployment/shopping-cart-v2 \
  -n ${1} \
  -p "{\"spec\": {\"template\": {\"metadata\": { \"labels\": {  \"redeploy\": \"$(date +%s)\"}}}}}"
