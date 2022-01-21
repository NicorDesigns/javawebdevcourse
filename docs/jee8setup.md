Git Start Branch

https://github.com/NicorDesigns/eclipsejee8helloworld/tree/main

Create parent-pom from mojo archetype and demo

Check in into Github using Eclipse (Explain Token Generation process)

 https://stackoverflow.com/questions/32527522/how-to-github-two-factor-authentication-with-eclipse
 
Create a child module inside the POM module using:

 https://mvnrepository.com/artifact/org.apache.maven.archetypes/maven-archetype-webapp version 1.4
 
Group Id :  com.nicordesigns

Artifact Id : jee8webarchetype

Package : com.nicordesigns.jee8webarchetype

Update the generated module to JEE8 in Eclipse

Show Eclipse Problem View - Go through listed Problems and resolve them

Upgrade to Java 1.8

Add the following Maven Dependency:
 
	<dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
    </dependency>

Update the Maven Project using the Eclipse option

Go through and resolve all the warnings in the Eclipse Problem View and talk through each of them

Update web.xml and all related Eclipse Facets

Add Tomcat 9 runtime in Facet

Demonstrate that the JSP Hello Page Show

Check in the end git branch of this slide show 


    

