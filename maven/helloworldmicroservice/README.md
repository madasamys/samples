**Hello world micro service**

1. Run the server

     From project root directory execute below commands

    ```cd server```
    
    ```mvn clean spring-boot:run```
    
 2. Browse the web interface for server
 
     ```localhost:1111```
     
 3. Run the hello service
      
      ```cd hello-service```
      
    ```mvn clean spring-boot:run``` 
  
 4. Go to ```localhost:1111```
       The service hello-service displayed in application
       Now we are successfully created hello-service micro service   
 
 5. Run the hello client service
       
       ```cd hello-client```
      
      ```mvn clean spring-boot:run``` 
  
 6. Browse the web interface for client
 
     ```localhost:8080```

