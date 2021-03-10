## * a simple spring boot example *

-----

#### 环境要求
```
java1.8 (my version: openjdk version "1.8.0_232")
Apache Maven 3.6.0
mysql数据库 people表
```
---

#### 建表语句

CREATE TABLE `people` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `sex` varchar(40) NOT NULL DEFAULT '',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


---

#### application 入口： 
App.java

---

#### --- build:
```shell
git clone https://github.com/liikii/chapter1.git
cd chapter1
mvn compile
mvn test
mvn package spring-boot:repackage
java -jar target/chapter1-1.0-SNAPSHOT.jar
```

#### --- test:
```shell
curl -vkX GET http://127.0.0.1:8080/
```

