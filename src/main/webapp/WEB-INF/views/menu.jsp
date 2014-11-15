<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>

<!-- <script src="resources/js/jquery.flash.js">
</script>-->


<script type='text/javascript'>
/*$(document).ready(function(){
	
	$('.mp3').flash(
        { src: 'resources/js/singlemp3player.swf', height: 20, width: 100 },
        { version: 7 },
        function(htmlOptions) {
            $this = $(this);
            htmlOptions.flashvars.file = $this.attr('href');
            $this.before($.fn.flash.transform(htmlOptions));
            
        }
    ); 
     
     
});*/

//function changeMp3Target(mp3){
	//$('a.mp3').attr('href', mp3);
//}
</script>
</head>
<body>
<table>
<tr>



<td>
Пользователь
</td>

<td>
Группа
</td>

<td>
Языки
</td>

<td>
Типы текста
</td>

<td>
Общие темы
</td>

<td>
Общие темы переводы
</td>

<td>
Все имеющиеся переводы
</td>

<td>
Переводы по теме и тест
</td>

</tr>

<tr>
<td>
<a href="/app/listUser">Список пользователей</a><br>
<a href="/app/createUser">Создать пользователя</a>
</td>

<td>
<a href="/app/listUser">Список групп</a><br>
<a href="/app/createUser">Создать Группу</a>

</td>

<td>
<a href="/app/listLang">Список языков</a><br>
<a href="/app/createLang">Создать язык</a>

</td>

<td>
<a href="/app/listTextType">Список типов текста</a><br>
<a href="/app/createTextType">Создать тип текста</a>

</td>

<td>
<a href="/app/listCommonSubject">Список общих тем</a><br>
<a href="/app/createCommonSubject">Создать общую тему</a>

</td>

<td>
<a href="/app/listCommonSubjectEssence">Таблица общих тем</a><br>
<a href="/app/createCommonSubjectEssence">Создать общую тему с сущностью</a>
</td>

<td>
<a href="/app/listTranslateEssence">Таблица переводов</a><br>
<a href="/app/createTranslateEssence">Создать перевод</a>
</td>

<td>
<a href="/app/showTranslatesBySubjectItem">Список всех переводов по теме</a><br>
<a href="/app/testTranslateBySubjectT">Тест по теме</a><br>
<a href="/app/testAudioTranslateBySubjectT">Аудио тест по теме</a><br>
<a href="/app/uploadAudioFile">Загрузить файл</a><br>
</td>

</tr>
</table>
<!-- <li><a class="mp3" id="mp3" href="resources/mp3/30.mp3">sound.mp3</a></li>-->

</body>
</html>