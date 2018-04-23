<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Comment</title>
  </head>
  <body>
     <form:form method="POST" enctype="multipart/form-data" modelAttribute="ticketForm">
       <form:label path="comment">Comment:</form:label><br/>
            <form:textarea path="comment" rows="5" cols="30" /><br/><br/>
       <input type="submit" value="Comment"/><br /><br />
     </form:form>
    <a href="<c:url value="/ticket" />">Return to list items</a>
  </body>
</html>
