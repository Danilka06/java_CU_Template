# Technical Assignment

## Функционал проекта
1. **Пользователь**
    - Пользователь может добавлять, редактировать и удалять товары из своих заказов
    - Пользователь может смотреть список товаров с фильтрами (категория, цена). По сути просмотр заказов (у них есть разный статус)
    - Пользователь внутри себя не хранит заказы, линк на пользователя идет от самого заказа
    - Как я понимаю еще надо добавить регу на юзера

2. **Продукты**
    - Просто модельки с продуктам?
    - Есть категори по которой надо будет потом сортировать

3. **Управление заказами**
    - Создание, редактирование, удаление заказов. По сути взаимодействие с БД
    - Видно статус заказа (новый, в обработке, выполнен)
    - Все данные хранятся в БД, то есть у нас нет никаких листов с данными (по кд делаем реквесты в БД, что очень плохо)


## API 

### UserController
- **GET** `/{id}` - получает пользователя по id → `GetUserFromTable`  
- **POST** `/` - создает нового пользователя → `CreateUser`  
- **DELETE** `/{id}` - удаляет пользователя по id → `DeleteUser`  
- **PATCH** `/{id}` - обновляет пользователя по id → `UpdateUser`  

### AuthController
- **POST** `/register` - регистрация пользователя → `RegisterUser`  
- **POST** `/login` - аутентификация → `LoginUser`  


## Roles

1. **Пользователь + Аутентификация**
    - `UserController.java` + `AuthController.java`
    - `User.java` (сущность)
    - Все тесты (`User*Test.java`, `Auth*Test.java`)
    - etc


## File structure
    src/
    ├── main/
    │ ├── java/com/example/
    │ │ ├── controller/
    │ │ │ ├── .java
    │ │ │ └── UserController.java
    │ │ │
    │ │ ├── model/
    │ │ │ ├── dto/
    │ │ │ │ ├── .java
    │ │ │ │ └── UserDto.java
    │ │ │ │
    │ │ │ └── entity/
    │ │ │   ├── .java
    │ │ │   └── User.java
    │ │ │
    │ │ ├── service/
    │ │ │ ├── exceptions/
    │ │ │ │ └── .java
    │ │ │ │
    │ │ │ ├── interfaces/
    │ │ │ │ ├── .java
    │ │ │ │ └── UserServiceInterface.java
    │ │ │ │
    │ │ │ ├── .java
    │ │ │ └── UserService.java
    │ │ │
    │ │ ├── util/
    │ │ │ └── Validators.java
    │ │ └── ProjectApplication.java
    │ │
    │ └── resources/
    │   ├── db/
    │   │ └── schema.sql
    │   │
    │   ├── application.properties
    │   └── application.yml
    │
    ├── test/
    │ └── java/com/example/ # Test packages mirror main structure
    │
    ├── docs/
    │ ├── ASSIGNMENT.md
    │ └── PROJECT_SETUP.md
    │
    .gitattributes
    .gitignore
    .gitlab-ci.yml
    build.gradle
    settings.gradle
    Dockerfile
    docker-compose.yml
    gradlew
    gradlew.bat
    README.md