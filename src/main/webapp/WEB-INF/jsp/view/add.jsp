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
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="itemForm">
            <form:label path="itemName">Item Name:</form:label><br/>
            <form:input type="text" path="itemName" /><br/><br/>
            
            <form:label path="descript">Description:</form:label><br/>
            <form:textarea path="descript" rows="5" cols="30" /><br/><br/>
       
            <b>Photos</b><br/>
            <input type="file" name="photos" multiple="multiple"/><br/><br/>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
