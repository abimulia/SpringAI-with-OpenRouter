# Spring Boot + Spring AI + OpenRouter  

[![Spring Boot v3.5.4](https://img.shields.io/badge/Java-SpringBoot-green)](https://spring.io/)
[![Spring AI 1.0.1](http://img.shields.io/:AI-SpringAI-orange.svg)](https://docs.spring.io/spring-ai/reference/index.html)
[![OpenRouter](http://img.shields.io/:LLM-OpenRouter-brown.svg)](https://openrouter.ai/)
[![License](http://img.shields.io/:license-Apache-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

Steps:  
* Get API Key, go to OpenRouter.ai and create API Key  
<img width="1920" height="1034" alt="Image" src="https://github.com/user-attachments/assets/f995091a-8e57-4b88-82b9-1a960cd76c43" />

* Set API Key and the model in application.yml
* Run mvn spring-boot:run  
<img width="1158" height="736" alt="Image" src="https://github.com/user-attachments/assets/9e8249a8-948c-4e0a-bbfd-d9a081462bfc" />

* Test request to http://localhost:8080/api/ai/ask
```
curl.exe -G "http://localhost:8080/api/ai/ask" --data-urlencode "question=Halo, jelaskan Spring AI singkat."
```
<img width="1573" height="897" alt="Image" src="https://github.com/user-attachments/assets/49eb33f9-4731-437d-84ef-4b0a343e50cc" />



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.4/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.4/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.5.4/reference/using/devtools.html)
* [OpenAI](https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.4/reference/web/servlet.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.5.4/reference/web/reactive.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.  

Starting JDK 21 maven.compiler.proc must be set
```
<maven.compiler.proc>full</maven.compiler.proc>
```  
> full is the default. Starting with JDK 21, this option must be set explicitly.

