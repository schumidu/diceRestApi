#!/bin/bash

PROJECT_DIR=../../..

PAYARA_MAJOR=6
PAYARA_VERION=$PAYARA_MAJOR.2024.12
PAYARA_ZIP=payara-$PAYARA_VERION.zip
PAYARA_DIR=$PROJECT_DIR/payara
ASADMIN=$PAYARA_DIR/bin/asadmin

RESOURCES=../../resources

echo "Start setup payara for dev"
echo "Remove old payara"
rm -rf $PAYARA_DIR

echo "Unzip payara"
unzip -oq $RESOURCES/$PAYARA_ZIP
mv payara$PAYARA_MAJOR $PAYARA_DIR

echo "Setup payara"
$ASADMIN --port 3048 multimode --file setup.asadmin