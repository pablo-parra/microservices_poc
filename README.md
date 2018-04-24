# microservices_poc
Proof of concept of microservices based on Spring Cloud

## The Project Includes

  - Microservices Infrastructure: Eureka, Zuul, Centralized Configurations, Auth service sample.
  - Microservices:
    * Microservice 1: two instances (SampleApp1 & SampleApp1b)
    * Microservice 2: one instance (SampleApp2)

## Implemented Services

  - login (Auth service) --> is mocked, only a PoC
  - logic in Microservice 1
  - logic in Microserivce 2
  - Microservice 1 calling Microservice 2 to get some data.

## Postman collection

  Also included a postman collection (microservices.postman_collection.json) to test the project. The collection uses Environment variables to ease of use of the calls.
  
  See:
    - https://www.getpostman.com/docs/v6/postman/environments_and_globals/manage_environments
	- https://www.getpostman.com/docs/v6/postman/environments_and_globals/variables
	
	
  Calls included in this Postman collection:
  
    - login: returns the jwt based on a user/password POST call.
    - Through Zuul
		* call to microservice 1 (there are two instances so the load balancer can be demonstrated reading the response)
		* call to microservice 2
		* call to microservice 1 that also calls microservice 2
		
