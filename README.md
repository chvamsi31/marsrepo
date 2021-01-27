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

**Test URL's**
```
1. Add Person : http://localhost:8181/addperson
2. Edit Person : http://localhost:8181/updateperson
3. Delete Person : http://localhost:8181/deleteperson
4. Add Address : http://localhost:8181/addaddress
5. Update Address : http://localhost:8181/updateaddress
6. Delete Address : http://localhost:8181/deleteaddress
7. Person's Count : http://localhost:8181/personcount
8. Person's List : http://localhost:8181/allpersons

```


**Test Cases**

```
Run the test cases from PersonServiceTest under src/main/test/com.mars.service.test
```


