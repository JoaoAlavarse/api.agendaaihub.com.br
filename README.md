# Estrutura de pastas do template

````shell
src/main/java/dev/alavarse/template/api
│
├── domain
│   ├── user
│   │   ├── model
│   │   │   ├── UserEntity.java
│   │   │   ├── UserRoles.java
│   │   │   └── UserStatus.java
│   │   └── repository
│   │       └── UserRepository.java
│   │
│   └── exception
│       ├── auth
│       │   ├── EmailAlreadyExistsException.java
│       │   ├── InconsistentPasswordException.java
│       │   └── InvalidLoginException.java
│       │
│       └── user
│           ├── UserNotActiveException.java
│           └── UserNotFoundException.java
│
├── application
│   ├── auth
│   │   ├── AuthService.java
│   │   ├── AuthServiceImpl.java
│   │   ├── validator
│   │   │   ├── LoginValidator.java
│   │   │   └── UserRegisterValidator.java
│   │   └── dto
│   │       ├── input
│   │       │   ├── UserRegisterRequestDto.java
│   │       │   └── LoginRequestDto.java
│   │       └── output
│   │           └── AuthResponseDto.java
│   │
│   └── user
│       ├── UserService.java
│       └── UserServiceImpl.java
│
├── infra
│   ├── config
│   │   └── LocaleConfig.java
│   │
│   ├── persistence
│   │   ├── audit
│   │   │   └── AuditConfig.java
│   │   └── user
│   │       ├── JpaUserRepository.java
│   │       └── UserRepositoryImpl.java
│   │
│   ├── security
│   │   ├── JwtService.java
│   │   ├── JwtAuthFilter.java
│   │   ├── SecurityAuditorAware.java
│   │   ├── UserDetailsServiceImpl.java
│   │   └── SecurityConfig.java
│   │
│   └── web
│       ├── ApiExceptionHandler.java
│       ├── WebConfig.java
│       └── controllers
│           └── AuthController.java
│
└── shared
    ├── persistence
    │   ├── BaseEntity.java
    │   └── SoftDelete.java
    │
    ├── exception
    │   ├── ApiException.java
    │   ├── ErrorCodes.java
    │   └── ProblemDetails.java
    │
    └── dto
        └── output
            └── ApiResponseDto.java

````

> **Domain**
: Contém entidades do domínio e regras de negócio puras.
>

> **Application**
: Contém serviços que coordenam casos de uso, lógica de aplicação, e validações.

> **Infra**
: Contém implementações técnicas e integrações externas (Spring, banco de dados, JWT, etc.).

> **Shared**
: Contém recursos reutilizáveis entre domínios e camadas.


### Desenvolvido por @JoaoAlavarse