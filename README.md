# Vishnu/Selenium_Project

##Description

This is Selenium 2 framework created using the latest Selenium 2 features with Java, TestNG and Maven and soon Iam gonna add some new technologies like ReportNG and Google Guice dependency injection framework.This repository is open to use as you want and mainly for those people who want to automate the web apps using Selenium 2 but needs some help to get Started. So when you use it don't forget to leave your comments and you can also report an issue/requests/ enhancements if you like, we will definitely look into that and provide the solution
##Features

    - PageObjects with LoadableComponent design Pattern [ http://code.google.com/p/selenium/wiki/DesignPatterns ]
    - Object oriented Architecture
    - Rich TestNG test framework support [ http://testng.org/doc/index.html ]
    - Maven Support - Software project management and comprehension tool [ http://maven.apache.org/ ]
    - Support execution on latest firefox and Google Chrome and Internet Explorer browsers [windows only]

##Test Application

I have used functionally rich and well known Facebook as test application, so it would be easier to understand the framework and then implement the same for your project as per your requirements.


##Prerequisites Software/Tools

    - Git [ http://git-scm.com/downloads ]
    - Maven [ http://maven.apache.org/ ]
    - Java Development Kit 7
    - Java Runtime Environment 7
    - IDE [ I prefer IntelliJ IDEA for development :) ]

##Getting Started [ On Windows ]

    - Open the Git bash and clone the project using below command on the target directory: git clone https://github.com/lalit-k/selenium-java-tests.git
    - Once the project is cloned successfully go the the project directory and set the facebook user name and password values in testng-facebook.xml as:
    - Open the windows command prompt 'cmd' and navigate to the project directory 'selenium-webdriver-tests'.
    - Run the below command to start the tests. mvn clean test
