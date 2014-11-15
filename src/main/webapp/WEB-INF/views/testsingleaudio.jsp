<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Аудио тест по теме (по одному)</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">
var idquestion=0;
var idrightanswer=0;
var pathMp3="";
var pathMp3RightAnswer="";

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
	  getQuestion();
	  console.log("pathMp3="+pathMp3+", idquestion="+idquestion);
	  if(pathMp3!=null) {
		<!--$('p.mp3Name').text("Кликни по этому текст");--> 
	  	audio = new Audio();
	  	audio.src = pathMp3;<!--'resources/mp3/30.mp3';--> 
	  	audio.autoplay = true;
	  } else {
		<!-- $('p.mp3Name').text("нет озвучки"); -->
	  }	
	}
	
function audioRightAnswerOn() {
	  var audio;
	  console.log("pathMp3RightAnswer="+pathMp3RightAnswer+", idrightanswer="+idrightanswer);
	  if(pathMp3RightAnswer!=null) {
		<!--$('p.mp3Name').text("Кликни по этому текст");--> 
	  	audio = new Audio();
	  	audio.src = pathMp3RightAnswer;<!--'resources/mp3/30.mp3';--> 
	  	audio.autoplay = true;
	  } else {
		<!-- $('p.mp3Name').text("нет озвучки"); -->
	  }	
	}

        function show() {
            var idlang = $('#answerlang').find('option:selected').val();
            console.log("idlang = "+idlang);
        	<!--var question = $('#question').val();-->
        	var answer = $('#answer').val();
        	var rightanswer = $('#rightanswer').val();
        	var iditem = getItemsTIdItemsTByLocaleTranslateIdTranslate(idquestion);
        	
      	  $.ajax({		 
   		   url:"http://localhost:8080/app/getAnswerLocaleTranslateByIditemOfTranslatesT/"+"?iditem="+iditem+"&idlang="+idlang,
   		   type: "GET",	
		   global: false,
		   async:false,
			   success: function(localetranslate) {
				   console.log("вызвали localhost:8080/app/getAnswerLocaleTranslateByIditemOfTranslatesT "+localetranslate);
				   rightanswer = localetranslate.text;	
				   $('#rightanswer').val(rightanswer);
				   pathMp3RightAnswer=localetranslate.pathMp3;
					answer = $('#answer').val();  
		        	if(rightanswer!=answer) {
		        		console.log("rightanswer = "+rightanswer+" answer ="+answer+" не равны");
		          		$("#lab").text(" не равны");
		        		
		        	} else {
		        		$("#lab").text("");
		        	}
			   }	
   		   
			      });	
      	audioRightAnswerOn();

        }
 //       
function getQuestion() {
	<!--$('p.mp3Name').text("Кликни по этому текст");-->
    var item = $('#idsubjectt').find('option:selected').val();	
    var child = $('.js_childsincl:checked').length;
    var ids;
 
    if(child == 1) {
    	ids = getStringFromGetListChildsIdSubjectTByParentIDSubjectT(item);
    	
    } else {
    	ids = item;
    }
    console.log("test getQuestion item = "+item+" child = "+child+" ids = "+ids);  
    getRandomLocaleTranslateWithAudioByIdSubjectT(ids);

}
 function getRandomLocaleTranslateWithAudioByIdSubjectT(ids) {
	 
		$.ajax({		 
			   url:"http://localhost:8080/app/getRandomLocaleTranslateWithAudioByIdSubjectT/"+ids,
			   type: "GET",	
			   global: false,
			    async:false,
			   success: function(localetranslate) {
				   console.log("вызвали localhost:8080/app/getRandomLocaleTranslateWithAudioByIdSubjectT "+localetranslate);
					idquestion = localetranslate.idTranslate;
					<!--$('#question').val(localetranslate.text);-->
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
    <h2>Аудио тест по теме (одиночный)</h2>
    <br>
    <form:form  modelAttribute="newtest" method="POST" action="/app/saveTest" >
    <!--  <p class= "mp3Name" onclick="soundClick()">Кликни по этому тексту</p>-->
   <table>
      	<tr>
   			<td colspan="5"><input type="button" value="Начать тест"/></td>
   		</tr>
   		<tr>
   			<td><form:label path="questlang">Перевод с языка</form:label></td>
   			<td><form:select path="questlang">
        			<form:option value="0" label="--- Select ---" />
  		    		<form:options items="${langList}" />
				</form:select>
			</td>
			<td></td>			
   			<td><form:label path="answerlang">на язык</form:label></td>
   			<td><form:select path="answerlang">
        			<form:option value="0" label="--- Select ---" />
       	    		<form:options items="${langList}" />
				</form:select>
			</td>
   		</tr>
   		<tr>
   			<td><form:label path="idsubjectt">Тема</form:label></td>
   			<td colspan="4"><form:select path="idsubjectt">
       	    					<form:options items="${subjectst}" />
							</form:select></td>
   		</tr>
   		<tr>
   			<td colspan="5">
   				<input class="js_childsincl" type="checkbox" name="childsincl" value="childsincl">
   				Включать подразделы выбранной темы
   			</td>
   		</tr>
   		<tr><td><p><br></p></td>
   		</tr>

   		<tr>
   		   	<td colspan="3"><input  class= "mp3Name" onclick="soundClick()" type="button" value="Следующий вопрос"></td>
   		   	<!-- <p class= "mp3Name" onclick="soundClick()">Кликни по этому тексту</p>-->
   		   	
   			<td colspan="2"><input type="button" value="Показать правильный ответ" onclick="show()"></td>
   		</tr>
   		<tr><td><p><br></p></td></tr>
   		<tr>
   			<td colspan="3"><label id="labans" for="answer"></label>Ваш ответ</td>
   			<td colspan="2"><label id="labrightans" for="rightanswer">Правильный ответ</label></td>
   		</tr>
   		<tr>
   		   	<td colspan="2"><textarea id="answer" rows="4" cols="50"></textarea></td>
   		   	<td><label id="lab" for="answer" style="color:red"></label></td>
   		   	<td colspan="2"><textarea id="rightanswer" rows="4" cols="50"></textarea></td>
   			
   		</tr>
   		<tr><td><p><br></p></td></tr>
   		<tr>
   			<td colspan="5"><input type="submit" value="Завершить тест"/></td>
   		</tr>
</table>  
 File:<input type="file" name="myfile"/>
</form:form>
</body>
</html>


