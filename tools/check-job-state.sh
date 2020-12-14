#!/bin/bash

oc logs -f jobs/${1} && \
podState=$(oc get pods --selector=job-name=${1} \
  --output=jsonpath='{.items[0].status.containerStatuses[0].state.terminated.exitCode}')

if [ "${podState}" -eq 0 ]
then
  exit 0
fi

exit 1
