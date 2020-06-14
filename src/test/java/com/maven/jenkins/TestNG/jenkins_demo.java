package com.maven.jenkins.TestNG;

public class jenkins_demo {
	
	/* CI or CICD: tool continuous integration continuous deployment tool
	 * it will build whole project and deploy
	 * it generates report
	 * send emails
	 * schedule jobs on required time
	 * it can be generated with maven and git
	 * task scheduler (periodically)...schedule our jobs for execution and trigger the tasks at given time
	 * test cases we write will be executed 
	 * once executed and reports generated and email notification happens
	 * Good support  with version control (svn, git) and build tool(maven , ANT)
	 * 
	 * https://www.jenkins.io/download/thank-you-downloading-windows-installer-stable/
	 * download windows installer package or generic java package (.war)
	 * downlaod jenkins.war to a folder and run cmd from that location 
	 * enter >java -jar jenkins.war
	 * it will run the jenkins server on port 8080 (default port)   
	 *  if port 8080 is occupied, >java -jar jenkins.war --httpPort=9090 (8181 user-defined port)
	 * In cmd, is Jenkins is fully up and running only then jenkins server will run on port http://localhost:8080/login?from=%2F will be running
	 * gmail smtp server details
	 *  
	 *  //what is jenkins? 
	//Continuous integration and Continuous deployment tool CICD
	//combining multiple modules together
	/*Scenario:
	developer will write and commit code -->
		-->git
		-->build and deploy it on the server -->DEV
		you required one human effort everytime to do this. Same steps he need to repeat
		Available in Dev
	
	Tester should run his tests on developer build
	Assumes latest code is available in Dev
	--> He will pull the latest code from GIT
	--> He will choose the suite / time interval
	-->he has to run this on the environment -> Dev
	--> Result should be published to the stake holders
	
	clubbing all the tasks in one platform and manage however we want it
	Jenkins 
	it can have an access to your command prompt or Terminal
	if you can able to run your suite on the command line then jenkins will do the rest
	you have to give set of commands or actions to jenkins
	
	-- will not point the action on eclipse
	
	running the suite.xml file using maven command
	we can also compile and run .java file using regualr javac jenkins_demo.java and java filename 
	
	install maven on your machine 
	with the maven command you have to run suite.xml
	in pom.xml file parameterizing the suite.xml file---> we gave <suiteXmlFiles>
						<!-- <file>src/suite/${suiteXmlFile}</file> -->
						<file>${suiteXmlFile}</file>
						</suiteXmlFiles> 
	${suiteXmlFile} as parameter if run an suite.Xml file 
	we must a give folder structure if suite.xml file is maintained under any folder structure like src/suite
					
	on command prompt: if I give 
	project leavel >mvn clean, it will clean all the binary files of the project in target/classes and test-classes folder.
	
	project level>>mvn clean install will clean all the binaries and compile source files again into the binary/classes files in the target folder  

	but throws as surefire plugin is for testNG xmlfile to run , since we have to specify suiteXmlFile 
	as paramater in the mvn command line to run the testng suite.xml file using maven command line.
	Using Suite XML Files:
	use TestNG suite XML files. This allows flexible configuration of the tests to be run. 
	These files are created in the normal way, and then added to the Surefire Plugin configuration:
	This configuration will override the includes and excludes patterns and run all tests in the suite files.
	surefire plugin configurations let us define which tests to execute when we run the maven build. 
	When we have a large project with many test cases, then it comes handy to configure only specific test suites for execution.
 	<configuration>
          <suiteXmlFiles>
            <suiteXmlFile>testng.xml</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
        
	project level>>mvn clean install -DsuiteXmlFile=sanity.xml
	will clean and compile all source files to binary/class files into target folder(classes and test-classes folder)
	from command line also, using maven clean compile, test, 
	install commands we can order the test cases in each suite in a such a way to run and execute.
	
	1. Creating project -->freestyle or maven
	2. Setting up the workspace
	3. Git credentials with repository, Branch
	4. Build periodically
	5. Build --> Execute windows batch command
	
	upstream 
	downstream
	
	TestNgRegression --> setup downstream as TestNGSanity
	
	TestNGSanity --> upstream as TestNgRegression
	
	 *  
	 *  
	 *  
	 * 
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  


*/}
