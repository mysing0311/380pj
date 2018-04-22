<!DOCTYPE html>
<html>
    <head>
        <title>Online Bidding</title>
    </head>
    <body>
    <c:url var="logoutUrl" value="/logout"/>
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h2>Bidding Items</h2>
    <security:authorize access="hasRole('ADMIN')">    
        <a href="<c:url value="/user" />">Manage User Accounts</a><br /><br />
    </security:authorize>
    <a href="<c:url value="/item/create" />">Create an Item</a><br /><br />

    <c:choose>
        <c:when test="${fn:length(ticketDatabase) == 0}">
            <i>There are no tickets in the system.</i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${itemDatabase}" var="item">
                Ticket ${item.id}:
                <a href="<c:url value="/ticket/view/${item.id}" />">
                   <c:out value="${item.subject}" /></a>
                (customer: <c:out value="${item.customerName}" />)
                <security:authorize access="hasRole('ADMIN') or
                                    principal.username=='${item.customerName}'">
                    [<a href="<c:url value="/item/edit/${item.id}" />">Edit</a>]
                </security:authorize>
                <security:authorize access="hasRole('ADMIN')">
                    [<a href="<c:url value="/item/delete/${item.id}" />">Delete</a>]
                </security:authorize>
                <br /><br />
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
