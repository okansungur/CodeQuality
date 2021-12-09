# CodeQuality
## What is  SonarQube?
SonarQube is used for code quality tool. It collects and analyze your souce code and creates report 
about code quality of the project. By the reports provided developers are able to see the bugs security issues and fix them before deploying to the production environment.
And the quality of code can be measured continually over time.It is good for  detecting code complexity, time and cost of maintenance, and developing readable codes.
It is an open-source framework It is available for free under the GNU Lesser General Public License but you should pay for the enterprise edition. For generating pdf reports enterprise version is used.
SonarQube is fully integrated with DevOps and can be alse used with Jenkins.



## SonarQube Setup for win 10
To download [SonarQube](https://www.sonarqube.org/downloads/)
sonarqube jdk 11 
Set Maven_Home, Java_Home




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

