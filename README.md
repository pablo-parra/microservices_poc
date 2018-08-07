# microservices_poc
Proof of concept of microservices based on Spring Cloud

## The Project Includes

  - Microservices Infrastructure: Eureka, Zuul, Centralized Configurations, Auth service sample.
  - Microservices:
    * Microservice 1: two instances (SampleApp1 & SampleApp1b)
    * Microservice 2: one instance (SampleApp2)

## Installation of Devonfw modules (if you are new on Devonfw)
  1. Download [devonfw](http://de-mucevolve02/files/devonfw/)
  2. Initialize the distribution executing the _create-or-update-workspace.bat_ script
  2. Launch the _console.bat_ script and install the microservices module
  	`C:...\Devon-dist\workspaces\examples\devon>mvn install`
  3. Clone this repository in a new directory _microservices_poc_ created in your _workspaces_ folder
  4. Execute the script _update-all-workspaces.bat_ to generate the Eclipse instance for the _microservices_poc_ project
  5. Launch the just created _eclipse-microservices_poc.bat_ script and import the microservices projects included in this repo.

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
		
