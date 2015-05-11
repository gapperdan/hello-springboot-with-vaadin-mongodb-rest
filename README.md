#Tutorial for Spring Boot, Spring Data for Mongo and Vaadin

* uses Java 7

### Needs a local mongodb to test

* create a database 'test'
* create a collection 'countries'
* import the sample data under /resources/mongo/countries.json

### To run
```
./gradlew bootRun
```

The app will read the countries collection and display data in the browser