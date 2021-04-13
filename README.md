# Software Engineering in Practice Assignments

The aim of this project is to create a grades' histogram using [JFreeChart](https://www.jfree.org/jfreechart/) Java library.

## Getting Started

These instructions will give you a copy of the project up and running on
your local machine.

### Prerequisites

Requirements for the software and other tools to build.
- [JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/)

### Installing

You can just build the project using Maven.

    mvn install

### Running

After installation you should be able to run the histogram generator with:

    java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <grades-file>

where grades-file is a file that contains the grades in the following form:

    10
    9
    8.7
    ...
