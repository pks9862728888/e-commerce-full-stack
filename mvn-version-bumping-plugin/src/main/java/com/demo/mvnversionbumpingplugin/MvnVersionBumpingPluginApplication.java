package com.demo.mvnversionbumpingplugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Mojo(name = "bumpAndTag", defaultPhase = LifecyclePhase.COMPILE)
@SpringBootApplication
@Slf4j
public class MvnVersionBumpingPluginApplication extends AbstractMojo {

	@Parameter(defaultValue = "${project}", required = true, readonly = true)
	private MavenProject mavenProject;

	public static void main(String[] args) {
		SpringApplication.run(MvnVersionBumpingPluginApplication.class, args);
	}

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		log.info("{}", mavenProject.getVersion());
	}
}
