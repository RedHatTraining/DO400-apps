#!/bin/bash

function tag_exists() {
    curl -sfSL https://quay.io/v1/repositories/$1/tags/$2 &> /dev/null
}

echo "Checking the existence of the tag $2 in the repository $1"

if tag_exists ${1} ${2}; then
    echo "Tag exists"
    exit 0
fi

echo "Tag not found!"
exit 1
