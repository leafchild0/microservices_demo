package com.leafchild0.microservices.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author victor
 * @date 11/27/17
 */
@Path("/api")
public class HelloRestResource {
	
	private String saying;
	
	public HelloRestResource(final String saying) {
		
		this.saying = saying;
	}
	
	@Path("/hello")
	@GET
	@Timed
	public String hello() throws UnknownHostException {
		
		String hostname;
		
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return saying + " " + hostname;
	}
}
