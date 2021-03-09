#!/bin/bash

while getopts d:n: flag
do
    case "${flag}" in
        d) deployment_name=${OPTARG};;
        n) namespace=${OPTARG};;
    esac
done

oc patch "deployment/${deployment_name}" \
  -n "${namespace}" \
  -p "{\"spec\": {\"template\": {\"metadata\": { \"labels\": {  \"redeploy\": \"$(date +%s)\" }}}}}"
