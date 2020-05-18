# Vehicle Price List Application

## About project

A single page web application that lists the vehicle price details  
built using Java + Spring Boot + H2(in-memory database) + Angular.  
JAVA Version - "13.0.1"  
Frameworks Used: Spring-Boot (Version : 2.1.14), Angular CLI: 9.1.6  

## Instructions to execute project

1. Extract both 'AngularClient' and  'VehiclePriceList' into the working directory.
2. cd into 'VehiclePriceList' folder
3. Run the following command  
	> mvn spring-boot:run
4. This will start the backend java application with H2 database already configured
5. Open new terminal and cd into 'AngularClient' folder
6. Angular needs to be installed via the command
	>npm install -g @angular/cli
7. Then run  
	>npm install
8. After that run  
	>ng serve  
9. This will start the angular client side application

10. The URL to access the web application is  
    > http://localhost:4200/priceList
