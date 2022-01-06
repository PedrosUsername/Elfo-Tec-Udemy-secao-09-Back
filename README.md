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

abra outro terminal e, com o cURL teste os end points de servicos com os seguintes comandos:
+ Criar serviço (só funciona se um cliente de id=1 já tiver sido criado):
```
$ curl -X POST -H "Content-Type: application/json" -d '{ "description":"service02", "price":"10", "clientId":1, "date":"01/02/2000"}' localhost:8080/api/servicos-prestados
```
+ No navegador, pesquisar por um serviço com:
```
$ localhost:8080/api/servicos-prestados?mes=1&nome=j
```


### Observações:

+ O audio do curso poderia ser melhor
+ A query feita no repositório de serviços é assustadora.
