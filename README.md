# Desafio de projeto: Publicando API na Nuvem

## Linguagens de Programação/Framework
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/MAVEN-000000?style=for-the-badge&logo=apachemaven&logoColor=blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-000?style=for-the-badge&logo=postgresql)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Railway](https://img.shields.io/badge/Railway-0B0D0E?style=for-the-badge&logo=Railway&logoColor=FFFFFF)
## Desafio
No Lab do curso fomos introduzidos ao Deploy da aplicação na Nuvem utilizando o Railway como ferramenta de CI/CD e para 
instanciação da Base de Dados Postgres, na aula vimos o conceito de um usuário de um banco e seus domínios e fomos 
desafiados a implementar um projeto de domínio nosso, desenvolvi uma proposta de Escola (Universidade) que possui seus 
cursos, os cursos tem sua grade e seus alunos.

O código desenvolvido na aula vocês podem conferir [aqui](https://github.com/GabrielF-S/api-dio-bootcamp)

```mermaid
---
title: School
---
classDiagram
   class School {
        +string schoolName
        +Course[] courses
    }
  class Course {
        +string courseName
        +Student[] students
        +Discipline [] disiplines
        +int period
    }
class Student {
        +string studentName
        +string studentMail
        +map<string, int> disciplineScore
    }
class Discipline {
        +string disciplineName
        +int periode
        + bool current
        +double scores
    }
  
 School "1" -- "*" Course: 
 Course "1" -- "*" Student: 
 Course "1"-- "*" Discipline: 

