#!/bin/bash

# Path to the .env file
ENV_FILE=".env"

if [ ! -f "$ENV_FILE" ]; then
  echo "Error: $ENV_FILE does not exist"
  exit 1
fi

while IFS= read -r line; do
  if [[ ! -z "$line" && ! "$line" =~ ^# ]]; then
    NAME=$(echo "$line" | cut -d= -f1)
    VALUE=$(echo "$line" | cut -d= -f2-)

    #var="$NAME"="$VALUE"
    export "$NAME"="$VALUE"
  fi
done < "$ENV_FILE"

echo "Environment variables set from $ENV_FILE"
