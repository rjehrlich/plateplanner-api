# Plate Planner API

## Table of Contents
* <a href="README.md#project-description"> Project Description</a>
* <a href="README.md#tools--technologies"> Tools & Technologies</a>
* <a href="README.md#project-planning-process"> Project Planning Process</a>
* <a href="README.md#hurdles"> Hurdles</a>
* <a href="README.md#installation-instructions-dependencies"> Installation Instructions/ Dependencies</a>
* <a href="README.md#credits"> Credits</a>

---
## Project Description
Plate Planner API aims to provide data 

## Tools & Technologies
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
- ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
- ![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
- ![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
- **Postman** - testing DB requests
- [Markdown Table Generator](https://www.tablesgenerator.com/markdown_tables)
- [ERD Tool](https://www.lucidchart.com/)
- [Wireframe Tool](https://www.figma.com/)

## Project Planning Process
As a group we came together and decided our overall project process would consist of four important pieces. Planning our project in these 4 steps helped us keep on track of our to-do's and requirements.

We planned out the following in each of the four areas:

### User Stories
* As a User, I want to create a profile so that I can save my personal information and preferences
* As a User, I want to be able to view and edit my profile information, including my name, email address, and password.
* As a User, I want to be able to view and save products in my profile.
* As a User, I want to be able to delete out of season products.
#### Nice to have in the future:
* As a user, I want to be able to add products to my cart and checkout securely.
* As a user, I want to receive email notifications about my order status and shipping updates.

### ERD Diagram
![ERD Diagram](images/plannerERD.png)

### Endpoint Mappings

#### Recipe, Ingredient, and RecipeIngredient Controllers
| HTTP Methods 	| Full URL                                                            	|                       URL                      	|                Functionally                	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
|--------------	|---------------------------------------------------------------------	|:----------------------------------------------:	|:------------------------------------------:	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|---	|
| GET          	| http://localhost:8080/api/recipes                                   	| /recipes                                       	| Get all recipes                            	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/recipes/{recipeId}                            	| /recipes/{recipeId}                            	| Get a recipe by id                         	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/ingredients                                   	| /ingredients                                   	| Get all ingredients                        	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/ingredients/{ingredientId}                    	| /ingredients/{ingredientId}                    	| Get an ingredient by id                    	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/recipes/{recipeId}/ingredients                	| /recipes/{recipeId}/ingredients                	| Get all ingredients for a recipe by id     	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/recipes/{recipeId}/ingredients/{ingredientId} 	| /recipes/{recipeId}/ingredients/{ingredientId} 	| Get an ingredient by id for a recipe by id 	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|
| GET          	| http://localhost:8080/grocery-lists                                 	| /grocery-lists                                 	| Get grocerylist from recipes               	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|   	|

--------
### Kanban Project Plan
![kanban board](/images/projectplan.png)

[Project Plan Link](https://github.com/users/rjehrlich/projects/5)

## Hurdles
One of 

## Installation Instructions/ Dependencies

In order to use this codebase you will need to make sure you have the following dependencies in your pom.xml file:

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-rest</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>${cucumber.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>${cucumber.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-spring</artifactId>
        <version>${cucumber.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.3.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>3.0.5</version>
    </dependency>
</dependencies>
```
In order to successfully replicate/ run Cucumber Tests you will need to add this property to your pom.xml property tag:

``<cucumber.version>6.8.1</cucumber.version>``

## Credits
* Referred back to Java Spring Boot Lesson for explanations: https://git.generalassemb.ly/sureshmelvinsigera/Java-Spring-Boot-lecture/tree/spring-2-7-8
* [JAVA API](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)
* [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
* **Team C**: Lorena, Maksym, and Edgar
    * For helping us out with Spring Security and JWT testing.
* **Team F**: Trevor, Tobe, and Dominique
    * For helping with git branches and general questions we had throughout implementation.
* **Suresh**
    * Our instructor for helping us throughout our learning journey and being patient debugging issues with us!