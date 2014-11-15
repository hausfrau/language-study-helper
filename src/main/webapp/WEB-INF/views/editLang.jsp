<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Языки</title>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Редактировать язык</h2>
    <br>
    <form:form  modelAttribute="lang" method="POST" action="/app/saveLang" >
   <table>
   
    <tr>
        <td><form:label path="idLang">idLang</form:label></td>
        <td><form:input path="idLang" /></td>
    </tr>
    

    <tr>
        <td><form:label path="langName">langName</form:label></td>
        <td><form:input path="langName" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Сохранить"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>


