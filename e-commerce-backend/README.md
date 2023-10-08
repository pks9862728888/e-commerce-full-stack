# Read Me First
Demo project to showcase software development concepts which I learned.

# Getting Started

### Start Docker Server - db
```
docker run -d \
	--name moviebookingsystemdb \
	-e POSTGRES_DB=moviebookingsystemdb \
	-e POSTGRES_PASSWORD=secretpass \
	-e POSTGRES_USER=appuser \
	-e PGDATA=/var/lib/postgresql/data/pgdata \
	-v $PWD/.data:/var/lib/postgresql/data \
	-p 5432:5432 \
	postgres:16.0-alpine
```

```
docker run --name my-pgadmin -p 82:80 -e 'PGADMIN_DEFAULT_EMAIL=demo@yahoo.com' -e 'PGADMIN_DEFAULT_PASSWORD=12345' -d dpage/pgadmin4
```

### Concepts used
- Pagination and Sorting

### API endpoints
To fetch movies list:
```agsl
http://localhost:8080/v1/products?page=0&&size=5&&sort=name&&direction=ASC&&movieName=OnePlus
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.4/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.4/reference/htmlsingle/index.html#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
