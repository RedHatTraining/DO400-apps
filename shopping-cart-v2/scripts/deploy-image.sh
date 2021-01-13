#!/bin/bash

while getopts u:t:n: flag
do
    case "${flag}" in
        u) quay_user=${OPTARG};;
        t) image_tag=${OPTARG};;
        n) app_namespace=${OPTARG};;
    esac
done

oc set image deployment/shopping-cart-v2 \
  -n "${app_namespace}" \
  "shopping-cart-v2=quay.io/${quay_user}/do400-recover:${image_tag}"
