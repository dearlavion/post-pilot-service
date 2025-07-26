Post Pilot
# Post Pilot

<img src="images/post-pilot.png" width="250">

---
Run mongodb server
---
C:\Program Files\MongoDB\Server\8.0\bin
> mongod

check if mongo is running
> netstat -ano | findstr :27017

Connection String:
> mongodb://localhost:27017/post_pilot

----
Access Swagger on local
----
http://localhost:<port>/swagger-ui.html
http://localhost:9999/swagger-ui.html