#!/bin/bash
./mvnw quarkus:add-extension \
  -Dextensions="kubernetes,container-image-jib"
