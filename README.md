# Titulo

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
        +Discipline [] disiplines
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
 Student "1" -- "*" Discipline: 
