Шаги для внесения новых настроек:
1) Заполнить excel файл с названием "01 Settings - [название теста]":
- записать новую настройку с её значениями на английском языке;
- создать коды для каждого значения настройки (все названия и значения писать латиницей);
- сохранить этот excel файл в проект авто-теста.

2) Создать txt файл с названием "02 [название теста]" и выполнить следующее:
* скопировать полный набор закодированных настроек с их значениями из Excel файла с [названием теста]. То есть, нужно взять название настройки и все её закодированные значения и подготовить файл в соответствии с требования pairwise программы из следующего пункта
* добавить условия на зависимость настроек.

3) Перейти на страницу https://pairwise.yuuniworks.com/ и выполнить следующее:
- скопировать содержимое txt файла в левую колонку страницы;
- нажать кнопку "Generate" для генерации процесса pairwise;
- загрузить файл с результатом.

4) Создать excel файл с названием "03 [полное название класса авто-теста]" (С ЭТИМ ФАЙЛОМ БУДЕТ РАБОТАТЬ АВТО-ТЕСТ) и выполнить следующее:
* скопировать содержимое txt файла с результатом процесса pairwise - открыть через LibreOffice, где выбрать "Параметры разделителя -- Табуляция";
* если используется LibreOffice - выделить всё, выбрать "Формат -- Столбцы -- Оптимальная ширина";
* сохранить этот excel файл в проект авто-теста.

[P.S.] Может быть такое, что программа Intellij Idea будет ругаться на формат excel файла. В таком случае, сделать копию excel файла из предыдущего авто-теста, переименовать файл на соответствующее название и скопировать содержимое txt файла с результатом процесса pairwise.  

5) В программе Intellij Idea выполнить шаги:
- в классе с соответствующими настройками добавить новые настройки, их условия и их методы, где название метода это код значения настройки. Например, настройки цветосхемы расположены в классе ColorScheme.
