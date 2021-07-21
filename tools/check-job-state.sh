#!/bin/bash

oc wait --for=condition=ContainersReady \
  --timeout=60s pod --selector job-name=${1} -n ${2}

oc logs -f jobs/${1} -n ${2} && \
podState=$(oc get pods --selector=job-name=${1} -n ${2} \
  --output=jsonpath='{.items[0].status.containerStatuses[0].state.terminated.exitCode}')

if [ "${podState}" -eq 0 ]
then
  exit 1
fi

exit 0
