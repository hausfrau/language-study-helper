<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

<title>Список всех общих тем</title>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<script type="text/javascript">
      
        
        function deleteItem() {
        	item = $('input[type=radio]:checked').val();
        	if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
        	window.location.href = "http://localhost:8080/app/deleteCommonSubjectEssence/"+item;
        }
        
   		function editItem() {
   			item = $('input[type=radio]:checked').val();
   			if(item=='undefined') {
        		alert("Не выбрано");
        		return false;
        		
        	}
   			window.location.href = "http://localhost:8080/app/editCommonSubjectEssence/"+item;
        }
        
        </script>





</head>
    <body >
    
 
     <%@ include file="menu.jsp" %>
     <br>
    
    <h2>Список общих тем</h2>
    <a href="#" onclick="deleteItem()">Удалить</a>&nbsp;<a href="#" onclick="editItem()">Редактировать</a>
              <!--   <table border="1">
                <tr> -->
<table border="1">
   <c:forEach items="${commonsubjectsessences}" var="commonsubjectessence">
   						
                        <tr>
                         <c:forEach var ="words" items = "${commonsubjectessence}">
                        
                                <font color="#000080"><td>
                                <input type="radio" name="item" value="<c:out value="${words.bcsId}" />" /> 
                                ${words.csNameCommonSubject}</td></font>
                        
                        </c:forEach> 
                        </tr>
                                        </c:forEach>
</table>

      <%--       <c:forEach items="${commonsubjectsessences}" var="commonsubjectessence">
                <td>
                <input type="radio" name="item" value="<c:out value="${commonsubjectessence.bcsId}" />" />               
                csIdCommonSubj : <c:out value="${commonsubjectessence.csIdCommonSubj}" />; 
                csNameCommonSubject : <c:out value="${commonsubjectessence.csNameCommonSubject}" />;
                csLang : <c:out value="${commonsubjectessence.csLang}" />;
                csPid : <c:out value="${commonsubjectessence.csPid}" />;
                csiId : <c:out value="${commonsubjectessence.csiId}" />;
                csiIdUser : <c:out value="${commonsubjectessence.csiIdUser}" />;
                csiPid : <c:out value="${commonsubjectessence.csiPid}" />;
                bcsId : <c:out value="${commonsubjectessence.bcsId}" />;
                </td>
            </c:forEach>
                </tr>
        		</table> --%>
    </body>

</html>
