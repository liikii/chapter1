## readme

#### 环境要求
```
java8
maven 
```

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

