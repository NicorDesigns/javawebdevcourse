## Using Forms and parameters in the JEE 8 Web Hello World Servlet module

##### [JEE 8 Web Forms Start Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-debug-start)

### 1. Update the HelloWorldServlet to use annotations and present the user with an input form

###### Use the @WebServlet annotation to decorate the HelloWorldServlet

	@WebServlet(
        name = "helloServlet",
        urlPatterns = {"/greeting", "/salutation", "/wazzup"},
        loadOnStartup = 1
	)

###### Expand the HelloWorldServlet to present the User with an input form

	String user = request.getParameter("user");
        if(user == null)
            user = HelloServlet.DEFAULT_USER;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
              .append("<html>\r\n")
              .append("    <head>\r\n")
              .append("        <title>Hello User Application</title>\r\n")
              .append("    </head>\r\n")
              .append("    <body>\r\n")
              .append("        Hello, ").append(user).append("!<br/><br/>\r\n")
              .append("        <form action=\"greeting\" method=\"POST\">\r\n")
              .append("            Enter your name:<br/>\r\n")
              .append("            <input type=\"text\" name=\"user\"/><br/>\r\n")
              .append("            <input type=\"submit\" value=\"Submit\"/>\r\n")
              .append("        </form>\r\n")
              .append("    </body>\r\n")
              .append("</html>\r\n");
	
### 2. Remove or comment out the Servlet config code in web.xml and update the index.jsp landing page code

	<!-- 	<servlet> -->
	<!-- 		<servlet-name>helloServlet</servlet-name> -->
	<!-- 		<servlet-class>com.nicordesigns.HelloWorldServlet</servlet-class> -->
	<!-- 	</servlet> -->
	
	<!-- 	<servlet-mapping> -->
	<!-- 		<servlet-name>helloServlet</servlet-name> -->
	<!-- 		<url-pattern>/hello-world</url-pattern> -->
	<!-- 	</servlet-mapping> -->
	
	<welcome-file-list>
		<welcome-file>index.html</welcome-file>
		<welcome-file>index.jsp</welcome-file>
		<welcome-file>index.htm</welcome-file>
		<welcome-file>default.html</welcome-file>
		<welcome-file>default.jsp</welcome-file>
		<welcome-file>default.htm</welcome-file>
	</welcome-file-list>
	
	<html>
	<head>
	    <title>Hello, World Application Index File</title>
	  </head>
	<body>
	<h2>Hello World!</h2>
	<a href="hello-world">Present the Hello World Input Form...</a>.
	Java runtime version: <%= System.getProperty("java.version") %>
	</body>
	</html>
	
	

##### Run the Web App

##### Demonstrate that both the doGet() and doPost() method will accept and display the name parameter by using URL and Form

We will make use of logging here for better understanding 

### 4. Now add the Multi-Part Form Servlet


	response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
        .append("<html>\r\n")
        .append("    <head>\r\n")
        .append("        <title>Hello World Application</title>\r\n")
        .append("    </head>\r\n")
        .append("    <body>\r\n")
        .append("        <form action=\"checkboxes\" method=\"POST\">\r\n")
        .append("Select the colors you like:<br/>\r\n")
        .append("<input type=\"checkbox\" name=\"color\" value=\"Yellow\"/>")
        .append(" Yellow<br/>\r\n")
        .append("<input type=\"checkbox\" name=\"color\" value=\"Black\"/>")
        .append(" Black<br/>\r\n")
        .append("<input type=\"checkbox\" name=\"color\" value=\"Orange\"/>")
        .append(" Orange<br/>\r\n")
        .append("<input type=\"checkbox\" name=\"color\" value=\"Red\"/>")
        .append(" Red<br/>\r\n")
        .append("<input type=\"checkbox\" name=\"color\" value=\"Blue\"/>")
        .append(" Blue<br/>\r\n")
        .append("<input type=\"submit\" value=\"Submit\"/>\r\n")
        .append("        </form>")
        .append("    </body>\r\n")
        .append("</html>\r\n");
	 

 

Check in the end git branch of this slide show 
##### [JEE 8 Hello World Servlet Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-servlet-finish)

    

