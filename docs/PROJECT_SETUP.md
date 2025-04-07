## Функционал проекта
1. Пользователь
    - Пользователь может добавлять, редактировать и удалять товары из своих заказов
    - Пользователь может смотреть список товаров с фильтрами (категория, цена). По сути просмотр заказов (у них есть разный статус)
    - Пользователь внутри себя не хранит заказы, линк на пользователя идет от самого заказа
    - Как я понимаю еще надо добавить регу на юзера

2. Продукты
    - Просто модельки с продуктам?
    - Есть категори по которой надо будет потом сортировать

3. Управление заказами
    - Создание, редактирование, удаление заказов. По сути взаимодействие с БД
    - Видно статус заказа (новый, в обработке, выполнен)
    - Все данные хранятся в БД, то есть у нас нет никаких листов с данными (по кд делаем реквесты в БД, что очень плохо)


## Roles

1. **Пользователь + Аутентификация**
    - `UserController.java` + `AuthController.java`
    - `UserServiceImpl.java` + `JwtService.java`
    - `UserDto.java` + `AuthRequest.java` + `AuthResponse.java`
    - `User.java` (сущность)
    - `SecurityConfig.java` (настройки безопасности)
    - Все тесты (`User*Test.java`, `Auth*Test.java`)
    - `SwaggerConfig.java` (документация API)

2. **Продукты + Девопс**
    - `ProductController.java`
    - `ProductServiceImpl.java`
    - `ProductDto.java` (request/response)
    - `Product.java` (сущность)
    - `Dockerfile` + `docker-compose.yml`
    - `.gitlab-ci.yml` (CI/CD пайплайн)
    - `Product*Test.java` (тесты)
    - `Application.java` (настройка Spring Boot)

3. **Заказы + Общая инфраструктура**
    - `OrderController.java`
    - `OrderServiceImpl.java` (с интеграцией User/Product)
    - `OrderDto.java` + `OrderItemDto.java`
    - `Order.java` + `OrderItem.java` (сущности)
    - `GlobalExceptionHandler.java` (обработка ошибок)
    - `ValidationUtils.java` (валидация данных)
    - `Order*Test.java` (тесты)
    - `DB_SCHEMA.md` (документация БД)


## API 

### UserController
- **GET** `/{id}` - получает пользователя по id → `GetUserFromTable`  
- **POST** `/` - создает нового пользователя → `CreateUser`  
- **DELETE** `/{id}` - удаляет пользователя по id → `DeleteUser`  
- **PATCH** `/{id}` - обновляет пользователя по id → `UpdateUser`  

### ProductController
- **GET** `/` - список товаров (с фильтрами) → `GetAllProducts`  
- **POST** `/` - добавляет новый товар → `CreateProduct`  
- **GET** `/{id}` - получает товар по id → `GetProductById`  
- **PUT** `/{id}` - обновляет товар по id → `UpdateProduct`  
- **DELETE** `/{id}` - удаляет товар по id → `DeleteProduct`  

### OrderController
- **POST** `/` - создает новый заказ → `CreateOrder`  
- **GET** `/` - список заказов пользователя → `GetUserOrders`  
- **GET** `/{id}` - получает заказ по id → `GetOrderById`  
- **PATCH** `/{id}/status` - обновляет статус заказа → `UpdateOrderStatus`  

### AuthController
- **POST** `/register` - регистрация пользователя → `RegisterUser`  
- **POST** `/login` - аутентификация → `LoginUser`  


## File structure
    src/
    ├── main/
    │ ├── java/com/example/
    │ │ ├── controller/
    │ │ │ ├── OrderController.java
    │ │ │ ├── ProductController.java
    │ │ │ └── UserController.java
    │ │ │
    │ │ ├── model/
    │ │ │ ├── dto/
    │ │ │ │ ├── OrderDto.java
    │ │ │ │ ├── ProductDto.java
    │ │ │ │ └── UserDto.java
    │ │ │ │
    │ │ │ └── entity/
    │ │ │   ├── Order.java
    │ │ │   ├── OrderItem.java
    │ │ │   ├── Product.java
    │ │ │   └── User.java
    │ │ │
    │ │ ├── service/
    │ │ │ ├── exceptions/
    │ │ │ │ └── NotFoundException.java
    │ │ │ │
    │ │ │ ├── interfaces/
    │ │ │ │ ├── OrderServiceInterface.java
    │ │ │ │ ├── ProductServiceInterface.java
    │ │ │ │ └── UserServiceInterface.java
    │ │ │ │
    │ │ │ ├── OrderService.java
    │ │ │ ├── ProductService.java
    │ │ │ └── UserService.java
    │ │ │
    │ │ └── util/
    │ │   ├── Validators.java
    │ │   └── ProjectApplication.java
    │ │
    │ └── resources/
    │   ├── db/
    │   │ └── db_template.sql
    │   │
    │   ├── application.properties
    │   └── application.yml
    │
    ├── test/
    │ └── java/com/example/ # Test packages mirror main structure
    │
    docs/
    ├── ASSIGNMENT.md
    └── PROJECT_SETUP.md
    │
    .gitignore
    build.gradle
    Dockerfile
    gradlew