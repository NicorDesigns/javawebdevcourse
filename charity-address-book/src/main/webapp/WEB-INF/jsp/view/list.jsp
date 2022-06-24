<%--@elvariable id="addresses" type="java.util.Set<com.nicordesigns.Address>"--%>
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="title.browser" /></title>
    </head>
    <body>
        <h2><fmt:message key="title.page" /></h2>
        <c:choose>
            <c:when test="${fn:length(addresses) == 0}">
                <i><fmt:message key="message.noContacts" /></i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${addresses}" var="charity">
                    <b>
                        <c:out value="${charity.charityName}, ${charity.charityId}" />
                    </b><br />
                    <c:out value="${charity.address}" /><br />
                    <c:out value="${charity.phoneNumber}" /><br />
                    <c:if test="${charity.registrationday != null}">
                        <fmt:message key="label.registrationday" />:
                    	${charity.registrationday}<br />
                    </c:if>
                    <fmt:message key="label.creationDate" />:
                    <fmt:parseDate  value="${charity.dateCreated}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
					<fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="stdDatum" />	    
                    ${stdDatum}<br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
