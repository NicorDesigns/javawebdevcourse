### A further introduction to JSP in a JEE 8

Use these (but for JEE8) to update these code examples:

https://www.baeldung.com/jsp#overview


##### [JEE 8 JSP Introduction Start Branch]
(https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-jsp-is-html-start)

#### 1. We learn about the JSP page directive at the top of the page 

##### By comparing html with jsp - in our web archetype copy the index.jsp to sample.jsp and remove the first line
(page directive) 

	<%@ page contentType="text/html;charset=UTF-8" language="java" %>

language specifies the scripting language to be used in a JSP, java is the default
contentType specifies the response header value to answer a request
	
	response.setContentType("text/html;charset=UTF-8") 
	
same as

	 response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");

and

	response.setHeader("text/html;charset=UTF-8")   

in the MultivalueParameterServlet		
 

#### 2. Directives, Declarations, Scriptlets and Expressions 


	<!-- A directive such as "page" specifies an action  -->
	<%@ a directive looks like this %>
	
	<!-- A declaration are used to declare instance variables, methods, inner classes  -->
	<%! This is a declaration %>
	
	<!-- A scriptlet is java code copied to the jspService method --> 
	<!-- therefore scope is thus method level and not global as above-->
	<%  this is a scriptlet %>
	
	<!-- A return value to be displayed in the page from an expression -->
	<!-- the scope is also method level as above-->
	
	<%= this is an expression %>
	
We will now put an example of all of the above together and examine its lifecycle in Tomcat 9

	example.jsp
		
and look at the *example.java file for a better understanding

#### 3. JSP Code Comments 

	<!-- HTML/XML Comments will be output to the page-->
	<!-- HTML/XML Comments will be show : <%= calculate.value() %>-->
	
	<%
		//Regular Java Comment in scriptlet
	
		/* Or commented out
		   java code */
	%>
	
	<%-- JSP Comment that wont be output to the page--%>

#### 3. Java Package/Class imports in JSP

	<% page import="java.util.ArrayList, java.io.Exception" %>
	<!-- You can separate or combine the imports and all other page directives-->
	
#### 4. JSP directives

	<%@ a directive looks like this %>
	
	pageEncoding  		<!--For character encoding -->
	
	session 		 		<!--Default is true JSP with access to session variable -->
	
	isELIgnored			<!--Default is true, parses Expression Language in JSP -->
	
	buffer, autoFlush 	<!--Default is 8kb and true specifies wether JSP output should be 							buffered-->
	
	errorPage				<!--Specifies the location of JSP Error Page -->	
	
	isErrorPage			<!--Specifies the JSP as an Error Page -->
	
	isThreadSafe  		<!--Default is true, specifies that the JSP can handle multiple requests-->	
	
	


Check in the end git branch of this slide show 

##### [JEE 8 JSP introduction Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-jsp-is-html-end)

    

