# perfiltic
Hello
in order to run the DB (POSTGRESQL), you have follow these instructions:
1) run the command ... mvn clean package -Dmaven.test.skip=true -DDB_HOST=localhost  ( compiling springboot app )
2) run the following command "docker-compose up -d" in the root folder  ( that will create the containers database,springbootapp and run them)

3) the frontend was built in angular, in order to run it, go to the dockerAngular/angular/perfiltic-front path, then run the command "ng build --prod" in order to create a production build
4) run the following command "docker build -t tic-app ." in the dockerAngular/ folder
5 ) run the following command "docker run --name angular -d -p 8080:8080 tic-app" in the dockerAngular/ folder

Finally ... you've a backend at port 8081 and frontend in port 8080 



THE VIDEO IS IN THE FOLLOWING LINK  https://www.loom.com/share/ef7e519de08240dfa814036da1009172