Run from command line:
* for test pass: mvn -Dbrowser=chrome -Denvironment=task -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml clean test
* for test fail: mvn -Dbrowser=chrome -Denvironment=changed -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml clean test