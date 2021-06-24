# Software Engineering in Practice Assignments 
[![Build Status](https://travis-ci.com/nataliaKat/Software-Engineering-in-Practice-Assignments.svg?token=iY1fJBpUxUyzkKBhyQE6&branch=development)](https://travis-ci.com/nataliaKat/Software-Engineering-in-Practice-Assignments)

## Description

This project was developed as part of the 6th semester's <i>Software Engineering in Practice</i> course.
It consists of 2 submodules:
 * [Grades Histogram](https://github.com/nataliaKat/Software-Engineering-in-Practice-Assignments/tree/main/gradeshistogram)
 * [Unit Testing & Continuous Integration](https://github.com/nataliaKat/Software-Engineering-in-Practice-Assignments/tree/development/unittesting)
 * [Source Code Analyzer](https://github.com/nataliaKat/Software-Engineering-in-Practice-Assignments/tree/development/sourcecodeanalyzer)

## Getting Started

These instructions will give you a copy of the project up and running on
your local machine.

### Prerequisites

Requirements for the software and other tools to build.
- [JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) (or higher)
- [Maven](https://maven.apache.org/)

### Installing

After cloning the project, you can build it using Maven.

    mvn clean install jacoco:report

jacoco:report will create some HTML pages indicating each submodule's test coverage. It can be found in 
<code>target/site/jacoco</code>.

## Running

Instructions for running each submodule can be found in its module's README.md file.
