# 2. Using Logging Level and Categories

The most commonly used logging Log4j2 levels are : 

- INFO - when you log information as in what is happening
- DEBUG - when you switch on the debugging switch to track down a bug
- ERROR - When you log all Exceptions in your Java code

We also often need to also categorize your logging according to specific parts of your app or service in a distributed web app.


### Why do we use these different levels of logging?
We've seen why in the common levels above, and we can deduce that we don't want to flood our logs with noise in production and we do not want to overload the logs no matter where and how they are implemented. There are obviously more levels and each Java Logging Framework has their own sets of levels and ways to implement them.

Logging levels in [java.util.logging.Level](https://docs.oracle.com/en/java/javase/11/docs/api/java.logging/java/util/logging/package-summary.html)

We will look at them and read through them: 
Defined [Logging Levels](https://docs.oracle.com/en/java/javase/11/docs/api/java.logging/java/util/logging/Level.html)

this is a look at just one of the many Java Logging Frameworks


### Logging Categories

Categories are usually represented by an instance of a named Logger class.
A standard Java logging pattern for cloud based development is to have one of these defined in each of your classes and then in turn each of these can log at a specific level and to have a cofigured hierachy of defined levels for each class

### Sifting through logs
We can decide where logs end up in a cloud system through telling which category ends up in whic log destination endpoint. Depending on which framework we use we can have many ways of setting up logging endpoints.
