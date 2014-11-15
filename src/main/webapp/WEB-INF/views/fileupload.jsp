<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Загрузка аудио файла</title>
</head>
<body>
<h3>
	Загрузка аудио файла  
</h3>



<br>
<p id="translateessence"></p>
	<form method="post" enctype="multipart/form-data">
	  Файл:<input type="file" name="myfile"/>&nbsp;
	  <button type="submit">Сохранить</button>
	</form>

</body>
</html>
