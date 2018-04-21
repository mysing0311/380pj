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

        <h2>Item #${item.id}: <c:out value="${item.subject}" /></h2>
        <security:authorize access="hasRole('ADMIN') or principal.username=='${item.customerName}'">            
            [<a href="<c:url value="/item/edit/${item.id}" />">Edit</a>]
        </security:authorize>
        
        <security:authorize access="hasRole('ADMIN')">            
            [<a href="<c:url value="/item/delete/${item.id}" />">Delete</a>]
        </security:authorize>
        <br /><br />
        
        <i>Owner's Name - <c:out value="${item.ownerName}" /></i><br /><br />
        <c:out value="${item.body}" /><br /><br />
        
        <c:if test="${fn:length(item.attachments) > 0}">
            Attachments:
            <c:forEach items="${item.attachments}" var="attachment"
                       varStatus="status">
                <c:if test="${!status.first}">, </c:if>
                <a href="<c:url value="/item/${item.id}/attachment/${attachment.name}" />">
                    <c:out value="${attachment.name}" /></a>
            </c:forEach><br /><br />   
        </c:if>
        
        <!--
        <i>Price: $ <c:out value="${item.ownerName}" /></i><br /><br />
        <c:out value="${item.body}" /><br /><br />
        
        <i>No. of bids:  <c:out value="${item.ownerName}" /></i><br /><br />
        <c:out value="${item.bids}" /><br /><br />
        
        <i>Status: <c:out value="${item.ownerName}" /></i><br /><br />
        <c:out value="${item.status}" /><br /><br />
        
        <i>Comments:  <br />
        <c:forEach items="${item.ownerName}" var="comment">
                 <c:out value="${item.comment}" /></a>
        </c:forEach><br /><br />   
        -->
        
        <a href="<c:url value="/item" />">Return to list items</a>
    </body>
</html>