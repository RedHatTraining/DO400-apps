#!/bin/bash

oc wait --for=condition=complete \
  --timeout=60s job ${1} -n ${2}

oc logs --selector=job-name=${1} -n ${2} --tail=-1

echo "Check for '${3}'"

oc logs --selector=job-name=${1} -n ${2} --tail=-1 | grep "${3}"
