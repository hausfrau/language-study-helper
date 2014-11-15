<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

<title>Список всех переводов фраз по теме (сущности)</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">
      
        
        function deleteItem() {
        	item = $('input[type=radio]:checked').val();
        	if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
        	window.location.href = "http://localhost:8080/app/deleteTranslateEssence/"+item;
        }
        
   		function editItem() {
   			item = $('input[type=radio]:checked').val();
   			if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
   			window.location.href = "http://localhost:8080/app/editTranslateEssence/"+item;
        }
        
        </script>





</head>
    <body >
    
 
     <%@ include file="menu.jsp" %>
     <br>
    
    <h2>Список переводов фраз</h2>
    <a href="#" onclick="deleteItem()">Удалить</a>&nbsp;<a href="#" onclick="editItem()">Редактировать</a>
              <!--   <table border="1">
                <tr> -->
<table border="1">
   <c:forEach items="${translateessences}" var="translateessence">
   						
                        <tr>
                         <c:forEach var ="words" items = "${translateessence}">
                        
                                <font color="#000080"><td>
                                <input type="radio" name="item" value="<c:out value="${words.ttIdTranslatesT}" />" /> 
                                ${words.ltText}</td></font>
                        
                        </c:forEach> 
                        </tr>
                                        </c:forEach>
</table>
    </body>

</html>
