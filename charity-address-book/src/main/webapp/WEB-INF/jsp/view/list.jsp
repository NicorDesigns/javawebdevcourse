<%--@elvariable id="addresses" type="java.util.Set<com.nicordesigns.Address>"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Charity Address Book</title>
    </head>
    <body>
        <h2>Charity Address Book</h2>
        <c:choose>
            <c:when test="${fn:length(addresses) == 0}">
                <i>There are no charities in the address book.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${addresses}" var="charity">
                    <b>
                        <c:out value="${charity.lastName}, ${charity.firstName}" />
                    </b><br />
                    <c:out value="${charity.address}" /><br />
                    <c:out value="${charity.phoneNumber}" /><br />
                    <c:if test="${charity.registrationday != null}">
                        Registration day: ${charity.registrationday}<br />
                    </c:if>
                    Created: ${charity.dateCreated}<br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
