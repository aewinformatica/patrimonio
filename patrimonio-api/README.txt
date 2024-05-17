##Como rodar o projeto
./mvnw clean package spring-boot:run

## PARAR
WINDOWS 
 netstat -ao |find /i "listening"
taskkill /F /IM PID

taskkill /F /IM 12056
LINUX
 netstat -ao |grep  "8080"