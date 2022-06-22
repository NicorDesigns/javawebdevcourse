# Internationaizarion Tags
Created: 2022-06-17 14:42

	<fmt:message>
		
[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtmessage](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtmessage)

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:message](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:message)

	<fmt:setLocale value="en_US" />
	
[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#i18n-localization-context](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#i18n-localization-context)

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#preferred-locales](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#preferred-locales)

	

Resolves a localized message in a resource bundle to display it inline or saves it to a variable , the key specifies the key to resolve to display.

related to local is the Resource Bundle

	<fmt:bundle>
	
[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:bundle](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:bundle)

Explains and expands on how to use the optional bundle attribute that indicates which localization context can be used including <fmt:param>

	<fmt:setBundle>

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:setBundle](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:setBundle)


	<fmt:timeZone>

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:timeZone](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmt:timeZone)

	<fmt:setTimeZone>

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtsettimezone](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtsettimezone)

	<fmt:formatNumber>

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtformatnumber](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtformatnumber)

	<fmt:formatDate>

[https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtformatdate](https://jakarta.ee/specifications/tags/2.0/jakarta-tags-spec-2.0.html#fmtformatdate)


#### Putting Internationalization  Library Tags to Use 
### Our FMT Library Examples
Charity Address book - we expand on the Charity Address Book Sample that we introduced in our previous Core Tag Library Examples:

[https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-jstl-finish/charity-address-book](https://github.com/NicorDesigns/javawebdevcourse/tree/jee8web-jstl-finish/charity-address-book)

the we expand on our web.xml by adding the following context initialization parameter

	<context-param>
        <param-name>javax.servlet.jsp.jstl.fmt.localizationContext</param-name>
        <param-value>CharityAddressBook-messages</param-value>
    </context-param>

this helps to establish a resources bundle that will be used to store all the localized language messages    

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/index.jsp](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/index.jsp)


Our base.jspf

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/WEB-INF/jsp/base.jspf](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/WEB-INF/jsp/base.jspf)

We use the Charity Address POJO to list out the Address Book

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/java/com/nicordesigns/Address.java](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/java/com/nicordesigns/Address.java)


The ListServlet

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/java/com/nicordesigns/ListServlet.java](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/java/com/nicordesigns/ListServlet.java)

creates an in memory database of Charity Addresses

and the list.jsp

use the Core Tag Library to list out the Address Book

[https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/WEB-INF/jsp/view/list.jsp](https://github.com/NicorDesigns/javawebdevcourse/blob/jee8web-jstl-finish/charity-address-book/src/main/webapp/WEB-INF/jsp/view/list.jsp)

we will compile and run our app and have a look at

[http://localhost:8080/charity-address-book/list](http://localhost:8080/charity-address-book/list)

and

[http://localhost:8080/charity-address-book/list?empty](http://localhost:8080/charity-address-book/list?empty)





