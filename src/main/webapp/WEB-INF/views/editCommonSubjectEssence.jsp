<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Общие темы</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">


$(document).ready(function() {

	 $('#csLang' ).change(function() {
	  var item = $(this).find('option:selected').val()
	  
	  if(item == 0) {
		  $('#csPid').html('<option value="0">--- Select ---</option>');
	  } else {

	  
	  $.ajax({		 
		   url:"http://localhost:8080/app/getListCommonSubjectsAjax/"+item,
		   type: "GET",		
		   success: function(list) {
				//var options = "";
				var options = '<option value="0">--- Select ---</option>';
				$.each(list,function(key, value){
				   options += '<option value="'+key+'">'+value+'</option>';
				   if(console) {
				   		console.log("lang value="+key);
				   }	
				});
				$('#csPid').html(options);
		 
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
    <form:form  modelAttribute="commonsubjectessence" method="POST" action="/app/saveCommonSubjectEssence" >
   <table>
				       
    <tr>
        <td><form:label path="csIdCommonSubj">csIdCommonSubj</form:label></td>
        <td><form:input path="csIdCommonSubj" /></td>
    </tr>
    

    <tr>
        <td><form:label path="csNameCommonSubject">csNameCommonSubject</form:label></td>
        <td><form:input path="csNameCommonSubject" /></td>
    </tr>
   
    <tr>
        <td><form:label path="csLang">csLang</form:label></td>
        <td><form:select path="csLang">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${langList}" />
				       </form:select></td>
    </tr>
    
    
   
    <tr>
        <td><form:label path="csPid">csPid"</form:label></td>
        <td><form:select path="csPid">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${pidcommonsubjects}" />
				       </form:select></td>
		
    </tr> 
    <tr>
        <td><form:label path="csiId">csiId</form:label></td>
        <td><form:select path="csiId">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${commonsubjectitemsgroup}" />
				       </form:select></td>

    </tr>
    
    <tr>
        <td><form:label path="csiIdUser">csiIdUser</form:label></td>
        <td><form:input path="csiIdUser" /></td>

    </tr>
    
      <tr>
        <td><form:label path="csiPid">csiPid</form:label></td>
        <td><form:input path="csiPid" /></td>

    </tr>
      <tr>
        <td><form:label path="bcsId">bcsId </form:label></td>
        <td><form:input path="bcsId" /></td>

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


