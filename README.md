# Private_Key_Generator_Test

Приложение, которое генерирорует приватные ключи для пользователей по алгоритм описанному здесь:
https://github.com/bitcoin/bips/blob/master/bip-0032.mediawiki

Приложение принимает GET-запрос, в котором должно быть переданы:
- master private key (Hexadecimal string)
- chain code (текстовая строка данных)

Возвращает: полученный приватный ключ.

Что бы запустить исполнительный PrivateKeyGenerator-1.0.jar файл(/target) нужно ввести в командной строке  
java -jar PrivateKeyGenerator-1.0.jar

Запуститься сервер на http://localhost:8080/ 

Сгенерировать новый приватный ключ можно с помочью команды: /generatePrivateKey, к которой следует указать 2 обязательных аргументра
pass и chain, которые в свою очередь обозначают master private key и chain code.

В случае, если аргументы не будут указаны, команда исполниться со стандартными значениями переменных 
(pass=b025710dc8338be9bbe9d10d5591d19f658b19d915004667f2ccbc5c40c4f35a, chain=4dde8414-bbfd-4e2c-bc25-019d3243f775)

Пример комадны: 
http://localhost:8080/generatePrivateKey?pass=b025710dc8338be9bbe9d10d5591d19f658b19d915004667f2ccbc5c40c4f35a&chain=4dde8414-bbfd-4e2c-bc25-019d3243f775
