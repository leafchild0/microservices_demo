package com.leafchild0.microservices.dropwizard;

import com.leafchild0.microservices.dropwizard.resources.GreeterRestResource;
import com.leafchild0.microservices.dropwizard.resources.GreeterSayingFactory;
import com.leafchild0.microservices.dropwizard.resources.HelloRestResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

/**
 * @author victor
 * @date 11/27/17
 */
public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {
	
	public static void main(final String[] args) throws Exception {
		
		new HelloDropwizardApplication().run(args);
	}
	
	@Override
	public String getName() {
		
		return "HelloDropwizard";
	}
	
	@Override
	public void initialize(final Bootstrap<HelloDropwizardConfiguration> bootstrap) {
		// Enable variable substitution with environment variables
		bootstrap.setConfigurationSourceProvider(
			new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(),
				new EnvironmentVariableSubstitutor(false)
			)
		);
	}
	
	@Override
	public void run(final HelloDropwizardConfiguration configuration,
		final Environment environment) {
		
		// register   hello service
		environment.jersey().register(new HelloRestResource(configuration.getSayingFactory().getSaying()));
		
		// greeter service
		GreeterSayingFactory greeterSayingFactory = configuration.getGreeterSayingFactory();
		Client greeterClient = new JerseyClientBuilder(environment)
			.using(greeterSayingFactory.getJerseyClientConfig())
			.build("greeterClient");
		
		environment.jersey().register(new GreeterRestResource(greeterSayingFactory.getSaying(),
			greeterSayingFactory.getHost(),
			greeterSayingFactory.getPort(), greeterClient));
	}
}
