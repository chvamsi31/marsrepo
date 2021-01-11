# Person Service

In this app, I have used H2 in-memory as in memory database

**Application.properties**

```
spring.datasource.url=jdbc:h2:mars:marsdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=system
spring.datasource.password=test
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.h2.console.enabled=true
```

Used JPA repositories for CRUD operations

```
public interface PersonRepository extends JpaRepository<Employee, Integer>{
}

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
```

**To Run the app**

```
> mvn clean install
> java -jar target/person-service-0.0.1-SNAPSHOT.jar
```

**To test the app**

```
Run the test cases from PersonServiceTest under src/main/test/com.mars.service.test
```

