# microservices_poc
Proof of concept of microservices based on Spring Cloud

## The Project Includes

  - Microservices Infrastructure: Eureka, Zuul, Centralized Configurations, Auth service sample.
  - Microservices:
    * Microservice 1
    * Microservice 2

## Installation of Devonfw modules (if you are new on Devonfw)
:warning: _This project is based on **devonfw 2.4.0**_
  1. Download [devonfw](http://de-mucevolve02/files/devonfw/)
  2. Initialize the distribution executing the _create-or-update-workspace.bat_ script
  2. Launch the _console.bat_ script and install the microservices module
  	`C:...\Devon-dist\workspaces\examples\devon\modules\microservices>mvn install`
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
		* call to microservice 1
		* call to microservice 2
		* call to microservice 1 that also calls microservice 2

## Running the microservices
You can run it using Eclipse or using the bootified artifact.

### With Eclipse
Once you have your projects imported into the Eclipse instance you can go to the main class of each one (the one with the _@SpringBootApplication_ annotation), right click on the class and select _Run As > Java Application_. You will see the output in the _Console_ Tab of Eclipse.
Repeat the same operation in all the projects, a different _Console_ tab will show in Eclipse the output of each project.

### With bootified artifact
First create the bootified artifact (in each project) with the command

`C:\...\project> mvn clean package`

Repeat the same process in all the projects (eureka, zuul, config, auth, sampleApp1 and sampleApp2).

### Run the infrastructure with the bootified artifacts
Then in the _target_ directory you will find the just created _bootified_ artifact that can run in "stand alone" mode. Run the artifact with the command

`C:\...\project\target> java -jar [name-of-the-project]-bootified.jar`

Repeat the same process 

### Run several instances of a microservices
In the case of the microservices (sampleApp1 and sampleApp2) you can run multiple instances of each project (that will be automatically registered in Eureka) providing different server ports.

In the _target_ directory launch the command

`C:\...\the-project\target> java -jar -Dserver.port=[a-port-number] [project-name]-bootified.jar`

Example:

`C:\...\sampleapp1\target> java -jar -Dserver.port=9091 sampleapp1-bootified.jar`

This will run an instance of the sampleapp1 in the 9091 port.

You can repeat the same operation again with sampleapp1 or with sampleapp2.
