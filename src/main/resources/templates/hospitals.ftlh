<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Больницы</title>
</head>
<body>

<table>
    <tr>
        <th>Идентификатор</th>
        <th>Название больницы</th>
        <th>Адрес больницы</th>
        <th>Телефон больницы</th>

    </tr>
    <#list hospitalsList as hospitals>
        <tr>
            <td>${hospitals.id}</td>
            <td>${hospitals.hospitalName}</td>
            <td>${hospitals.hospitalAddress}</td>
            <td>${hospitals.hospitalPhone}</td>

        </tr>
    </#list>
</table>
</body>
</html>