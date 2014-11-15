<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Тест по теме</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">
var idquestion=0;
var idrightanswer=0;
var pathMp3="";

$(document).ready(function() {

	 $('#questlang' ).change(function() {
	  var item = $(this).find('option:selected').val();
	  console.log("тест сменили язык lang item= "+item);

	  if(item == 0) {
		  $('#idsubjectt').html('<option value="0">--- Select ---</option>');
	  } else {
	  
	  
	  $.ajax({		 
		   url:"http://localhost:8080/app/getListTranslatesAjax/"+item,
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
	  }

	}); 

	  
 

});

function soundClick() {
	  var audio;
	  if(pathMp3!=null) {
		$('p.mp3Name').text("Кликни по этому текст"); 
	  	audio = new Audio();
	  	audio.src = pathMp3;<!--'resources/mp3/30.mp3';--> 
	  	
	  	console.log("pathMp3="+pathMp3);
	  	audio.autoplay = true;
	  } else {
		 $('p.mp3Name').text("нет озвучки"); 
	  }	
	}

        function show() {
            var idlang = $('#answerlang').find('option:selected').val();
            console.log("idlang = "+idlang);
        	var question = $('#question').val();
        	var answer = $('#answer').val();
        	var rightanswer = $('#rightanswer').val();
        	var iditem = getItemsTIdItemsTByLocaleTranslateIdTranslate(idquestion);
        	
      	  $.ajax({		 
   		   url:"http://localhost:8080/app/getAnswerLocaleTranslateByIditemOfTranslatesT/"+"?iditem="+iditem+"&idlang="+idlang,
   		   type: "GET",	
			   success: function(localetranslate) {
				   console.log("вызвали localhost:8080/app/getAnswerLocaleTranslateByIditemOfTranslatesT "+localetranslate);
				   rightanswer = localetranslate.text;	
				   $('#rightanswer').val(rightanswer);
					answer = $('#answer').val();  
		        	if(rightanswer!=answer) {
		        		console.log("rightanswer = "+rightanswer+" answer ="+answer+" не равны");
		          		$("#lab").text(" не равны");
		        		
		        	} else {
		        		$("#lab").text("");
		        	}
			   }	
   		   
			      });	 

        }
 //       
function getQuestion() {
	$('p.mp3Name').text("Кликни по этому текст");
    var item = $('#idsubjectt').find('option:selected').val();	
    var child = $('.js_childsincl:checked').length;
    var ids;
 
    if(child == 1) {
    	ids = getStringFromGetListChildsIdSubjectTByParentIDSubjectT(item);
    	
    } else {
    	ids = item;
    }
    console.log("test getQuestion item = "+item+" child = "+child+" ids = "+ids);  
    getRandomLocaleTranslateByIdSubjectT(ids);

}
 function getRandomLocaleTranslateByIdSubjectT(ids) {
	 
		$.ajax({		 
			   url:"http://localhost:8080/app/getRandomLocaleTranslateByIdSubjectT/"+ids,
			   type: "GET",		
			   success: function(localetranslate) {
				   console.log("вызвали localhost:8080/app/getRandomLocaleTranslateByIdSubjectT "+localetranslate);
					idquestion = localetranslate.idTranslate;
					$('#question').val(localetranslate.text);
					pathMp3 = localetranslate.pathMp3;
			        }		 
			      });
 }
 
 function getStringFromGetListChildsIdSubjectTByParentIDSubjectT(item) {

	var r =  $.ajax({		 
		   url:"http://localhost:8080/app/getStringFromGetListChildsIdSubjectTByParentIDSubjectT/"+item,
		   type: "GET",	
		   global: false,
		    async:false,
		   success: function(result) {
			//	console.log(result);
				return result;
		   }
  	 }).responseText;
	return r;
 }

 
 function getItemsTIdItemsTByLocaleTranslateIdTranslate(id) {

		var r =  $.ajax({		 
			   url:"http://localhost:8080/app/getItemsTIdItemsTByLocaleTranslateIdTranslate/"+id,
			   type: "GET",	
			   global: false,
			    async:false,
			   success: function(result) {
				//	console.log(result);
					return result;
			   }
	  	 }).responseText;
		return r;
	 }
</script>
</head>
<body>
    <%@ include file="menu.jsp" %>
    <br>
    <h2>Тест по теме</h2>
    <br>
    <form:form  modelAttribute="newtest" method="POST" action="/app/saveTest" >
    <p class= "mp3Name" onclick="soundClick()">Кликни по этому тексту</p>
   <table>
      
    <tr>
        <td><form:label path="questlang">questlang</form:label></td>
        <td><form:select path="questlang">
        <form:option value="0" label="--- Select ---" />
  		    <form:options items="${langList}" />
			</form:select>
		</td>
				       
				       
		<td><form:label path="answerlang">answerlang</form:label></td>
        <td><form:select path="answerlang">
        <form:option value="0" label="--- Select ---" />
       	    <form:options items="${langList}" />
			</form:select>
		</td>		       
    </tr>  
    <tr>
    	<td><form:label path="idsubjectt">idsubjectt</form:label></td>
        <td><form:select path="idsubjectt">
       	    <form:options items="${subjectst}" />
			</form:select>
		</td>
		<td colspan="2">
		<input class="js_childsincl" type="checkbox" name="childsincl" value="childsincl">Включать подтемы выбранной темы
		</td>
    </tr>
    <tr>
    <input type="button" value="ok" onclick="getQuestion()">
    </tr>
    <tr>
        <td colspan="2"><textarea id="question" rows="4" cols="50"> </textarea></td>
        <td colspan="2"><textarea id="answer" rows="4" cols="50"></textarea></td>
        <td><label id="lab" for="answer" style="color:red"></label></td>
    </tr>
    <tr>
    <td colspan="2">
	   <input type="button" value="Показать правильный ответ" onclick="show()">
    </td>
        <td colspan="2"><textarea id="rightanswer" rows="4" cols="50"></textarea></td>  
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


