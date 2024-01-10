# Rent a Car - Jakarta EE

# Introduction

This application intends to be an example of a Jakarta EE to help those who wants to create one.

 It uses a basic Layer architecture which consists on main three layers
 
    1 - Resource
    2 - Service
    3 - DAO (Data Access Object)

### Resource

The first one is responsible to receive the requests, validate the received information and pass
it to the service layer.

### Service

This one is to receive the data sent from the resource and do business logic.

### DAO (Data Access Object)

Finally one, is about to connect with the database to perform it.

# Important

If you are new on Jakarta and intend to play with this application, don't forget to install
docker on your machine to have the database running instantly. On the root there is 
`docker-compose.yml` file to help you. Also in the `resources` folder you have an sql file
that helps you on creating the table and some data.

If you add a new entity, you must mention it on the `persistence.xml` in the tag `<class>` 
like the existing one.

# That's it

Keep in mind that it is a work in progress!