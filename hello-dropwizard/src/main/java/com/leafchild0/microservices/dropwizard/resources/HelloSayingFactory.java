package com.leafchild0.microservices.dropwizard.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author victor
 * @date 11/27/17
 */
public class HelloSayingFactory {
	
	@NotEmpty
	private String saying;
	
	@JsonProperty
	public String getSaying() {
		return saying;
	}
	
	@JsonProperty
	public void setSaying(String saying) {
		this.saying = saying;
	}
}
