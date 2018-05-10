# Spring-boot-security-oathu2-jwt

This project is adopted from [angular-spring-starter](https://github.com/bfwg/angular-spring-starter).

* Gradle tool is used in this project instead of the maven used in the original project.
* The joda-time dependency is removed from the original project. **FixedClockService** is introduced 
  to replace the joda's DataTimeUtils.setCurrentMillisFixed. The **FixedClockSertice** is simple, 
  portable and elegant to test the fixed data.
* All the warnings are fixed and removed.   

 

