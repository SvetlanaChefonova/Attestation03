<!doctype html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport">
     content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0"
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
    -->
    <title>Записи к врачу</title>
</head>
<body>
Hello
<table>
    <tr>
        <th>Идентификатор</th>
        <th>Дата и время записи</th>
        <th>Пациент</th>
        <th>Доктор</th>
        <th>Больница</th>

    </tr>
    <#list visits as visits>
        <tr>
            <td>${visits.id}</td>
            <td>${visits.data_time_of_the_visit}</td>
            <td>${visits.patient_id}</td>
            <td>${visits.doctor_id}</td>
            <td>${visits.hospital_id}</td>

        </tr>
    </#list>
</table>
</body>
</html>