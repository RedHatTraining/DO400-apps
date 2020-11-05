#!/usr/bin/env sh

# Always set the current working directory as the project's root
PROJECT_ROOT=$(cd $(dirname $0)/.. && pwd)

# HTTP method
METHOD=$1

# Run server
node $PROJECT_ROOT/backend/server &
PID=$!

# Try to make a successful request
for i in {1..3}
do
    curl -Is -X $METHOD http://localhost:3000 | grep 200
    EXITCODE=$?

    if [ $EXITCODE -eq 0 ]
    then
        break
    fi

    sleep 1
done

# Stop server
kill -15 $PID

exit $EXITCODE
