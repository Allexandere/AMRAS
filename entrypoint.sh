#!/bin/sh
# Wait for the database to be up
if [ -n "$HOST" ]; then
    ./wait-for-it.sh "$HOST:$PORT"
fi
# Run the CMD
exec "$@"