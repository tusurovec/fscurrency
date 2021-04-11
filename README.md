Тестовое приложения для Focus Start

В рамках тестового задания было реализовано приложение, в котором:
1) выводится список полученных валют с http://www.cbr.ru/scripts/XML_daily.asp


2) при получении сетевой ошибки выводится toast с тектом
![Uploading Снимок экрана 2021-04-11 в 14.50.49.png…]()

3) есть возможность обновить данные по свайпу
4) показывается прогресс бар в момент получения данных

В проекте для работы с сетью используется библиотека Retrofit
dependencies {
	implementation 'com.squareup.retrofit2:retrofit:2.9.0'
	implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
