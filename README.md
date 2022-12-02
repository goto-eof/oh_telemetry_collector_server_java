# POC | Open Hospital Telemetry Collector

### In order to run Open Hospital Telemetry

You can just run

```
docker-compose up
```

and then test application with Postman (remember to import postman.json)

Or

 Run Postgres.

 ```
 docker-compose -f docker-compose-dbms.yml up
 ```

 And then run as Spring Boot application from Eclipse;

 Import in Postman the postam.json collection and make the Post request.

### DB connection

```
postgres://127.0.0.1:5432/postgres
username: postgres
password: postgres
```