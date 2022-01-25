## Updating the JEE 8 Web Application Module with a Hello World Servlet

#### [JEE 8 Hello World Servlet Start Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-servlet-start)

### 1. Add the actual servlet code

##### com.nicordesigns.HelloWorldServlet

### 2. Add the servlet config to web.xml

##### com.nicordesigns.HelloWorldServlet

	<servlet>
		<servlet-name>helloServlet</servlet-name>
		<servlet-class>com.nicordesigns.HelloWorldServlet</servlet-class>
	</servlet>

	<servlet-mapping>
		<servlet-name>helloServlet</servlet-name>
		<url-pattern>/greeting</url-pattern>
	</servlet-mapping>


#####  

### 4. Demonstrate that the Hello World Servlet works


Check in the end git branch of this slide show 
#### [JEE 8 Hello World Servlet Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-servlet-finish)

    

