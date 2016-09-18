# TerminalApp
[![Build Status](https://travis-ci.org/aleksandrbogomolov/TerminalApp.svg?branch=master)](https://travis-ci.org/aleksandrbogomolov/TerminalApp)

Консольное приложение на java, с использованием maven.

Приложение выводит на экран приветственное сообщение, в зависимости от текущего времени суток.

Good morning, World! в 06:00 - 09:00

Good day, World! в 09:00 - 19:00

Good evening, World! в 19:00 - 23:00

Good night, World! в 23:00 - 06:00

Код содержит юнит-тесты и создает читабельный лог файл, вывод лога в консоль отключен.

Выводящиеся на консоль сообщения получены из message resource и зависят от системной локали пользователя. 

Приложение содержит две локали, английский и русский язык.	

Для запуска приложения небходимо склонировать [репозиторий](https://github.com/aleksandrbogomolov/TerminalApp.git)

Перейти в папку приложения и выполнить в терминале команды **mvn package** 

и **java -jar target/terminalapp-0.0.1-SNAPSHOT.jar**

или воспользоваться IDE.
