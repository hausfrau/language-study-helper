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
        	 url: "/deleteUserPath/"+id,
      		 success: function(response){
      			 window.href.reload;

       },
        error: function(e){
        alert('Error: ' + e);

        }
        });
        
        
        }
        </script>





</head>
    <body >
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Редактировать пользователя</h2>
    <br>
    <form:form  modelAttribute="user" method="POST" action="/app/saveUser" >
   <table>
   
    <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    
 
   
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="group">Group</form:label></td>
        <td><form:input path="group" /></td>
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
