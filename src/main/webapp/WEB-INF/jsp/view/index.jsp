<!DOCTYPE html>
<html>
    <head>
        <title>Online Bidding</title>
    </head>
    <body>
      <a href="<c:url value="/login" />">Login</a>
      <a href="<c:url value="/user/register" />">Register</a>  
       
        <h2>Items</h2>
        <c:choose>
            <c:when test="${fn:length(ticketDatabase) == 0}">
                <i>There are no items in the system.</i>
            </c:when>
            <c:otherwise>
                <c:forEach items="${ticketDatabase}" var="ticket">
                    Item ${ticket.id}:
                    <a href="<c:url value="/ticket/view/${ticket.id}" />">
                        <c:out value="${ticket.subject}" /></a>
                    (Owner: <c:out value="${ticket.customerName}" />)
                    <br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
