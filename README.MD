**Гереция рандомных пользователей**

Программа генерирует рандомное количество пользователей (от 1 до 29).
Данные беруться из файлов папки Resource
Полученные пользователи записываются в xls файл с рандомным именем,
путь до файла будет выведен в консоль.

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
 
 
