# Log4Shell (Apache Log4j Security Vulnerabilities)

This repository contains a Spring Boot web application vulnerable to CVE-2021-44228, nicknamed Log4Shell.

## Running the application

Run it:
```
gradlew build
docker build . -t log4shell-app
docker run -p 8080:8080 log4shell-app
```

## How to request

This application can be checked for vulnerabilities in log4j (1.2.17) and log4j2 (2.6.1) versions respectively.

- ### log4j(1.2.17)
```
curl -X POST -d 'p=${java:version}' localhost:8080/v1
```
The following is output to the application log

<pre>
log4j ${java:version}
log4j Parameter[param=${java:version}]
</pre>

- ### log4j2(2.6.1)
```
curl -X POST -d 'p=${java:version}' localhost:8080/v2
```
The following is output to the application log

<pre>
log4j2 Java version 11.0.12
log4j2 Parameter[param=Java version 11.0.12]
</pre>

***The "java -version" has been executed.***

## What's the problem?

As you can see from the above results, in the case of log4j2, when outputting strings to the log, the specified process is executed. This is a serious bug. At the very least, the "ldap" or "java" command will be executed, and depending on the contents, it can cause serious damage. This should be addressed as soon as possible.

## How to resolve?

***Version Up***

```
ext['log4j2.version'] = '2.15.0'

dependencies {
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.15.0"))
}
```
***SEE build_resoleved.gradle***

*There are other options, of course. However, you should always keep the library you are using up to date.

## Running the bug fixed application

```
gradlew build -b build_resoleved.gradle
docker build . -t log4shell-app
docker run -p 8080:8080 log4shell-app
```
- ### log4j2(2.15.0)
```
curl -X POST -d 'p=${java:version}' localhost:8080/v2
```
The following is output to the application log

<pre>
log4j2 ${java:version}
log4j2 Parameter[param=${java:version}]
</pre>
