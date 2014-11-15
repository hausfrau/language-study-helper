<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Типы текста</title>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Редактировать тип текста</h2>
    <br>
    <form:form  modelAttribute="texttype" method="POST" action="/app/saveTextType" >
   <table>
   
    <tr>
        <td><form:label path="idTextType">idTextType</form:label></td>
        <td><form:input path="idTextType" /></td>
    </tr>
    

    <tr>
        <td><form:label path="textTypeName">textTypeName</form:label></td>
        <td><form:input path="textTypeName" /></td>
    </tr>
    <inpt type="test">
    <tr>
        <td colspan="2">
            <input type="submit" value="Сохранить"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>


