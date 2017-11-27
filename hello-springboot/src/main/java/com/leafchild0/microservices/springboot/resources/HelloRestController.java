package com.leafchild0.microservices.springboot.resources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author victor
 * @date 11/27/17
 */
@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="helloapp")
public class HelloRestController {
	
	private String saying;
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "text/plain")
	public String hello() throws UnknownHostException {
		
		String hostname;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return "Hello from Spring Boot " + hostname;
	}
	
	public String getSaying() { return saying; }
	
	public void setSaying(String saying) { this.saying = saying; }
	
}
