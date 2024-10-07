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
4. Under the "Basic List View" folder, there is a ```TopFiveDestinationList.java``` file. Click on it, and hit run. 

![This is what you should see!](Basic%20List%20View%20Control/src/resources/javasitescreenshot.png)

## Enhancement

For the enhancement, though my initial plan was to just stick an API into my project, I decided to apply a little more thought. Given the circumstances (that Java is not usually used for web development), I wanted to use the opportunity to practice some web development. In line with Enhancement Three's database requirement, I created an API that holds a number of destinations, countries, links and descriptions. This API can be found [here](https://github.com/functionfaiecho/CountryAPI).


