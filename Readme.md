Добрый день.
Заранее приношу извинения за отсутствие в большинстве случаев обработки Exception'ов,
многое захардкожено и т.д.

Проект доступен в готовом настроенном виде по адресу
http://
В проекте не использовал JavaScript, т.к. нет необходимости особой.
Пишу на JavaScript, React, Angular
Пример написанного мной сайта на React
http://www.techno-liga74.ru
(REST API, PostgREST, PostgreSQL, React) + настроука SSL, всего на сервере, CORS (Cross-Origin Resource Sharing) и т.д. 
Могу предоставить исходники

1. Приложение написано на Java (Spring Boot)
2. БД - PostgreSQL
3. Доступ к данным осуществляется посредством Spring Data (по технологии Java Persistence Architecture)
4. Инпорт данных - файл в формате JSON (пример файла прилагается)
5. Импорт данных посредством REST API MOEX
6. Экспорт данных в формате JSON (REST API)

Кнопки на NavBar'е

Data
Главная страница приложение отражает текущие записи БД.

Import
Импорт файла JSON с данными, пример файла прилагается в исходниках (data.json) или по ссылке
http://

from MOEX
Пример запроса на импорт данных из базы MOEX, (дата 2020-08-10 захардкожена).
Данные получаются посредством http-запроса вида
http://iss.moex.com/iss/history/engines/stock/markets/shares/boards/tqbr/securities.json?date=" + date + "&iss.meta=off&lang=RU&history.columns=SECID,SHORTNAME,TRADEDATE,NUMTRADES,OPEN,CLOSE&iss.json=extended

New
Создание новой бумаги. Проверка поля name на соответствование требованиям средствами html (pattern)

Truncate
Быстрая очистка таблицы данных

Export
Вывод двнных в формате JSON

API приложения (пример использования):

/
главная страница с данными

/sort={sortOrder}
/sort=open
Пример сортировки по полю. sortOrder - поле, по которому сортируем

/date={dateFilter}
/date=2020-08-10
Пример фильтрации по полю tradedate

/help
Эта страница, доступная в браузере

/securities/{date}
/securities/2020-08-10
Пример загрузки данных посредством http-запроса к MOEX

/new
Создание новой бумаги (страница)

/papers
Данные таблицы в формате JSON

/papers/{id}
/papers/1
Данные бумаги по id (RegNumber)

/papers/truncate
Очистка таблица БД

/papers/delete/{id}
/papers/delete/1
Удаление бумаги по id (RegNumber)

/papers/add/{secid}/{name}/{emitent_title}/{tradedate}/{numtrades}/{open}/{close}
/papers/add/DIOD/ЗаводДИОД/ЗаводДИОД/2020-08-10/718/6.95/7.46
Создание бумаги через API

/import
Загрузка бумаги из файла (страница)

_____________________________________
Немного запутался в задании, таблицу history не использовал, если нужно,
могу ответить на вопросы по FOREIGN CONSTRAINT или OneToMany (JPA)
