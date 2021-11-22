#!/bin/bash

while getopts u:p:b:r: flag
do
    case "${flag}" in
        u) quay_user=${OPTARG};;
        p) quay_password=${OPTARG};;
        b) build_number=${OPTARG};;
	      r) quay_repo=${OPTARG};;
    esac
done

./mvnw package -DskipTests \
  -Dquarkus.jib.base-jvm-image=quay.io/redhattraining/do400-java-alpine-openjdk11-jre:latest \
  -Dquarkus.container-image.build=true \
  -Dquarkus.container-image.registry=quay.io \
  -Dquarkus.container-image.group="${quay_user}" \
  -Dquarkus.container-image.name="${quay_repo}" \
  -Dquarkus.container-image.username="${quay_user}" \
  -Dquarkus.container-image.password="${quay_password}" \
  -Dquarkus.container-image.tag="1.0.0-${build_number}" \
  -Dquarkus.container-image.additional-tags="latest" \
  -Dquarkus.container-image.push=true
