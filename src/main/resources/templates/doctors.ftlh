<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport">
     content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0"
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
    -->
    <title>Доктора</title>
</head>
<body>
Hello
<table>
    <tr>
        <th>Идентификатор</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Специализация</th>
        <th>Номер кабинета</th>
    </tr>
    <#list doctors as doctors>
        <tr>
            <td>${doctors.id}</td>
            <td>${doctors.last_name}</td>
            <td>${doctors.name}</td>
            <td>${doctors.patronimyc}</td>
            <td>${doctors.specialization}</td>
            <td>${patients.cabinet_number}</td>
        </tr>
    </#list>
</table>
<!--<p><a href="/doctor-create">Create doctor</a></p>-->
</body>
</html>