<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<title>Insert title here</title>


<script type="text/javascript">
var idquestion=0;
var idrightanswer=0;
var pathMp3="";

$(document).ready(function() {

	  
	  $.ajax({		 
		   url:"http://localhost:8080/app/ajaxGetAllLang",
		   type: "GET",		
		   success: function(list) {
			   var options = '<option value="0">--- Select ---</option>';
				$.each(list,function(key, value){
				   options += '<option value="'+key+'">'+value+'</option>';
				   if(console) {
				   		console.log("тема value="+key);
				   }	
				});
				$('#idsubjectt').html(options);
		 
		       }		 
		    });
	

 
 

});
</script>
</head>
<body>
<h2>Список языков</h2>
<table>  
    <tr>
        <td><form:label path="lang">Язык ID</form:label></td>
        <td><form:select path="lang">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${langList}" />
				       </form:select></td>
    </tr>
    </table>  
</body>
</html>