package com.leafchild0.microservices.springboot.resources;

import com.leafchild0.microservices.springboot.data.BackendDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author victor
 * @date 11/27/17
 */
@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="greeting")
public class GreetingController {
	
	private String saying;
	private String backendServiceHost;
	private int backendServicePort;
	private RestTemplate template = new RestTemplate();
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "text/plain")
	public String greeting(){
		
		String backendServiceUrl = String.format("http://%s:%d/api/backend?greeting={greeting}",
				backendServiceHost, backendServicePort);
		
		BackendDTO response = template.getForObject( backendServiceUrl, BackendDTO.class, saying);
		
		return response.getGreeting() + " at host: " + response.getIp();
	}
	
	public String getSaying() {
		
		return saying;
	}
	
	public void setSaying(String saying) {
		
		this.saying = saying;
	}
	
	public String getBackendServiceHost() {
		
		return backendServiceHost;
	}
	
	public void setBackendServiceHost(String backendServiceHost) {
		
		this.backendServiceHost = backendServiceHost;
	}
	
	public int getBackendServicePort() {
		
		return backendServicePort;
	}
	
	public void setBackendServicePort(int backendServicePort) {
		
		this.backendServicePort = backendServicePort;
	}
}
