<!DOCTYPE html>
<html>
    <head>
        <title>Online Bidding</title>
    </head>
    <body>
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
                    (customer: <c:out value="${ticket.customerName}" />)
                    <br /><br />
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
