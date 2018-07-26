#!/bin/bash

dir="/docker-entrypoint-initdb.d"

for file in `ls $dir/migration`; do 
    psql -f $dir/migration/$file -U $POSTGRES_USER $POSTGRES_DB
done