# Replacing embedded Java in Java Server Pages with Custom JSP Tags


We create a Custom Tag example following along with the official Oracle documentation:	

#[Understanding and Creating Custom JSP Tags](https://docs.oracle.com/cd/E60665_01/as111170/TAGLB/quickstart.htm#TAGLB118)

# JSP Custom Tags Tutorial

### 1.  Project Creation


First we create a [charity-custom-tags](charity-custom-tags) example project using the Maven Web Archetype Template 

Then we update the following in the web.xml deployment descriptor:

	 <scripting-invalid>true</scripting-invalid>
	 
this will disable the compiling of embedded Java Code in the JSPs	 
	
We expand our Maven dependencies to make use of an Open Source Apache String manipulation
package here:

		<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.12.0</version>
		    <scope>compile</scope>
		</dependency>

so we will have to add this dependency to our charity registration example.

### 2.  JSP Custom Tags

We want to be able to Format a display date in a variety of ways depending on our International User base

wherein we create the 

[formatDate](formatDate) tag in the [nicordesigns.tld](nicordesigns.tld)

then we can use it in our JSP page as follows:

	<nicordesigns:formatDate value="${entry.value.dateCreated}" type="both"                                timeStyle="short" dateStyle="medium" />

	<nicordesigns:formatDate value="${ticket.dateCreated}" type="both"                            timeStyle="long" dateStyle="full" />

### 3.  JSP Custom Tag Handler

The back-end or supporting code for our formatDate tag will be an implementation of the
`javax.servlet.jsp.tagext.TagSupport` class that override the important methods.

We override **doEndTag** to get a custom formatted date.

`TagSupport` provide methods through which we can get JspWriter object and write data to the response. We will generate the formatted string using **formatDate** and then write it to response. The final implementation is given below.

[FormatDateTag](formatDateTag)


Then we copy the [FormatDateTag](FormatDateTag) class and the [nicordesigns.tld](nicordesigns.tld) file from  our [charity-custom-tags]() project to our [charity-registration]() project.

We add another function to the TLD by first creating a new [TimeUtils](TimeUtils.java) Java utility helper class.

Then we expand the [nicordesigns.tld](nicordesigns.tld) to make use of this function.

We update the [base.jspf](base.jspf) file with the new required taglib libraries. 
  
Now we start work on our custom tag files

First [main.tag](main.tag) 

 	 




