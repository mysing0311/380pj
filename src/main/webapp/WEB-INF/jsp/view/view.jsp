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

        <h2>Item #${ticket.id}: <c:out value="${ticket.subject}" /></h2>
        <security:authorize access="hasRole('ADMIN') or principal.username=='${ticket.customerName}'">            
            [<a href="<c:url value="/ticket/edit/${ticket.id}" />">Edit</a>]
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">            
            [<a href="<c:url value="/ticket/delete/${ticket.id}" />">Delete</a>]
        </security:authorize>
        <br /><br />
        <i>Owner Name - <c:out value="${ticket.customerName}" /></i><br /><br />
        Description: <c:out value="${ticket.body}" /><br /><br />
        <c:if test="${fn:length(ticket.attachments) > 0}">
            Photos:
            <c:forEach items="${ticket.attachments}" var="attachment"
                       varStatus="status">
                <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value="/ticket/${ticket.id}/attachment/${attachment.name}" />">
                    <c:out value="${attachment.name}" /></a>
            </c:forEach><br /><br />
        </c:if>
        Price: $<c:out value="${ticket.price}" /><br /><br />
        
        No. of bids: <c:out value="${ticket.bidNum}" /><br /><br />
        
        Status: <c:out value="${ticket.status}" /><br /><br />
        
        Comment: <c:out value="${ticket.comment}" /><br /><br /> 

        <a href="<c:url value="/ticket/bid/${ticket.id}" />">Bid the item</a><br /><br /> 
        
        <a href="<c:url value="/ticket" />">Return to list items</a>
    </body>
</html>