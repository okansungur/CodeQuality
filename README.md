# CodeQuality
## What is  SonarQube?
SonarQube is used for code quality tool. It collects and analyze your souce code and creates report 
about code quality of the project. By the reports provided developers are able to see the bugs security issues and fix them before deploying to the production environment.
And the quality of code can be measured continually over time.It is good for  detecting code complexity, time and cost of maintenance, and developing readable codes.
It is an open-source framework It is available for free under the GNU Lesser General Public License but you should pay for the enterprise edition. For generating pdf reports enterprise version is used.

SonarQube architecture consists the components
- Sonar Scanner
- Source Code
- Sonar Analyzer
- SonarQube Database



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
