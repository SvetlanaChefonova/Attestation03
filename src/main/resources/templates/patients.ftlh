<!doctype html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
      <meta name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Пациенты</title>
</head>
<body>

    <table>
        <tr>
            <th>Идентификатор</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
            <th>Номер телефона</th>
            <th>Место работы</th>
            <th>Домашний адрес</th>
            <th>Электронная почта</th>
            <th>Номер полиса</th>
            <th>Страховая компания</th>
            <th>Soft flag</th>
        </tr>
        <#list patientsList as patients>
            <tr>
                <td>${patients.id}</td>
                <td>${patients.lastName}</td>
                <td>${patients.name}</td>
                <td>${patients.patronymic}</td>
                <td>${patients.dateOfBirthday}</td>
                <td>${patients.phoneNumber}</td>
                <td>${patients.placeOfWork}</td>
                <td>${patients.homeAddress}</td>
                <td>${patients.email}</td>
                <td>${patients.policyNumber}</td>
                <td>${patients.insuranceCompany}</td>
                <td>
                    <#if patients.hasDeleted>
                        true
                        <#else>
                        false
                    </#if>
                <td>

            </tr>
        </#list>
    </table>

</body>
</html>