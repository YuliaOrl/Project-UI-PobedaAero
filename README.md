# Проект по автоматизации UI тестирования для главной страницы сайта Pobeda.aero

## :green_book: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Варианты запуска тестов](#running_woman-варианты-запуска-тестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомление в Telegram с использованием бота](#-уведомление-в-telegram-с-использованием-бота)
- [Видео запуска одного из тестов в Selenoid](#-видео-запуска-одного-из-тестов-в-selenoid)

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Параметризованные автотесты написаны на <code>Java</code> с использованием <code>Gradle</code> и <code>JUnit 5</code>.
Для UI тестов используется фреймворк [Selenide](https://selenide.org/).
Тесты можно запускать локально или удаленно с помощью [Selenoid](https://aerokube.com/selenoid/).
Сборка в <code>Jenkins</code> реализована с формированием Allure-отчета и отправкой уведомления с результатами тестирования в <code>Telegram</code> после завершения прохождения тестов.

Allure-отчет включает в себя:
* названия тестов с шагами выполнения;
* скриншот страницы в браузере в момент завершения автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения UI тестов.

## :running_woman: Варианты запуска тестов

### Локальный запуск тестов
С параметрами по умолчанию
```
gradle clean test -Denv=local
```

При необходимости можно изменить параметры запуска
```
gradle clean test
-Denv=local
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
```

### Запуск тестов на удаленном браузере
```
gradle clean test -Denv=remote
```
При необходимости можно изменить параметры запуска

```
gradle clean test -Denv=remote
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
```

### Параметры сборки

* <code>BROWSER_NAME</code> – браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>100.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Yulia%20Orlova%20Project%20auto%20testing%20UI%20Pobeda.aero/">*Jenkins job*</a>

<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Allure-отчет
### <a target="_blank" href="https://jenkins.autotests.cloud/job/Yulia%20Orlova%20Project%20auto%20testing%20UI%20Pobeda.aero/5/allure/">*Overview*</a>

<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReportMain.png">
</p>

### *Результат прохождения параметризованных тестов с описанием  и шагами выполнения*

<p align="center">
<img title="Test Results in Alure" src="images/screenshots/allureReportTests.png">
</p>

### *Графики*
<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReportGraphs1.png">
</p>
<p align="center">
<img title="Allure Overview" src="images/screenshots/allureReportGraphs2.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/AllureTestOps.svg"> Интеграция с Allure TestOps
### *Allure TestOps* <a target="_blank" href="https://allure.autotests.cloud/project/1669/dashboards">*Dashboard*</a>

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screenshots/allureTestOpsDashboard.png">  
</p>  

### *Тест кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screenshots/allureTestOpsTestCases.png">  
</p>

### *Запуски*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screenshots/allureTestOpsLaunches.png">  
</p>

### *Результаты прохождения тестов*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screenshots/allureTestOpsResult.png">  
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомление в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически отправляет сообщение с отчетом прохождения тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/notificationTelegram.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="images/logo/Selenoid.svg"> Видео запуска одного из тестов в Selenoid

Для каждого теста выполняется запись видео. Ниже представлен пример видео прохождения теста.
<p align="center">
  <img title="Selenoid Video" src="images/gif/videoExample.gif">
</p>
