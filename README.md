# Microservices demo

Super simple example of 3 projects, designed with SOA in mind. This is what people calls really simple microservices
**backend** module will serve as a backend for two other modules developed using **spring-boot** and **dropwizard**.
Those two frameworks works very well for services architecture, but they are developed to achieve different things. 

Use maven to install each module separately. Use jetty to run a jetty server with backend. Dropwizard uses it's own way to start an up, but the server is also jetty.
For the Spring boot, just run the main class. It uses Tomcat.

Good luck and enjoy microservices.
