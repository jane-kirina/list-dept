### **Что было использовано**

Intellij IDEA, JDK 1.8, Maven, Tomcat 8.5.61

Junit, HTML, CSS, JavaScript, Postgresql, HikariCP, Servlet/JSP/JSTL

### **Как собрать проект**

Файл с настройками для соединения с базой данных: [hikari.properties](src/main/resources/hikari.properties)
   
В resources есть скрипт для создания базы данных с таблицами: [schema.sql](src/main/resources/schema.sql)

[Тесты](src/test/java). Процент покрытия: #

При запуске открывается страница со списком департаментов с функционалом для этого списка. 
Возле каждого департамента есть кнопка для перехода на другую страницу со списком сотрудников.

### **Условие тестового задание с комментариями, как было реализовано и почему таким образом**


    Есть сотрудники и департаменты.
    У департамента может быть много сотрудников. А может и не быть.

Реализовано через OneToMany с необязательной связью, с таблицами employee, dept.
Сотрудник работает в департаменте, каждый сотрудник существует/работает только в департаменте. 
Департамент может существовать без сотрудников. Существование сотрудников в департаменте не обязательно.

    Есть список департаментов. И есть кнопки "Добавить / Редактировать / Удалить / Список сотрудников".

На сайте, у таблицы департаментов есть столбец с кнопками "Редактировать / Удалить / Список сотрудников" для каждого отдельного департамента.
В заголовке столбца есть кнопка добавления департамента.

    При нажатии "Список" показываются сотрудники этого департамента с теми же кнопками.

Реализовано так же, как и у списка департаментов. Перед таблицей можно найти ссылку на главную страницу - список департамента.

    Список - табличка, страница добавления/редактирования - набор текстфилдов.

Список реализован через таблицу, в коде использован LinkedHashSet. 
У Department и Employee есть поля, которые уникальны на уровне БД(ключевое слово UNIQUE, id у каждой таблице), 
повторы невозможны поэтому используем Set вместо List.
Используем LinkedHashSet, который поддерживает порядок вставки элементов и имеет быструю скорость/производительность.

Добавление/редактирование реализованно через формы и инпут.

        Технологии:
        1. БД -jdbc

Использован только JDBC для взаимодействия с БД. Реализованы паттерны DAO, DAO Mapper/Decorator(для избежания повторяюего кода).
Для создания пула потоков был использован HikariCP. SQL - Postgresql.

        2. Controller – servlet

_В ПРОЦЕССЕ РЕАЛИЗАЦИИ_

Использован один общий сервлет, для соответствия паттерна Model-View-Controller. 
Также реализован шаблон command, в котором реализованы все комманды/взаимодействия с сервисом.
Каждая комманда реализует интерфейс [ICommand](src/main/java/com/example/controller/ICommand.java).

    3. View – jsp+el+jstl

_В ПРОЦЕССЕ РЕАЛИЗАЦИИ_

Страницы сделаны на jsp с jstl, также добавлены минималистичный css для удобства. 
Есть пару скриптов [здесь](src/main/webapp/script) для предупреждения перед удалением данных с таблиц.

    4. Валидация данных.
 
_В ПРОЦЕССЕ РЕАЛИЗАЦИИ_

    5. Уникальность имени у департамента и мыла у пользователя.

Данные поля уникальны, на уровне БД(ключевое слово UNIQUE), нет возможности добавить или изменить 
у имеющей сущности данные поля, при попытки добавить существующие именя/почты возникает предупреждение(ошибка) на страницы.

    6. У сотрудника обязательно одно поле - числовое, одно — дата.

Числовое поле - сколько лет работает человек в департаменте, дата - день рождения.

    7. Данные после валидации пропадать не должны, даже если они введены неправильно.

_В ПРОЦЕССЕ РЕАЛИЗАЦИИ_


