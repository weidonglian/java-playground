## Simple Notes

* Login `http://localhost:8080/h2-console` and Make sure that you use jdbc:h2:mem:testdb as JDBC URL. The embedded 
database is automatically created by the spring boot. How did all the magic happen? Google it to learn more.
* The H2 default mode (non-persistent mode) is great for running unit tests. You can put it in your 
test/resources/application.properties
* The spring boot application will normally run the data.sql commends to initialize the database.
* With the following configs, we can enable the persistent mode even though this is not recommended in practical 
application. 

    ```
    spring.datasource.name=yourdbname
    spring.datasource.driverClassName=org.h2.Driver
     
    spring.datasource.initialize=false
    spring.datasource.url=jdbc:h2:file:~/yourdbname;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE;DB_CLOSE_DELAY=-1;
     
    spring.jpa.hibernate.ddl-auto = update
    ```