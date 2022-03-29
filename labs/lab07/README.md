# JUnit teszt fordítása és futtatása:

* Unix alatt:
```
javac -cp .:junit-4.12.jar Tester.java
java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar org.junit.runner.JUnitCore Tester
```


* Windows alatt:
```
javac -cp ".;junit-4.12.jar" Tester.java
java -cp ".;hamcrest-core-1.3.jar;junit-4.12.jar" org.junit.runner.JUnitCore Tester
```

