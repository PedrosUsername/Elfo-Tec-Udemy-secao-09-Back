## Angular + Spring Boot: Udemy Fullstack
## Seção 5: API de Clientes

### Pré-requisitos
Gerado em:
> https://start.spring.io/

com as seguintes configurações:
> Project: Maven Project;<br>
> Language: Java;<br>
> Spring Boot: 2.6.2;<br>
> Packing: Jar;<br>
> Java: 8;<br>
> Dependencies: ['Lombok', 'Spring-Web', 'Spring-Data-JPA', 'H2-Database'];<br>

### Rodando o projeto localmente

Abra o terminal, e ponha o servidor para rodar com:
```
$ ./mvnw spring-boot:run
```
em seguida, no navegador, acesse a url:
> 127.0.0.1:8080/h2-console

abra outro terminal e, com o cURL teste o CRUD com os seguintes comandos:
+ CREATE:
```
$ curl -X POST -H "Content-Type: application/json" -d '{ "name":"Jhonny", "cpf":"12345678901"}' localhost:8080/api/clientes
```
+ READ:
```
$ curl -X GET localhost:8080/api/clientes/
```
+ UPDATE:
```
$ curl -X PUT -H "Content-Type: application/json" -d '{"name":"Jose", "cpf":"12345678902"}' localhost:8080/api/clientes/1
```
+ DELETE:
```
$ curl -X DELETE localhost:8080/api/clientes/1
```
### Observações:

+ O audio do curso poderia ser melhor
+ Muito bacana a anotacao @PrePersist
