**Currently, users from Moscow and etc. can have problems with accessing the moviedb api.
  It means that my app won't work for them. I've already contacted support team, so please be tuned.**


Average Movie Rating Agregation Service

In active development

**What is it for?**<br />
  
  Its my learning and portfolio project where I learn how to implement microservice architecture using Spring. 
  I want to make a web app based on microservice architecture where you can find a movie and its brief information.

**How to run this thing?**<br />

  Using docker-compose:<br />
  ```
  git clone https://github.com/Allexandere/AMRAS.git
  cd AMRAS/
  mvn clean package -DskipTests
  docker-compose up
  ```
  If during running occured error 127 - delete wait-for-it.sh and download it without using git (like zip archive or etc.)
 
 **Endpoints:**<br />
 
  `http://localhost:8084/`<br />
  Main page <br />
  
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/main-page.jpg?raw=true)
  
  Some movies
  
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/movie1.jpg?raw=true)
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/movie2.jpg?raw=true)
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/movie3.jpg?raw=true)
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/movie4.jpg?raw=true)
  
  Map of project
  
  ![alt text](https://github.com/Allexandere/AMRAS/blob/main/map.jpg?raw=true)
  
  
