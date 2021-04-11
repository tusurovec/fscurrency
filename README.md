Тестовое приложения для Focus Start

В рамках тестового задания было реализовано приложение, в котором:
1) выводится список полученных валют с http://www.cbr.ru/scripts/XML_daily.asp
<img width="365" alt="Снимок экрана 2021-04-11 в 14 47 44" src="https://user-images.githubusercontent.com/4588631/114296425-867d4400-9ad5-11eb-83c6-7b12fd32de7c.png">

2) при получении сетевой ошибки выводится toast с тектом
<img width="364" alt="Снимок экрана 2021-04-11 в 14 50 49" src="https://user-images.githubusercontent.com/4588631/114296430-8c732500-9ad5-11eb-8cef-2a62875771c6.png">

3) есть возможность обновить данные по свайпу
<img width="364" alt="Снимок экрана 2021-04-11 в 14 54 42" src="https://user-images.githubusercontent.com/4588631/114296495-dfe57300-9ad5-11eb-9a57-483c210827d5.png">

4) показывается прогресс бар в момент получения данных
<img width="366" alt="Снимок экрана 2021-04-11 в 14 49 36" src="https://user-images.githubusercontent.com/4588631/114296443-95fc8d00-9ad5-11eb-92e2-6ba46f6c99ab.png">


Для работы с сетью в проекте используется библиотека Retrofit

dependencies {
	implementation 'com.squareup.retrofit2:retrofit:2.9.0'
	implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
