Тестовое приложения для Focus Start

В рамках тестового задания было реализовано приложение, в котором:
- выводится список полученных валют с http://www.cbr.ru/scripts/XML_daily.asp
- при получении сетевой ошибки выводится toast с тектом
- есть возможность обновить данные по свайпу
- показывается прогресс бар в момент получения данных

В проекте для работы с сетью используется библиотека Retrofit
dependencies {
	implementation 'com.squareup.retrofit2:retrofit:2.9.0'
	implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
