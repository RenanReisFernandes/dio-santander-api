
<h1 align="center">
 DESAFIO DIO MODELAGEM DE BANCO PARA DESAFIO SANTANDER
 <h3 align ="center" >Projeto de modelagem de diagrama UML do Iphone ☕</h3> 
</h1>

### 📕 SOBRE 
<h4>Desafio da DIO de modelagem  de backend de uma aplicação simulação de banco</h4>



### 🧜‍♀️ **DIAGRAMA(Mermaid)**: 

```mermaid
classDiagram
   class User {
        Long id
        String name
        String cpf
        String phoneNumber
        LocalDate birthDate
        String address
        Set<Account> accounts
        Card card
        List<Feature> features
        List<News> news
    }

    class Account
    class Card
    class Feature
    class News

    User --> "1" Account : hasMany
    User --> "1" Card : hasOne
    User --> "1" Feature : hasMany
    User --> "1" News : hasMany