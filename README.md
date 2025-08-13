Post Pilot
# Post Pilot

<img src="images/post-pilot.png" width="250">

---
About
---
Post Pilot helps you automatically share your posts to multiple social media platforms — saving time and effort.

It supports two main posting methods:

> A. Batch Post
- Post multiple items all at once.

How it works:

1. Upload a file with a list of posts

2. Select which social media platforms to post to

3. Click "Post Now"

4. The system sends the posts and notifies the admin if each post was successful or failed

> B. Scheduled Post
- Post a single item at a specific time in the future.

How it works:

1. Create a post and set a date and time to publish

2. Choose the social media platforms

3. The system will automatically post it at the scheduled time

4. Admin gets notified if the post was successful or failed


---
Database Server (mongodb)
---
C:\Program Files\MongoDB\Server\8.0\bin
> mongod

check if mongo is running
> netstat -ano | findstr :27017

Connection String:
> mongodb://localhost:27017/post_pilot

----
Swagger
----

> http://localhost:localport/swagger-ui.html

> http://localhost:9999/swagger-ui.html

---
Web server (ngrok)
---
Pre-requisite: download ngrok and signup to get token
1. execute command:
> ngrok config add-authtoken 30YMR2ia6phQ4XdQD73N9PAdFGw_7rwkaGMtMgGtzdt2cdcZX

> ngrok http http://localhost:9999

2. Then access it via web
>Ex. swagger endpoint (Note: generated url is from ngrok)

> https://51bed39203b5.ngrok-free.app/swagger-ui/index.html