# TCI-group4
This project is about testing and continuous integration of group 4 - Crawl Site

## How to run it
1. Download or clone this repository
2. Go to the src, main, java folder
3. Then choose the executable file: WCA_Main
4. Before you run it, make sure you have the website from the tci given folder
5. The website needs to be running, if you are using xampp, wampp make sure they are running and the website is accesible
6. Enjoy scraping through the CLI

## How to test it
1. Download or clone this repository
2. Go to the src, main, test folder
3. Before you run the test, make sure you have the website from the tci given folder
4. The website needs to be running, if you are using xampp, wampp make sure they are running and the website is accesible
5. Execute the test

## Attention
This project is using Travis-CI as a part of Continuous Integration and Deployment. Travis-CI is hosted in the github and they don't have an access to the website or any connection. Most build that requires connection to the website will fail with travis-ci. Other test cases that doesn't involved website connection nor communication will normally fine and passed the build. Therefore don't get surprise if the build is failed. 