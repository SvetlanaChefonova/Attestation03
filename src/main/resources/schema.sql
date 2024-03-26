--create table if not exists patients(id, last_name, name, patronymic, date_of_birthday, phone_number, place_of_work, home_address, email, policy_number, insurance_company);

insert into patients(id, last_name, name, patronymic, date_of_birthday, phone_number, place_of_work, home_address, email, policy_number, insurance_company, has_deleted)
values
    (1, 'Петров', 'Петр', 'Петрович', '11.11.1981', 89004455667, 'ООО Движение', 'Москва, ул. Веселая, д.4, кв.72', 'pertovichPP@mail.ru', 111222333, 'Альфа-страхование', false),
    (2, 'Семенов', 'Семен', 'Семенович', '05.01.1987', 89064655677, 'ОАО Сервис', 'Москва, ул. Липецкая, д.23, кв.89', 'semenovSS@mail.ru', 111222444, 'Альфа-страхование', false),
    (3, 'Иванов', 'Иван', 'Иванович', '09.09.1976', 89024440067, 'ООО Магнит', 'Москва, ул. Бакинская, д.10, кв.166', 'ivanovII@mail.ru', 111222555, 'СОГАЗ-Мед', false),
    (4, 'Смирнов', 'Илья', 'Петрович', '11.04.1990', 89023210067, 'ОАО АльфаБанк', 'Москва, ул. Подольских курсантов, д.7, кв.22', 'smirnovIP@mail.ru', 111200555, 'Альфа-страхование', false),
    (5, 'Дергачев', 'Александр', 'Иванович', '09.09.1976', 89024440067, 'ООО Лада', 'Москва, Ленинградское ш., д.9, кв.15', 'dergAI@mail.ru', 111222344, 'СОГАЗ-Мед', false),
    (6, 'Бучинский', 'Борис', 'Алексеевич', '09.09.1976', 89211440067, 'ФГУП ВНИИА', 'Москва, ул. Ягодная, д.10, кв.136', 'buchBA@mail.ru', 111222885, 'Макс-М', false),
    (7, 'Киржакова', 'Ксения', 'Леонидовна', '22.04.1989', 89764440067, 'ПАО Сбербанк', 'Москва, ул. Кошкина, д.8, кв.77', 'kirKL@mail.ru', 111222989, 'Макс-М', false),
    (8, 'Чефонова', 'Светлана', 'Олеговна', '09.09.1976', 89517885897, 'ПАО Сбербанк', 'Москва, Каширское ш., д.78, кв.567', 'chefonovaSO@mail.ru', 111222234, 'СОГАЗ-Мед', false);


insert into doctors(id, last_name, name, patronymic, specialization, cabinet_number)
values
    (1, 'Иванова', 'Анна', 'Григорьевна', 'Терапевт', 202),
    (2, 'Юсупова', 'Виктория', 'Николаевна', 'Кардиолог', 210),
    (3, 'Федотов', 'Марат', 'Вениаминович', 'Окулист', 303),
    (4, 'Белкин', 'Юрий', 'Степанович', 'Оториноларинголог', 312);

insert into hospitals(id, hospital_name, hospital_address, hospital_phone)
values
    (1, 'Больница №83 ФНКЦ ФМБА России', 'г.Москва, Ореховый бульвар, д. 28', 84951524758),
    (2, 'Университетская клиническая больница №4 Сеченова', 'г.Москва, ул. Доватора, д. 15/1', 84992292290),
    (3, 'Городская клиническая больница имени С.С. Юдина', 'г.Москва, Коломенский пр., 4', 84996124566),
    (4, 'Городская клиническая больница имени В.М. Буянова', 'г.Москва, Бакинская ул., 26,', 84951362268);

--create table if not exists visits(id, data_time_of_the_visit, doctor_id, hospital_id, patient_id);

insert into visits(id, data_time_of_the_visit, doctor_id, hospital_id, patient_id)
values
    (1, '02.03.2024 08:00', 1, 2, 3),
    (2, '02.03.2024 09:00', 2, 3, 1),
    (3, '03.03.2024 10:15', 3, 2, 2),
    (4, '03.03.2024 11:30', 4, 4, 4),
    (5, '04.03.2024 13:10', 3, 1, 6),
    (6, '04.03.2024 15:00', 2, 1, 5),
    (7, '05.03.2024 14:25', 1, 2, 7),
    (8, '05.03.2024 16:30', 4, 4, 8);

--insert into patients(id, last_name, name, patronymic, has_deleted) values (9, 'Patient 1', 'Patient 1', 'Patient 1', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (10, 'Patient 2', 'Patient 2', 'Patient 2', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (11, 'Patient 3', 'Patient 3', 'Patient 3', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (12, 'Patient 4', 'Patient 4', 'Patient 4', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (13, 'Patient 5', 'Patient 5', 'Patient 5', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (14, 'Patient 6', 'Patient 6', 'Patient 6', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (15, 'Patient 7', 'Patient 7', 'Patient 7', false);
--insert into patients(id, last_name, name, patronymic, has_deleted) values (16, 'Patient 8', 'Patient 8', 'Patient 8', false);