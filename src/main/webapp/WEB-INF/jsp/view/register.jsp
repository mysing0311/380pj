<!DOCTYPE html>
<html>
<head>
    <title>Online Bidding</title>
</head>
<body>


<h2>Registration</h2>
<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="ticketUser">
    <form:label path="username">Username</form:label><br/>
    <form:input type="text" path="username" /><br/><br/>
    <form:label path="password">Password</form:label><br/>
    <form:input type="password" path="password" /><br/><br/>
    <form:label path="roles">Roles</form:label><br/>
    <form:checkbox path="roles" value="ROLE_USER" />ROLE_USER
    <br /><br />
    <input type="submit" value="Add User"/>
</form:form>
</body>
</html>
