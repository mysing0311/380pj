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

        <h2>Item #${item.id}</h2>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="itemForm">   
            <form:label path="itemName">Item Name:</form:label><br/>
            <form:input type="text" path="itemName" /><br/><br/>
            
            <form:label path="descript">Description:</form:label><br/>
            <form:textarea path="body" rows="5" cols="30" /><br/><br/>
            
            <form:label path="price">Expected Price:</form:label><br/>
            <form:input type="text" path="price" /><br/><br/>
            
            <c:if test="${fn:length(item.photos) > 0}">
                <b>Photos:</b><br/>
                <ul>
                    <c:forEach items="${item.photos}" var="photo">
                        <li>
                            <c:out value="${photo.name}" />
                            [<a href="<c:url 
                                    value="/item/${item.id}/delete/${photo.name}"
                                    />">Delete</a>]
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
                                    
            <b>Add photos</b><br />
            <input type="file" name="photos" multiple="multiple"/><br/><br/>
            <input type="submit" value="Save"/><br/><br/>
        </form:form>
        <a href="<c:url value="/item" />">Return to list items</a>
    </body>
</html>