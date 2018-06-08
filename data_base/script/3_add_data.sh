#!/bin/bash

dir="/docker-entrypoint-initdb.d"

for file in `ls $dir/data`; do 
    psql -f $dir/data/$file -U $POSTGRES_USER $POSTGRES_DB
done