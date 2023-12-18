package com.example.gateway;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
	
	@Value("${server.ssl.key-store}")
	private String keyStore;

	@Value("${server.ssl.key-store-password}")
	private String keyStorePassword;

	@Value("${trust.store}")
	private String trustStore;

	@Value("${trust.store.password}")
	private String trustStorePassword;

	@Value("${server.ssl.key-alias}")
	private String sslAlias;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Bean
	public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
		DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", Paths.get(keyStore).toString());
		System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
		System.setProperty("javax.net.ssl.trustStore", Paths.get(trustStore).toString());
		System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName(sslAlias);
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}

}
