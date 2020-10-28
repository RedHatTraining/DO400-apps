#!/bin/bash
wc -w $1 | xargs | cut -f1 -d' '
