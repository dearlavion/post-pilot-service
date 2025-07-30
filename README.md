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
> http://localhost:localport/swagger-ui.html
http://localhost:9999/swagger-ui.html

---
ngrok
---
Pre-requisite: download ngrok and signup to get token
1. execute command:
> ngrok config add-authtoken 30YMR2ia6phQ4XdQD73N9PAdFGw_7rwkaGMtMgGtzdt2cdcZX

> ngrok http http://localhost:9999

2. Then access it via web
>Ex. swagger endpoint (Note: generated url is from ngrok)

> https://51bed39203b5.ngrok-free.app/swagger-ui/index.html