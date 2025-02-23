#!/bin/bash

./payara/bin/asadmin --port 3048 deploy --force=true ./app/build/libs/diceThrow.war
./payara/bin/asadmin --port 3048 list-applications