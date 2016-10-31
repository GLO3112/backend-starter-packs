
# java-starter

Le Java Starter Pack utilise [Spring Boot](https://projects.spring.io/spring-boot/) comme framework. Il offre un serveur roulant par défaut
sur le port 8080. Il est également intégré avec le SDK de AWS, ainsi que [Spring Data](http://projects.spring.io/spring-data/) pour la 
communication avec la base de données et [Spring Data Redis](http://projects.spring.io/spring-data-redis/) pour la communication avec Redis.
De plus, un exemple de projet de test est offert. Évidemment, vous devrez avoir Java 8 et Maven d'installés sur votre ordinateur.

Finalement, le logging est configuré pour utiliser AWS CloudWatch logs, voir fichier logback.xml.

# Tutoriels recommandés
* [Spring Boot Getting Started](https://spring.io/guides/gs/spring-boot/)
* [Spring Data - JPA Hibernate](https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-mysql-springdatajpa-hibernate)
* [Working with AWS Credentials](http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html)
* [Logback AWSLogs appender](https://github.com/pierredavidbelanger/logback-awslogs-appender)


# Compiler

```sh
mvn clean install
```

# Exécuter

Ouvrir Eclipse, et simplement exécuter la classe `SampleApplication` en tant que Java Application.

# Exécuter les tests

Les tests utilisent JUnit et Mockito. Nous recommandons également l'installation de EclEmma dans Eclipse afint d'avoir un aperçu du 
coverage de vos tests.

```sh
mvn clean test
```
