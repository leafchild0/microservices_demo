package com.leafchild0.microservices.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.leafchild0.microservices.dropwizard.resources.GreeterSayingFactory;
import com.leafchild0.microservices.dropwizard.resources.HelloSayingFactory;
import io.dropwizard.Configuration;

/**
 * @author victor
 * @date 11/27/17
 */
public class HelloDropwizardConfiguration extends Configuration {
	
	private HelloSayingFactory sayingFactory;
	private GreeterSayingFactory greeterSayingFactory;
	
	@JsonProperty("helloapp")
	public HelloSayingFactory getSayingFactory() {
		
		return sayingFactory;
	}
	
	@JsonProperty("helloapp")
	public void setSayingFactory(HelloSayingFactory sayingFactory) {
		
		this.sayingFactory = sayingFactory;
	}
	
	@JsonProperty("greeter")
	public GreeterSayingFactory getGreeterSayingFactory() {
		
		return greeterSayingFactory;
	}
	
	@JsonProperty("greeter")
	public void setGreeterSayingFactory(GreeterSayingFactory greeterSayingFactory) {
		
		this.greeterSayingFactory = greeterSayingFactory;
	}
}
