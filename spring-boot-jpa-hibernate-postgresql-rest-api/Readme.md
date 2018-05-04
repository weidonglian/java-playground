## Steps to Setup

#### Configure PostgreSQL

First, create a database named `postgres_sbjhpra`. Then, open `src/main/resources/application.properties` file and 
change the spring datasource username and password as per your PostgreSQL installation.

Following are the bash commands to create a postgres database on Ubuntu 16.04 LTS.

```bash
sudo -iu postgres psql -c "ALTER USER postgres PASSWORD 'postgres';"
sudo -iu postgres psql -c "CREATE DATABASE postgres_sbjhpra;"
sudo -iu postgres psql -c "ALTER DATABASE postgres_sbjhpra SET TIMEZONE TO 'UTC';"
sudo service postgresql start
```

#### Run the app

Type the gradle tasks to build, test, boot-run
