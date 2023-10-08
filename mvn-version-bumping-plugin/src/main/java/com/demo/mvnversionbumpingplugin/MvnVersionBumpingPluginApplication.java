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

import java.util.Optional;

@Mojo(name = "bumpAndTag", defaultPhase = LifecyclePhase.COMPILE)
@SpringBootApplication
@Slf4j
public class MvnVersionBumpingPluginApplication extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject mavenProject;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("Current version: {}", mavenProject.getVersion());
        ConfigurableApplicationContext context = SpringApplication.run(MvnVersionBumpingPluginApplication.class);
        VersionBumpingService versionBumpingService = context.getBean(VersionBumpingService.class);

        // Get bumped version else exit
        Optional<String> bumpedVersion = versionBumpingService.getBumpedVersionIfPossible(mavenProject.getVersion());
        if (bumpedVersion.isEmpty()) {
            log.error("Exiting since Version: {} did not match with any of the known versioning patterns!",
                    mavenProject.getVersion());
            System.exit(1);
        }

        // Update version of repo
        log.info("Updating version in repo to: {}", bumpedVersion.get());
        context.close();
    }
}
