# Diplom-QA

## **Запуск Авто-тесто**

### **Предусловие**


1. Для запуска контейнеров ипользовалась виртуальная машина.
2. Адрес - 185.119.56.254
3. Логин - student
4. Пароль - netologystudent
5. Для запуска виртуальной машины использовалась программа PuTTY.

### **Шаги для запуска тестов** 

1. Запускаем IntelliJ IDEA
2. Запускаем программу PuTTY.
3. Клонируем репозиторий
4. Переходим в каталог cd projects/Diplom-QA
5. Запускаем Docker docker-compose up -d
6. Запускаем SUT с поддержкой MySQL
   - java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar aqa-shop.jar
7. Переходим в IntelliJ IDEA
8. Запускаем тесты с базой данных MySQL
    - ./gradlew clean test -Durl=jdbc:mysql://185.119.57.64:3306/app
9. Переходим в виртуальную машину
10. Запускаем SUT с поддержкой PostgreSQL
    - java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -jar aqa-shop.jar
11. Переходим в IntelliJ IDEA
12. Запускаем тесты с базой данных PostgreSQL
    - ./gradlew clean test -Durl=jdbc:postgresql://185.119.57.64:5432/app
13. Генерируем отчет спомощью фреймворка Allure
    - ./gradlew allureReport --clean
14. Останавливаем контейнеры docker-compose down
