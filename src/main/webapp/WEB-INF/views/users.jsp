<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

<title>Список всех пользователей пользователей</title>

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
        
        
        function show() {
        	$('#area').val('');
        	$('#area').val($('option:selected').text());
        }
        </script>





</head>
    <body >
    
 
     <%@ include file="menu.jsp" %>
     <br>
    
    <h2>Список пользователей</h2>
        <ul>
            <c:forEach items="${users}" var="user">

                <li>
                <a href="editUser/<c:out value="${user.id}" />">Рудактировать</a>&nbsp;
                <a href="#" onclick="doAjaxDelete(<c:out value="${user.id}" />);">Удалить</a>&nbsp;
                Id : <c:out value="${user.id}" />; Имя : <c:out value="${user.name}" />; Группа : <c:out value="${user.groupName}"/></li>

            </c:forEach>
            
            
              <select name="user" />
					 	
					<c:forEach items="${users}" var="user">

					<option value="<c:out value="${user.id}" />"><c:out value="${user.name}" /></option>
    	           
           	 </c:forEach>
					 	
					 			
		   </select></td>
		   
		   <input type="button" value="Показать" onclick="show()">
		   <textarea id="area" rows="4" cols="50">
 
</textarea>

        </ul>
        
      

    </body>

</html>
