# spring-boot-redis-example

### ZADD and ZREVRANGE with spring boot example 

```bash
$ docker run --name my-redis -p 6379:6379 --restart always --detach redis
```

```bash
mvn spring-boot:run
```
Goto browser: <br>
http://localhost:8080/rest/user/add/doncic <br>
http://localhost:8080/rest/user/add/dirk <br>

```json
[
{
"score": 29,
"value": "d77"
},
{
"score": 4,
"value": "dirk"
}
]
```

http://localhost:8080/rest/user/delete/doncic