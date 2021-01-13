#!/bin/bash

while getopts u:p:b: flag
do
    case "${flag}" in
        u) quay_user=${OPTARG};;
        p) quay_password=${OPTARG};;
        b) build_number=${OPTARG};;
    esac
done

./mvnw -Drevision="${build_number}" package -DskipTests \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.registry=quay.io \
  -Dquarkus.container-image.group="${quay_user}" \
  -Dquarkus.container-image.name=do400-recover \
  -Dquarkus.container-image.username="${quay_user}" \
  -Dquarkus.container-image.password="${quay_password}" \
  -Dquarkus.container-image.additional-tags="latest" \
  -Dquarkus.container-image.push=true
