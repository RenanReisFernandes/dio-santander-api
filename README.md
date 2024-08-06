
<h1 align="center">
 DESAFIO DIO MODELAGEM DE BANCO PARA DESAFIO SANTANDER
 <h3 align ="center" >Projeto de modelagem de backend de simulação de aplicação bancária ☕</h3> 
</h1>

### 📕 SOBRE 
<h4>Desafio da DIO de modelagem  de backend de uma aplicação simulação de banco</h4>



### 🧜‍♀️ **DIAGRAMA(Mermaid)**: 

```mermaid
classDiagram
   class User {
      -  Long id
      -  String name
      -  String cpf
      -  String phoneNumber
      -  LocalDate birthDate
      -  String address
      -  Set<Account> accounts
      -  Card card
      -  List<Feature> features
      -  List<News> news
    }

    class Account{
        private Long id;

    - String number;
    - String agency;
    - Double balance;
    }
    class Card{

    - Long id;
    - String number;
    - Double limit;
    }
    class Feature{
    - Long id;
    - String icon;
    - String description;
    }
    class News{
    - Long id;
    - String icon;
    - String description;
    }

    User --> "1" Account : hasMany
    User --> "1" Card : hasOne
    User --> "1" Feature : hasMany
    User --> "1" News : hasMany
```

    

    ### 🔨 FERRAMENTAS UTILIZADAS

- [**JAVA**](https://docs.oracle.com/en/java/)
- [**SPRING BOOT**](https://docs.spring.io/spring-boot/index.html)
- [**GIT**](https://git-scm.com/doc)
- [**GITHUB**](https://docs.github.com/pt)
- [**H2**](https://www.h2database.com/html/main.html)
- [**POSTGRESQL**](https://www.h2database.com/html/main.html)
- [**SWAGGER**](https://swagger.io/docs/)
- [**POSTMAN**](https://learning.postman.com/docs/introduction/overview/)
- [**RAILWAY**](https://railway.app/)