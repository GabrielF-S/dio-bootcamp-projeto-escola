
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
        +int period
    }
class Student {
        +string studentName
        +string studentMail
        +map<string, int> scores
    }

  
 School "1" -- "*" Course: 
    Course "1" -- "*" Student: 
