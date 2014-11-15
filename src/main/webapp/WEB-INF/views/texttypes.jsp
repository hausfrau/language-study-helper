<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

<title>Список всех языков</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">
    
        
        function deleteItem() {
        	item = $('input[type=radio]:checked').val();
        	if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
        	window.location.href = "http://localhost:8080/app/deleteTextType/"+item;
        }
        
   		function editItem() {
   			item = $('input[type=radio]:checked').val();
   			if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
   			window.location.href = "http://localhost:8080/app/editTextType/"+item;
        }
        
        </script>





</head>
    <body >
    
 
     <%@ include file="menu.jsp" %>
     <br>
    
    <h2>Список типов текста</h2>
    <a href="#" onclick="deleteItem()">Удалить</a>&nbsp;<a href="#" onclick="editItem()">Редактировать</a>
        <ul>
            <c:forEach items="${texttypes}" var="texttype">

                <li>
                <input type="radio" name="item" value="<c:out value="${texttype.idTextType}" />" />               
                IdTextType : <c:out value="${texttype.idTextType}" />; textTypeName : <c:out value="${texttype.textTypeName}" />; </li>

            </c:forEach>

        </ul>
        
      

    </body>

</html>
