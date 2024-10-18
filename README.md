# CS-250: Software Development Life Cycle

The Top Five Destination List is a Java Swing application that showcases a curated list of top travel destinations. This project was created whilst learning about the Software Development Life Cycle (SDLC). The application displays destinations with images and descriptions, allowing users to click on each destination to open a related travel website in their default browser. Each destination will display an image, description and provide a link to a related travel website. This project was developed as part of learning about the Software Development Lifecycle (CS250).

## Table of Contents

- [How To Run](#how-to-run)
    - [Original version](#original---java)
    - [Enhancement](#enhancement)


### How To Run

There are two versions of this project that you may choose to run. One is the original project, which was created in Java, and the second one is an enhancement created under Enhancement Three: Databases for CS 499 (Computer Science Capstone).

#### Original - Java

1. Ensure that you have Java (JDK) installed. If not, download it from [here](https://www.oracle.com/java/technologies/downloads/#java11).

2. Install the Java Extension Pack in Visual Studio Code.

3. Clone the repository 
```bash
git clone https://github.com/functionfaiecho/CS-250-Software-Development-Lifecycle-Java-Website
```
4. Within ```CS-250-Software-Development-Lifecycle-Java-Website``` and the "Basic List View" folder, there is a ```TopFiveDestinationList.java``` file. Click on it, and hit run. 

![This is what you should see!](Basic%20List%20View%20Control/src/resources/javasitescreenshot.png)

## Enhancement

In line with Enhancement Three's database requirement, I created an API that holds a number of destinations, countries, links and descriptions. This API can be found [here](https://github.com/functionfaiecho/CountryAPI), and the documentation may be read [here](https://countriesapi.crabcakes.dev). The database related to this FastAPI is in MongoDB.

I chose to use MongoDB for a number of different reasons. Firstly, MongoDB offers schema flexibility. Given that the data related to destinations and countries can vary over time (such as the addition of new destinations or changes in descriptions), MongoDB's dynamic schema allows for easy updates without requiring migrations or major changes to the database structure.

Secondly, MongoDB stores data in a document-oriented format, which aligns well with FastAPI's JSON-based request and response handling. This allows for efficient, seamless data flow between the API and the database without needing to convert data formats extensively.

In addition, FastAPI's asynchronous capabilities work well with MongoDB’s motor driver, which allows for non-blocking database operations. This is particularly useful when the API is handling multiple requests concurrently, ensuring that the user experience remains fast and responsive.
MongoDB’s community support and ecosystem make it easier to integrate additional features in the future, should the API need enhancements or new functionalities.

I have also incorporated this API into a Single-Page Application (SPA) that resembles the one created in Java. To run it, ensure that you have Docker installed on your computer, then:

1. Navigate to ```enhancedjava``` as such:

```bash
cd EnhancedSite/enhancedjava
```

2. Once in the folder, run 
```bash
docker-compose up --build
```

The app will run on ```localhost:3000```.
