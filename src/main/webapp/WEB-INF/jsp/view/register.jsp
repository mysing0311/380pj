<!DOCTYPE html>
<html>
<head>
    <title>Online Bidding</title>
</head>
<body>

<h2>Registration</h2>
<form:form method="POST" enctype="multipart/form-data"
           modelAttribute="itemUser">
    <form:label path="username">Username</form:label><br/>
    <form:input type="text" path="username" /><br/><br/>
    
    <form:label path="password">Password</form:label><br/>
    <form:input type="text" path="password" /><br/><br/>
    
    <form:label path="checkpw">Confirm Password</form:label><br/>
    <form:input type="text" path="checkpw" /><br/><br/> 
    
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>