# POC | Open Hospital - Telemetry Collector (Java)
See also [oh_telemetry_collector_server_rust](https://github.com/goto-eof/oh_telemetry_collector_server_rust) (has the same features, but it was developed in Rust) and [oh_telemetry_collector_test_load](https://github.com/goto-eof/oh_telemetry_collector_load_test).

[Here](https://openhospital.atlassian.net/browse/OP-952) is the Jira ticket.

<p align="center" width="100%">
    <img width="50%" src="dev-stack2.png"> 
</p>

### In order to run Open Hospital Telemetry

You can just run

```
docker-compose up
```

and then test application with Postman (remember to import postman.json).

Or

 Run Postgres.

 ```
 docker-compose -f docker-compose-dbms.yml up
 ```

 And then run as Spring Boot application from Eclipse;

 Import in Postman the postam.json collection and make the Post request.

### Server

The server responds to the following URL (POST):

```
http://localhost:8015/telemetry
```

### DB connection


You can check stored data using the following credentials:


```
postgres://127.0.0.1:5433/postgres
username: postgres
password: postgres
```
