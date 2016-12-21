package org.truetraining;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class Launcher {

	public static void main(String[] args) throws UnknownHostException {

		ConfigurableApplicationContext run = SpringApplication.run(Launcher.class, args);
		Environment env = run.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://127.0.0.1:{}{}\n\t" +
						"External: \thttp://{}:{}{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				env.getProperty("server.context-path"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getProperty("server.context-path"));
		log.debug("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));

	}
}
