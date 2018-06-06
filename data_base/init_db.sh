set -e

current_dir=`pwd`

. $current_dir/../.env

user=$ENV_DB_USER_NAME
db=$ENV_DB_NAME
pass=$ENV_DB_USER_PASSWORD

echo '
creating a Role for the database
*****************************************'
psql -c "CREATE USER $user WITH PASSWORD '$pass'" -U "pulsar-admin" -p 5433 -h localhost postgres 
psql -c "ALTER USER $user WITH CREATEDB" -U "pulsar-admin" -p 5433 -h localhost postgres

echo '
creating the db
*****************************************'
psql -c "CREATE DATABASE $db" -U $user -w $pass -p 5433 -h localhost postgres

echo '
creating tables
*****************************************'
psql -f create_tables.sql -U $user $db -w $pass -p 5433 -h localhost

migrationfiles="$current_dir/migration/*.sql"

if [ -d $migrationfiles ]; then
    for file in $migrationfolder; do
        psql -f file $file -U $user $db -p 5433 -h localhost
    done
fi

echo '
adding entities
*****************************************'
psql -f add_entities.sql -U $user $db -p 5433 -h localhost
