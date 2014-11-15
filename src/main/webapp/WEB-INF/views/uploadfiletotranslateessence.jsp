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
var idTranslateEssence = 0;

$(document).ready(function() {

	 $('#itIdItemsT' ).change(function() {
		 var item = $(this).find('option:selected').val();
		 if(console) {
		   		console.log("itIdItemsT item="+item);
		   }
	 });
	
	 $('#ltIdLang' ).change(function() {
	  var item = $(this).find('option:selected').val();
	  
	  if(item == 0) {
		  $('#ltIdSubjectT').html('<option value="0">--- Select ---</option>');
	  } else {

	  
	  $.ajax({		 
		   url:"http://localhost:8080/app/getListTranslatesAjax/"+item,
		   type: "GET",		
		   success: function(list) {
			   
			   if(console) {
			   		console.log("зашли в едит +item = "+item);
			   }
				//var options = "";
				var options = '<option value="0">--- Select ---</option>';
				$.each(list,function(key, value){
				   options += '<option value="'+key+'">'+value+'</option>';
				   if(console) {
				   		console.log("lang value="+key);
				   }	
				});
				$('#ltIdSubjectT').html(options);
		 
		          }		 
		      });
	  }
	}); 

	  
 

});

function saveTranslateEssenceWithoutAudio() {
   $.ajax({
    	   url: "http://localhost:8080/app/saveTranslateEssence/",
  		   success: function(response){
  			        alert(response);
  			        location.reload();
     		        },
           error: function(e){
                  alert('Error: ' + e);
                  }
   });
}

</script>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Редактировать перевод</h2>
    <br>
    <form:form commandName="firstForm" modelAttribute="translateessence" method="POST" enctype="multipart/form-data" >
   <table>
		       
      <tr>
        <td><form:label path="itIdItemsT">itIdItemsT</form:label></td>
        <td><form:select path="itIdItemsT">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${translatesgroup}" />
				       </form:select></td>

    </tr>  

    <tr>
        <td><form:label path="itIdTextType">itIdTextType</form:label></td>
        <td><form:select path="itIdTextType">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${texttypes}" />
				       </form:select></td>
    </tr>
    <tr>
        <td><form:label path="itIdUser">itIdUser</form:label></td>
        <td><form:input path="itIdUser" /></td>
    </tr>
    
        <tr>
        <td><form:label path="itIdSubjItem">itIdSubjItem</form:label></td>
                <td><form:select path="itIdSubjItem">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${subjectsgroup}" />
				       </form:select></td>
    </tr>
    
        <tr>
        <td><form:label path="ltIdTranslate">ltIdTranslate</form:label></td>
        <td><form:input path="ltIdTranslate" readonly="true" /></td>
    </tr>
    
        <tr>
        <td><form:label path="ltText">ltText</form:label></td>
        <td><form:input path="ltText" /></td>
    </tr>
    <tr>
        <td><form:label path="ltIdLang">ltIdLang</form:label></td>
        <td><form:select path="ltIdLang">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${langList}" />
				       </form:select></td>
   
        <tr>
        <td><form:label path="ltIdGender">ltIdGender</form:label></td>
        <td><form:input path="ltIdGender" /></td>
    </tr>
    
        <tr>
        <td><form:label path="ltPlurEnds">ltPlurEnds</form:label></td>
        <td><form:input path="ltPlurEnds" /></td>
    </tr>
    
        <tr>
        <td><form:label path="ltRootChanges">ltRootChanges</form:label></td>
        <td><form:input path="ltRootChanges" /></td>
    </tr>
    
            <tr>
        <td><form:label path="ltIdSubjectT">ltIdSubjectT</form:label></td>
                <td><form:select path="ltIdSubjectT">
        <form:option value="0" label="--- Select ---" />
					 					  <form:options items="${subjectst}" />
				       </form:select></td>
    </tr>
           <tr>
        <td><form:label path="ttIdTranslatesT">ttIdTranslatesT</form:label></td>
        <td><form:input path="ttIdTranslatesT" readonly="true"/></td>
    </tr>

   
   <!--  <tr>
        <td colspan="2">
            <input type="submit" value="Сохранить"/>
        </td>
    </tr>-->
</table>  
<!--</form:form>-->

   <!--  <form:form commandName="secondForm" method="post" enctype="multipart/form-data">-->
	  Прикрепить аудиофайл:<input type="file" name="myfile"/>&nbsp;
	 <!-- <button type="submit">Сохранить файл</button>-->
	</form:form>
	   <input type="button" value="Сохранить перевод" onclick="saveTranslateEssenceWithoutAudio()">
</body>
</html>


