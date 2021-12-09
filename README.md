# CodeQuality
## What is  SonarQube?
SonarQube is used for code quality tool. It collects and analyze your souce code and creates report 
about code quality of the project. By the reports provided developers are able to see the bugs security issues and fix them before deploying to the production environment.
And the quality of code can be measured continually over time.It is good for  detecting code complexity, time and cost of maintenance, and developing readable codes.
It is an open-source framework It is available for free under the GNU Lesser General Public License but you should pay for the enterprise edition. For generating pdf reports enterprise version is used.
SonarQube is fully integrated with DevOps and can be alse used with Jenkins.



## SonarQube Setup for win 10
You can download SonarQube from [SonarQube-Download](https://www.sonarqube.org/downloads/) We will use the  community edition.By the time, we write this tutorial SonarQube uses JDK version 11. So you have to download and install JDK version 11, if you dont have it installed. Also maven is needed to analyse our code. So our  
download list is:
- jdk-11.0.13_windows-x64_bin.zip  
- apache-maven-3.8.4-bin.zip
- sonarqube-9.2.1.49989.zip
Extract the zip files to a directory and set path properties for windows.
<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/javahome.png"><br/>
  Setting Environment Variables JAVA_HOME
</p>

<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/mavenhome.png"><br/>
  Setting Environment Variables MAVEN_HOME
</p>

And also please dont forget to add executables the folders to windows system path. Check your java and maven version from the command prompt. If it is set correctly then 
From SonarQube installation directory, find StartSonar.bat and execute it.
<p align="center">
  <img  src="https://github.com/okansungur/CodeQuality/blob/main/images/sonar1.png"><br/>
  StartSonar.bat from SonarQube installation directory
</p>






For test purposes, we have created a student springboot project.We will be using this project and SonarQube will analyze our code.
But before this we have to modify our student project. We will be adding the following lines to our pom.xml

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


??sonar.issuesReport.html.enable=true
h2 database init will auto create 
mvn projesine dependency 
go to  pom.xml ans run 

After our analyses form the web interface we will be able to see some categories related with our project
The categories can be listed as Bugs, Vulnerabilities, Security Hotspots, and Code Smells.
Overall Code screen there are some measurements such as bugs,Vulnerabilities, Security Hotspots .Vulnerabilities, Code smells .
We know bugs an security hotspots. Vulnerabilities are the weak parts of your code potentially an attacker can use them.Code smells are not bugs. They point out the weak design issues.

