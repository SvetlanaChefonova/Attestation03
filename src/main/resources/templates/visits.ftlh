<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Записи к врачу</title>
</head>
<body>

<table>
    <tr>
        <th>Идентификатор</th>
        <th>Дата и время записи</th>
        <th>Пациент</th>
        <th>Доктор</th>
        <th>Больница</th>

    </tr>
    <#list visitsList as visits>
        <tr>
            <td>${visits.id}</td>
            <td>${visits.dataTimeOfTheVisit}</td>
            <td>${visits.patients}</td>
            <td>${visits.doctors}</td>
            <td>${visits.hospitals}</td>

        </tr>
    </#list>
</table>
</body>
</html>