DO
$body$
BEGIN
   IF NOT EXISTS (
      SELECT
      FROM   pg_roles
      WHERE  rolname = 'dbuser') THEN
      CREATE ROLE dbuser LOGIN PASSWORD 'dbuser';
      ALTER ROLE dbuser CREATEDB;
   END IF;
END
$body$;
