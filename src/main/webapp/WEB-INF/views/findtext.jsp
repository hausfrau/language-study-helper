<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Поиск фразы в БД</title>
</head>

<body>
	<%@ include file="menu.jsp"%>
	
	<br>
	<h2>Поиск слова/фразы</h2>
	<br>
	
	<form:form modelAttribute="translateessence" method="POST"
		action="/app/saveTranslateEssence">
		<table>
      <tr>
        <td><form:label path="ltPlurEnds">Слово/фраза</form:label></td>
        <td><form:input path="ltPlurEnds" /></td>
    </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Сохранить" /></td>
			</tr>
		</table>
	</form:form>

	<!--select lt.idtranslate ltidtranslate, lt.text, concat('(',l.lang_name,')'), st.idsubject_t, st.subject_name 
from words.locale_translate lt, `words`.`subject_t` st, `words`.`bindtranslatesubject`  bts, words.lang l
where upper(lt.text) like '%СЕМЬЯ%'
  and lt.idtranslate = bts.idtranslate
  and st.idsubject_t = bts.idsubjectt
  and lt.idlang = l.idlang;-->

</body>
</html>