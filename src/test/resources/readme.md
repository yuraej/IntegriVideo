                         ШПАРГАЛКА ПО КАМАНДАМ MAVEN ДЛЯ ТЕРМИНАЛА:
                  
Команда отображения всех зависимостей для которых есть обновления MAVEN:
       mvn versions:display-dependency-updates

Команда обновления зависимостей:
       mvn versions:use-latest-versions       

Для запуска сборки проекта с предварительной очисткой поддиректории "target" без выполнения тестов
используйте следующую команду:
       mvn clean package -Dmaven.test.skip=true
       
Чтобы запустить выполнение тестов с предварительной очисткой папки target надо ввести команду:
        mvn clean test
               

Чтобы выполнить класс с тестами необходимо в командной строке ввести:
       mvn test -Dtest=Имя класса с тестами
пример:
       mvn test -Dtest=CheckIntegriVideo
       
Чтобы выполнить отдельный тестовый метод из класса с тестами надо:
       mvn test -Dtest=Имя класса с тестамИ#Имя тестового методА test    
пример:
         mvn test -Dtest=CheckIntegriVideo#checkInputMessageByButton test         
       
Чтобы выполнить несколько тестовых методов из класс с тестами надо:
        mvn test -Dtest=Имя класса с тастамИ#testНазвание 1-го тестового методА+testНазвание 2-го тестового методА test
пример:
        mvn test -Dtest=CheckIntegriVideo#testcheckInputMessageByButton+testcheckCopyCode test (НЕ РАБОТАЕТ)               

Чтобы работать с альтернативным pom.xml надо:
       mvn -f путь к файлу/Имя файла имя команды(clean, test, ...)
пример:
       mvn -f src/test/resources/filesForTests/my_pom.xml  clean   
    
Чтобы передать данные в тест надо:
       mvn test -Dtest=Имя класса с тестамИ#Имя тестового методА test(команда запуска теста, в который передаем данные) -DИмя маркерА=testДанные
проимер:
 @Test
    public void checkInputMessageByButton() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage(System.getProperty("testProp"));       //точка ввода данных в метод из терминала
        chat.sendMassageByButton();
        assertEquals(chat.checkMessage("test123"), "test123");
    }
       mvn test -Dtest=CheckIntegriVideo#checkInputMessageByButton test -DtestProp=test123      
        
Команда для добавления переменной среды:
        PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/yura/Документы/BIN/allure-commandline-2.13.0/allure-2.13.0/bin       
     