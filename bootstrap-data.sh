#!/usr/bin/env bash

curl -d '{"name":"John"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors
curl -d '{"name":"Jeanny"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors
curl -d '{"name":"Marry"}' -H "Content-Type: application/json" -X POST http://localhost:8080/authors