# **Планировании автоматизации тестирования**

## **Тестирование покупки тура Маракеш**
![](https://github.com/netology-code/qa-diploma/blob/master/pic/service.png)

## **Возможные варианты покупки тура:**

- Оплата дебетовой картой
- Покупка в кредит

### **Перечень автоматизируемых сценариев:**

**Позитивные сценарии:**
- Оплата по дебетовой карте со статусом APPROVED
- Оплата по дебетовой карте со статусом DECLINED
- Оплата через кредит со статусом карты APPROVED
- Оплата через кредит со статусом карты DECLINED

**Негативные сценарии 2 итерации (Тестирование оплаты дебетовой карты/покупка в кредит):**
- Тестирование поля Номер карты
- Тестирование поля Месяц
- Тестирование поля Год
- Тестирование поля CVC/CVV
- Тестирование поля Владелец

### **Перечень используемых инструментов:**

**IntelliJ IDEA**

IntelliJ IDEA — интегрированная среда разработки программного обеспечения для многих языков программирования, в частности Java, JavaScript, Python, разработанная компанией JetBrains.

**Java**

 Java- строго типизированный объектно-ориентированный язык программирования общего назначения.
 
 **Gradle**
 
Gradle - система автоматической сборки, построенная на принципах Apache Ant и Apache Maven, но предоставляющая DSL на языках Groovy и Kotlin вместо традиционной XML-образной формы представления конфигурации проекта.

**JUnit**

JUnit - фреймворк для модульного тестирования программного обеспечения на языке Java.

**Allure**

Allure - фреймворк от Яндекса для создания простых и понятных отчётов автотестов.

**GitHub**

GitHub — крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки.
 
**Selenide**

Selenide - это обёртка вокруг Selenium WebDriver, позволяющая быстро и просто его использовать при написании тестов, сосредоточившись на логике.


### **Перечень и описание возможных рисков при автоматизации:**

- Нет технического задания
- Возможно изменение кода тестируемой системы


### **Интервальная оценка с учётом рисков (в часах):**

Необходимое время на тестирование составляет 50 часов, с учетом рисков - 75 часов:

подготовка окружения, инфраструктуры, развертывание БД - 8 часов

написание авто-тестов, тестирование - 35 часов

формирование и анализ отчетов - 7 часов

### **План сдачи работ:**

Планирование автоматизации тестирования: с 25.11.2021 до 04.12.2021

Непосредственно сама автоматизация: с 04.12.2021 до 20.12.2021

Подготовка отчётных документов по итогам автоматизированного тестирования: с 20.12.2021 до 23.11.2021

Подготовка отчётных документов по итогам автоматизации: с 23.12.2021 до 26.12.2021

