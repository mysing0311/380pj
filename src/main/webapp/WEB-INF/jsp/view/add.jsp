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

        <h2>Create an Item</h2>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="ticketForm">
            <form:label path="subject">Item Name</form:label><br/>
            <form:input type="text" path="subject" /><br/><br/>
            
            <form:label path="body">Description</form:label><br/>
            <form:textarea path="body" rows="5" cols="30" /><br/><br/>
            
            <b>Photos</b><br/>
            <input type="file" name="attachments" multiple="multiple"/><br/><br/>
            
            <form:label path="price">Price</form:label><br/>
            <form:input type="text" path="price" /><br/><br/>
            
            <b>Comment</b><br/>
            <input type="text" name="comment" /><br/><br/>
            
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
