# Readme

### Web-crud

#### Пример web-crud приложения, с поднятием его и базы даных PostgreSQL в docker-контейнерах

Приложение способно принимать/отправлять данные в формате JSON по Rest-протоколу

Принимает данные формата:  
```json
{
"id": 7,
"name": "Философия Java",
"author": "Брюс Эккель",
"release": "2015",
"privateCatalog": false
}
```

Адрес api для работы с JSON: <адрес сервиса>:8282/api/books

доступные команды:  
POST /create  
GET  /read  
GET  /read/{id}  
POST /update  
POST /update/{id}  
POST /delete  
POST /delete/{id}  
GET  /readAllPrivate  
GET  /readAllPublic  

Например: http://localhost:8282/api/books/read

Так же имеется простой user-интерфейс для взаимодействия через браузер,
доступный по адресу: http://localhost:8282/books/index  
можно настроить запуск web-интерфейса при старте программы(настраиваемая функция)



#### Установка:
1) собираем проект с помощью build gradle
2) сначала создаем образ с помощью Dockerfile
3) затем запускаем docker-compose.yaml
