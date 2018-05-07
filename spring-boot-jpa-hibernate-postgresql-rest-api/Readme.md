## Steps to Setup

#### Configure PostgreSQL

First, create a database named `learning_restapi`. Then, open `src/main/resources/application.properties` file and 
change the spring datasource username and password as per your PostgreSQL installation.

Following are the bash commands to create a postgres database on Ubuntu 16.04 LTS.

```
sudo -iu postgres psql -c "ALTER USER postgres PASSWORD 'postgres';"
sudo -iu postgres psql -c "CREATE DATABASE learning_restapi;"
sudo -iu postgres psql -c "ALTER DATABASE learning_restapi SET TIMEZONE TO 'UTC';"
sudo service postgresql start
```

#### Run the app

Type the gradle tasks to build, test, boot-run
