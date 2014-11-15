<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Общие темы</title>

<script type="text/javascript">


$( document ).ready(function() {

	$('#lang' ).change(function() {
	  var item = $(this).find('option:selected').val()
	  
	  if(item == 0) {
		  $('#pid').html('<option value="0">--- Select ---</option>');
		  
	  } else {

	  
	  $.ajax({		 
		   url:"http://localhost:8080/app/getListCommonSubjectsAjax/"+item,
		   type: "GET",		
		   success: function(list) {
				var options = "";
				$.each(list,function(key, value){
				   options += '<option value="'+key+'">'+value+'</option>';
				});
				$('#pid').html(options);
		 
		          }		 
		      });
	  }
	});

});



</script>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Редактировать общую тему</h2>
    <br>
    <form:form  modelAttribute="commonsubject" method="POST" action="/app/saveCommonSubject" >
   <table>
   
   

			       
				       
    <tr>
        <td><form:label path="idCommonSubj">id темы</form:label></td>
        <td><form:input path="idCommonSubj" /></td>
    </tr>
    

    <tr>
        <td><form:label path="nameCommonSubject">Название темы</form:label></td>
        <td><form:input path="nameCommonSubject" /></td>
    </tr>
   
    <tr>
        <td><form:label path="lang">Язык ID</form:label></td>
        <td><form:select path="lang">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${langList}" />
				       </form:select></td>
    </tr>
    
    <tr>
        <td><form:label path="langName">Язык</form:label></td>
        <td><form:input path="langName" /></td>

    </tr>
    
   
    <tr>
        <td><form:label path="pid">pidNameCommonSubject</form:label></td>
        <td><form:select path="pid">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${pidcommonsubjects}" />
				       </form:select></td>
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


