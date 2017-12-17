set -e
echo '

creating a Role for the database
*****************************************'
psql -f create_role.sql postgres
echo '

creating the db
*****************************************'
psql -f create_db.sql postgres -U dbuser
echo '

creating tables
*****************************************'
psql -f create_tables.sql library -U dbuser
echo '

adding entities
*****************************************'
psql -f add_entities.sql library -U dbuser
