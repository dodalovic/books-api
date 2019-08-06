# Getting Started

Spring Boot + Kotlin + MongoDB based demo rest API

## Requires:

1. `docker-compose`
2. `java 8 JDK` 

## Running mongo

```
# Run in project root
$ docker-compose up -d
```

## Running app

```bash
# Run in project root
$ ./gradlew bootRun
```

## Bootstrap data

```shell
# Run in project root
$ curl -d '{"name":"John"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors
$ curl -d '{"name":"Jeanny"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors
$ curl -d '{"name":"Marry"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors
```

:bulb: Each curl response will show generated author ID. Use 3 generated IDs for the next calls:

```shell
# Run in project root
$ curl -d '{"name":"Book no. 1", "authorId": "AUTHOR_ID_FROM_THE_FIRST_CURL_CALL"}' -H "Content-Type: application/json" -X POST http://localhost:8080/books
$ curl -d '{"name":"Book no. 2", "authorId": "AUTHOR_ID_FROM_THE_SECOND_CURL_CALL"}' -H "Content-Type: application/json" -X POST http://localhost:8080/books
$ curl -d '{"name":"Book no. 3", "authorId": "AUTHOR_ID_FROM_THE_THIRD_CURL_CALL"}' -H "Content-Type: application/json" -X POST http://localhost:8080/books
```

Now you can call various API methods, using generated author, book IDs. Have fun! :smile: