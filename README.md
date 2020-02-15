# Summary

The project run on Port 4567 (default JavaSpark port). 
Basically the application have two endpoints:

1. /baz/:number
2. /fiz/:number

The return is described below:

```$xslt
{
  "result": true
}
```

## Requirements to run:

1. docker
2. docker-compose

To create and run project using docker:

```
make docker-build
```

To test project:

```
make run-tests
```

To generate **jar** for local tests:

```
make build
```