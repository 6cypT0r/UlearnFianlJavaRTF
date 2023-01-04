# UlearnFianlJavaRTF

## Описание: 
Итоговый проект Ulearn Java-RTF №8. 

### Ход написания программы: 
Был создан файл UlearnFinalJava.java , являющийся главным файлом. Далее были добавлены файлы Parser.java , BDCreator.java , Request.java , Program.java . Файлы BDCreator и Parser отвечают за чтение csv файла и записи данных в базу данных SQL Lite. При запуске программы идет проверка на наличие базы данных, при ее отсутствии создается объект BDCreator создающий базу данных при помощи Parser, который попутно создает лист с уникальными платформами, записывая их в файл, который используется Request.java для создания нового файла содержащего SQL запросы которые используются в графике. Необходимый ряд запросов вызывается по нажатию одной из трех кнопок, кроме 'Exit'.

### Поставленные задачи:
1. Постройте график по средним показателям глобальных продаж, объединив их по платформам.
2. Выведите игру с самым высоким показателем продаж в Европе за 2000 год.
3. Выведите в консоль название игры, созданную в промежутке

## Выполнение поставленных задач: 
#### Инсттрукция:
Если программа выдает ошибку - изменить пути к файлам в зависимости от места установки.

### Выполнение поставленных задач:
1. При нажатии кнопки "Build graph" появляется текст сообщающий о том какой грфик отображается, а так же появляется сам график отражающий глобальные показатели продаж по платформам.

![1 cleaned](https://user-images.githubusercontent.com/79215914/210633162-8fdcd88f-e2d1-4b76-8f0e-0fa2e5c2b929.png)



2. При нажатии кнопки "Show game in EU" программа выводит сообщение содержащее информацию о самой продоваемой игре в Европе за 2000 год. 

![2 cleaned](https://user-images.githubusercontent.com/79215914/210633201-d1987216-f368-4456-9cf8-254b53e10e4d.png)



3. При нажатии кнопки "Show game in JP" программа выводит сообщение содержащее информацию о самой продоваемой игре в Японии с 2000 по 2006 год в жанре спорт.

![3 cleaned](https://user-images.githubusercontent.com/79215914/210633224-091d7f61-13a7-46fd-88cd-f46e6b1013e5.png)



4. При нажатии кнопки "Exit" программа завершает свою работу. 

## Description:
Final project Ulearn Java-RTF №8.

### Development process:
First main file was created - UlearnFinalJava.java. Then files Parser.java , BDCreator.java , Request.java , Program.java were added. Files BDcreator.java and Parser.java work together. When program first laucnhes - it checks whether the data base exists. If not - the BDCreator object is created. It uses Parser.java to read the values from a csv file and also create a file to store unique values from Platform column in csv file in order to use them further to form SQL request and to build a graph. The required set of SQL requests is called depending on pressed button. 


### Tasks to complete:
1. Build a graph displaing gloabal sales statics by platfroms .
2. Display the most sold game in Europe in 2000.
3. Display the name of the most sold gamer in JApan from 2000 to 2006 in genre Sports.

## Program usage manual and task completion:
#### Instruction:
If error occurs - change the paths to the files in source code dependig on where program is installed.


### Task completion:
1. When "Build graph" is pressed the graph appears and the message displaing what graph it is.

![1 cleaned](https://user-images.githubusercontent.com/79215914/210633178-bb7c5323-2c06-4e83-83f3-0ab7deb7e821.png)


2. When "Show game in EU" is pressed infromation in label area appears displaying most sold game in Europe in yaer 2000.

![2 cleaned](https://user-images.githubusercontent.com/79215914/210633193-1e492f63-e622-4ba4-8ed2-ef39ceacdf92.png)


3. When "Show game in JP" is pressed information in label area appears displaying most sold game in Japan in time period between 2000 and 2006 in genre Sports.

![3 cleaned](https://user-images.githubusercontent.com/79215914/210633234-1a85d929-ac10-4de3-b440-f21a881df565.png)


4. When "Exit" is pressed program closes. 
