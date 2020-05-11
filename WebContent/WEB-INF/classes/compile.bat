@echo off
color 0a
javac -classpath "C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar" -d bin -sourcepath ..\..\..\src *.java
pause