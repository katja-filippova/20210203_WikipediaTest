# 20210203_WikipediaTest
Mobile application test for Wikipedia application using Android emulator and Appium test automation tool. 
The project logic is based on Value Object pattern, which you can find in the app package.
The test logic is implemented using TestNG Framework. In tests class you will find several implementations for finding a needed article and putting it in your favourites list.

# To run the project a user should do:
1. start Appium server;
2. find and open in command line your android emulator:
```bash
emulator -list-avds
```
```bash
emulator @name_of_your_emulator
```
3. use Intellij IDEA to run the project or use command line:
```bash
gradle name_of_your_test_suite
```
(from your build.gradle file) 
