#!/bin/bash

dir="/docker-entrypoint-initdb.d"

for file in `ls $dir/init`; do 
    psql -f $dir/init/$file -U $POSTGRES_USER $POSTGRES_DB
done
