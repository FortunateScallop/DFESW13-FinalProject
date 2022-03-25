# QA-DFESW13 Final Project
## Contents

[Overview](https://github.com/FortunateScallop/DFESW13-FinalProject/tree/main#1-project-overview)

[CRUD Functions](https://github.com/FortunateScallop/DFESW13-FinalProject/tree/main#2-crud-functions)

[Testing](https://github.com/FortunateScallop/DFESW13-FinalProject/tree/main#3-testing)

[Data Persisting](https://github.com/FortunateScallop/DFESW13-FinalProject/tree/main#4-data-persisting)

[Running](https://github.com/FortunateScallop/DFESW13-FinalProject/tree/main#5-running)


## 1. Project Overview

### Why are we doing this?

The aims of this project were to gain practical experience with and demonstrate understanding of the tools learned over the past 9 weeks to create a working application.
These tools were Java, MySQL, Postman, Spring Boot API, Maven, JUnit, Jira/Trello, and draw.io.

This project is an attempt to satisfy the requirements of the QA Software Development bootcamp by creating a Java back-end for a that can create, read, update, and delete data from a database.
The project itself is aiming to be an MVP to manage a paid car park with a view to later automation.

My aim was to create the basic functionality first and look at more complex targets such as using a relational database for compelted sessions and time-stamping sessions when they are created and also ended.
The data persists on a local MySQL database.  H2 was used for testing.

### How I expected the challenge to go.

I expected that I had been provided with the tools and know-how to complete the project but anticipated challenges along the way.
The primary hurdles I expected were things such as gaps in knowledge and I suspected that time-stamping and the related database implementation would be something I would need to come back to.

### What went well? / What didn't go as planned?

I covered some of the stretch goals which I didn't expect to be able to achieve.
I've also been able to deliver an MVP that functions as intended but some of the project management aspects of this task I could have done better with.
Testing coverage was lower than 80% initially due to the minimal coverage of the testing of the carkparking model.  Finding and implementing a solution to that was a challenge.
Managing the project via Github/feature branches was something that I have not implemented to my own satisfaction as, while branching was used, it would have been more sensible to create a new branch for each feature.
The way that I have done it is by creating all core features on dev, all testing on test, and all documentation on a branch of the same name.
If I were to do this again I would create a branch for each feature.

### Possible improvements for future revisions of the project.

I may implement a basic front-end into this project in the future providing I learn how to do that first.
The remaining core-functionality I would like to implement would be a second, related database where completed/paid for sessions would me automatically moved to.
I would also like to add date started and date ended fields that would be time-stamped when a sessions is created and then when it is moved to the relationed database.
Moving to the database is something I'd like to have happen when the paid column = true.

Below is a diagram of the intended relationship between the car_parking and completed_sessions databases.

### Entity Relationship Diagram 
![Imgur](https://imgur.com/Rkb5xsK)

### User Stories

User stories are all able to be viewed on the Jira board for this project:

https://jbolt.atlassian.net/jira/software/projects/JDF/boards/2

### Risk Assessment 

![Risk](https://imgur.com/HsqQhUX)

### Git
  
Version control has been completed via Github using branches main, dev, test, and documentation.
This is not a perfect implementation of Git version control and in the future, due to lessons learned on this project, I would use new branches for every feature that is developed.

## 2. CRUD Functions
  
Postman was used to test the basic CRUD functionality of this project.  Data was added locally to a SQL database where the data persisted. 
  
### Create
  
This Postman request creates a new parking session and confirms that to the user:  
  
![create](https://imgur.com/llun0bb)
  
The data persists on the database thus:
  
![createpersist](https://imgur.com/JavkbUW)
  
### Read
  
These Postman requests read a specific session or all sessions:
  
Read by ID:
![readid](https://imgur.com/MPCwPWD)
  
Read All:
![readall](https://imgur.com/iOHkxv9)

### Update

This request will update a specific entry providing the user provides the ID of the entry they wish to update:
![update](https://imgur.com/lmq5Dm9)

Below is an example of the completed update request:
![update](https://imgur.com/z269uVj)

### Delete

The below functions will remove a chosen entry from the database or remove all entries depending on user preference:

Delete by ID:
![deletebyid](https://imgur.com/m7zaf9C)

Delete All:
![deleteall](https://imgur.com/wjQQB1p)
  
  
## 3. Testing

Please see below for the coverage of the tests written for this application:
![testing](https://imgur.com/RKXSQbw)
These tests include tests for Equals and Hashcode.  
## 4. Data Persisting

Examples of the data from the CRUD functions persisting on a locally hosted SQL databse are viewable in the Images folder.
H2 Database was used during testing and truncated before and after tests were run.

## 5. Running

A .jar file is available for download.