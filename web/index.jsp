<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo Subir Archivo</title>
    </head>
    <body>

    <h1>Demo Subir Archivo</h1>
    
     <form method="POST" enctype="multipart/form-data" action="<%= request.getContextPath()%>/Upload">
        Por favor, seleccione el trayecto del fichero a cargar
        <br><input type="file" name="fichero">
        <input type="submit">
    </form>
    
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
