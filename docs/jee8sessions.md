### Maintaining State Using Sessions in our JEE 8 Web App Module

Use these (but for JEE8) to update these code examples:

[Jakarta Servlet Specification - Sessions](https://jakarta.ee/specifications/servlet/5.0/jakarta-servlet-spec-5.0.html#sessions)

We will now return to our charity registration example and start to introduce State and Session Management

##### [Maintaining State Using Sessions Start Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-start)

#### 1. Why sessions are necessary (Slide 2)

###### HTTP is a stateless protocol, HTTPSessions is a way to track users for example Amazon Shopping Cart
###### HTTPSessions are a way to maintain state (items in shopping cart)
###### HTTPSessions are a way to remember Users for example your Reddit User Name
###### HTTPSessions are a way to manage Workflow as in our example of Registering a Charity in an Online DB


#### 2. Working with cookies and URL parameters (Slide 3) 

###### A session is a data object maintained by the server or web application (user name etc)
###### For the users browser to be able to "track" the server generates a SessionID string that gets send back to the browser on every request (Add PlantUML diagram here)
###### HTTPSessions are a way to remember Users for example your Reddit User Name
###### HTTPSessions are a way to manage Workflow as in our example of Registering a Charity in an Online DB

1. HTTP1.1 defines session cookies [HTTP Cookie](https://en.wikipedia.org/wiki/HTTP_cookie) which can be sent from
the web server to the browser and stored locally by the browser to be sent back. This is how the JSESSIONID will
get to be "persisted" on the client browser side during a session  
2. SessionID is passed in the URL query string from the server to the client side web browser after a session has
been established on the web server, this process is called URL re-writing and can be used when cookies has been
disabled on the client user browser. The JEE8 platform includes the API tools to handle Sessions.
3. Security is a major concern when using Sessions [OWASP Security Testing Guide](https://owasp.org/www-project-web-security-testing-guide/latest/4-Web_Application_Security_Testing/06-Session_Management_Testing/01-Testing_for_Session_Management_Schema) and as such probably needs a whole separate course [Session Hijacking](https://owasp.org/www-community/attacks/Session_hijacking_attack)  
[All forms of Attacks](https://owasp.org/www-community/attacks/)
4. The best way to secure your session in Tomcat 9 is with SSL [SSL/TLS Configuration How-To](https://tomcat.apache.org/tomcat-9.0-doc/ssl-howto.html)



#### 3. How to store data in a session - this is where we start adding Session data to our charity-registration
web application example
 
1. Ensure we have the <jsp-config> tag, the base.jspf file and the re-direct in our index.jsp landing page 

2. We configure our session in the web.xml as in the following example:  [Oracle Weblogic documentation](https://docs.oracle.com/cd/E24329_01/web.1211/e21049/web_xml.htm#WBAPP510)
		
		<session-config>
		 <!-- Time before an inactive session is invalidated -->
        <session-timeout>30</session-timeout>
        <!-- When using tracking-mode of cookie -->
        <cookie-config>
            <!-- Custom name of the Session --> 
            <name>JSESSIONID</name>
            <domain>nicordesigns.com</domain>
            <path>/registrations</path>
            <!-- Adds a comment to a cookie -->
            <comment>This is a comment</comment>
            <http-only>true</http-only>
            <secure>false</secure>
            <!-- Time a cookie will be persisted on the client browser-->
            <max-age>1800</max-age>
        </cookie-config>
        <!-- Specifies how server will implement the Session URL, COOKIE, SSL and order -->
        <tracking-mode>COOKIE</tracking-mode>
    	</session-config>

here the tags are optional but the order is required, and also not all this can also be done programmatically as well.
Our defined session configuration in the charity-registration app will be a watered down version of this example

3. Storing and Retrieving Data

     	

#### 4. Making sessions useful
#### 5. How to cluster an application that uses sessions 

#### 1. We need a way to identify a unique user

#### 2. HTTP is a stateless network protocol

#### 3. HTTPSession is a way to maintain state between requests - shopping carts 

#### 4. A login user/password form usually authenticates a User and allows us to associate the users database profile

#### 5. We also associate specific work-flows with Users - registering Charities etc

Check in the end Git branch of this slide show 

##### [Maintaining State Using Sessions Finish Branch](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-session-management-finish)

    

