**Генерация рандомных пользователей**

Программа генерирует рандомное количество пользователей (от 1 до 29).
Данные беруться из файлов папки Resource
Полученные пользователи записываются в xls файл с рандомным именем,
путь до файла будет выведен в консоль.

**Update lecture 5** 
Сначала программа пытается брать пользователей из api `https://randus.org/api.php`
и записывать их в БД, если сеть недоступна берет из БД.
При проблемах с БД из файлов.
БД MySql настройки в классе `fintechQA.db.DBService.getMysqlConnection()`

Структурура БД
`Persons <-->> Address`

` address (
    id int auto_increment not null,
    postcode varchar(256),
    country varchar(256),
    region varchar(256),
    city varchar(256),
    street varchar(256),
    house int,
    flat int,
    primary key (id) 
)`

`persons (
    id int auto_increment not null,
    surname varchar(256),
    name varchar(256),
    middlename varchar(256),
    birthday date,
    gender varchar(1),
    inn varchar(12),
    address_id int not null,
    foreign key (address_id) references address(id),
    primary key (id) 
)`



**Update lecture 4** 
Сначала программа пытается брать пользователей из api `https://randus.org/api.php`
Но часть полей береться из файлов:
`Страна - Россия; Инн; Регион`

_Запуск программы:_

Необоходим jdk 1.8+ (https://www.oracle.com/technetwork/java/javase/downloads/)
 и maven (https://maven.apache.org/install.html)
 
 1) Скачайте проект
 2) В командной строке перейдите в папку с проектом
 3) `mvn clean compile assembly:single`
 4) После этого в папке `target` должен появиться архив `ft_lecture4-1.0-SNAPSHOT-jar-with-dependencies.jar`
 5) Для генерации файла выполните команду в папке с архивом
 `java -jar ft_lecture4-1.0-SNAPSHOT-jar-with-dependencies.jar`
 
 
