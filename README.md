# Code Quality with SonarQube on Windows
As a software developer it is a nightmare to deal with a low quality code. You spend a lot of time trying to understand the code and fixing it.
Good quality codes are readable, it has proper indentation, and it is simple. Notations and names are descriptive. And implementing changes to the new code, are not so hard. 
## What is  SonarQube?
SonarQube is used for code quality tool. It collects and analyze your souce code and creates reports about the code quality of the project. By the reports provided, developers are able to see the bugs, security issues and fix them before deploying to the production environment. 
With SonarQube the quality of code, can be measured continually over time.It is good for  detecting code complexity,reduces time and cost of maintenance, and helps developing readable codes.
It is an open-source framework. It is available for free under the GNU Lesser General Public License, but you should pay for the enterprise edition.
SonarQube is fully integrated with DevOps and can be alse used with Jenkins and gives support to langugaes, including C#, Java, Python, Php, Go, Ruby, Html, Javascript.

For more information please visit [SonarQube](https://www.sonarqube.org/) 



## SonarQube Setup for win 10
You can download SonarQube from [SonarQube-Download](https://www.sonarqube.org/downloads/). We will use the  community edition. By the time, we write this tutorial, SonarQube use Java version 11. So you have to download and install Java version 11. Also maven is needed to analyze our code. So our download list is as follows:
- jdk-11.0.13_windows-x64_bin.zip  
- apache-maven-3.8.4-bin.zip
- sonarqube-9.2.1.49989.zip

Extract the zip files to a directory and  set the environmental properties for windows.
<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/javahome.png"><br/>
  Setting Environment Variables JAVA_HOME
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/mavenhome.png"><br/>
  Setting Environment Variables MAVEN_HOME
</p>

And also please dont forget to add executables to **windows system path**. Check your java and maven version from the command prompt. If it is set correctly,
Find StartSonar.bat and execute it from SonarQube installation directory.
```
$ java -version
java version "11.0.13" 2021-10-19 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.13+10-LTS-370)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.13+10-LTS-370, mixed mode)

$  mvn -v
Apache Maven 3.8.4 (9b656c72d54e5bacbed989b64718c159fe39b537)
Maven home: D:\Apps\apache-maven-3.8.4-bin\apache-maven-3.8.4
Java version: 11.0.13, vendor: Oracle Corporation, runtime: D:\Apps\jdk-11.0.13_windows-x64_bin\jdk-11.0.13
Default locale: en_US, platform encoding: Cp1254
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

```

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonar1.png"><br/>
  StartSonar.bat from SonarQube installation directory
</p>

By default SonarQube runs on port 9000. To change the default port, we should edit conf/sonar.priperties file. We can change the port to XXXX, by modifiying the line
*sonar.web.port=9000*
When you go to link localhost:9000, you will see SonarQube's login page.
Default admin credentials are:

- Login: admin
 - Password: admin

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarlogin.png"><br/>
  SonarQube login page
</p>



For testing purposes, we have created a student springboot project. The project has an embedded h2 database. There are students and lectures as enities. We get the student names, by using rest services. Also some unit tests were added to the project. We created a utility class with some non-compliant code examples. Also some unused imports and classes are available.
But before this we have to modify our student project. We will be adding the following lines to our pom.xml file.

```
     <pluginManagement>
                <plugins>
                    <plugin>
                        <groupId>org.sonarsource.scanner.maven</groupId>
                        <artifactId>sonar-maven-plugin</artifactId>
                        <version>3.4.0.905</version>
                    </plugin>
                </plugins>
            </pluginManagement>
```            

Now we are ready to create a new project from the SonarQube web page that runs on our localhost.


<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro1.png"><br/>
  SonarQube creating a project manually
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro2.png"><br/>
  SonarQube creating a display name and a project ke
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro3.png"><br/>
  SonarQube analyzing repository locally
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro5.png"><br/>
  SonarQube providing a token
</p>


<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro6.png"><br/>
  SonarQube executing scanner maven code
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro8.png"><br/>
  SonarQube overallcode analyze
</p>

Now we are ready to open the command prompt as an administrator. Paste and execute the code . It will be analayzed and reports will be available for us  from SonarQube's web interface. When the execution finishes successfully, open http://localhost:9000/projects link. You will see the project name and the summary of analyzes. From the web interface, we will be able to see some categories, related with our student project. The categories can be listed as Bugs, Vulnerabilities, Security Hotspots, and Code Smells. Click on the project to explore more details.

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro9.png"><br/>
  SonarQube detected bug
</p>

When the bugs menu is clicked you will see a bug as we used Optional with null. And also it gives a description about the bug when we click on *Why is this an issue*  we see the following message.

*The concept of Optional is that it will be used when null could cause errors. In a way, it replaces null, and when Optional is in use, there should never be a question of returning or receiving null from a call.*

``` 
 @Override
    public Optional<Lecture> findLectureById(Long id){
        Optional<Lecture> lecture=lectureRepository.findById(id);
        if(lecture==null) throw new LectureNotFoundException();
      ...
```
<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro11.png"><br/>
  SonarQube detected bug
</p>
Another hint for the String.format method  

*When the call to a function doesn’t have any side effects, what is the point of making the call if the results are ignored?*

We know bugs an security hotspots. Vulnerabilities are the weak parts of our code, potentially an attacker can use them. Code smells are not bugs. They point out the weak design issues. Comments, duplicates, dead code are some examples for code smells. These reports are very useful, for the software developers.
We have also created 5 unit tests and when we clicked on unit tests there is a warning about our public identifiers. It says that our code is noncompliant.

*JUnit4 which required everything to be public whereas in JUnit5 we don't have to use public as it will be more readable when it is not used*

``` 
Non Compliant Code
 @Test
    public void testHello() throws Exception {
   // ...
    @Test
    public void testHello2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/MySpringBootWeb/hello"))
  //  ...
Compliant Solution

  @Test
  void testHello() {
    // ...
  
}
    
``` 
The Quality Gate lets us know if your project is ready for production. Code Coverage is determining how much code is being tested. It helps to measure the quality of  tests. Our analyze  has a coverage of 140 lines. According to our analyzes we have also 6 Security Hotspots to review.


<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonarpro12.png"><br/>
  SonarQube Security Hotspots
</p>

And 4 of the issues are about Cross-Site Request Forgery (CSRF).
``` 
Non Compliant
@RequestMapping("/lectures/{id}")
//...
@RequestMapping("/delete_user", method = RequestMethod.POST)  // Compliant
//...
``` 

Last notes about SonarQube: 
- For memory management issues  change  the conf/sonar.properties file.
- Check the rules according to languages from rules menu.
- You can check extra plugins from Administration, Marketting menu.
- If you get an error *Could not create the Java Virtual Machine*. There is a problem with your java version  thats why we used version Java 11 .




