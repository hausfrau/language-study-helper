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
        function doAjaxDelete(id) {
        
       	
        	
        $.ajax({
        	 url: "deleteUserPath/"+id,
      		 success: function(response){
      			alert(response);
      			location.reload();

       },
        error: function(e){
        alert('Error: ' + e);

        }
        });
        
        
        }
        
        
        function deleteItem() {
        	item = $('input[type=radio]:checked').val();
        	if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
        	window.location.href = "http://localhost:8080/app/deleteLang/"+item;
        }
        
   		function editItem() {
   			item = $('input[type=radio]:checked').val();
   			if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
   			window.location.href = "http://localhost:8080/app/editLang/"+item;
        }
        
        </script>





</head>
    <body >
    
 
     <%@ include file="menu.jsp" %>
     <br>
    
    <h2>Список языков</h2>
    <a href="#" onclick="deleteItem()">Удалить</a>&nbsp;<a href="#" onclick="editItem()">Редактировать</a>
        <ul>
            <c:forEach items="${langs}" var="lang">

                <li>
                <input type="radio" name="item" value="<c:out value="${lang.idLang}" />" />               
                IdLang : <c:out value="${lang.idLang}" />; LangName : <c:out value="${lang.langName}" />; </li>

            </c:forEach>

        </ul>
        
      

    </body>

</html>
