IMAGE_NAME ?= epilot/api

run-tests:
	mvn clean test

build:
	mvn clean package -amd

docker-build:
	docker build -t epilot/api .
	docker-compose up