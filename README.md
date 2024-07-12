Метод getPolygonCoordinates получает url <br/> 
(положила html в этот же репозиторий и передавала его ссылкой https://rawcdn.githack.com/Hroocha/polygon-coordinates/ea88ff662746e4b4f72c4293bb81744e77c44f49/src/main/resources/map.html), <br/> 
В сервисе метод подключается к url, получает и преобразовывает в документ, потом в строку, <br/> 
У строки отрезает начало, до части где содержится полигон, <br/> 
Достает цифры, преобразует и дает ответ <br/> 
