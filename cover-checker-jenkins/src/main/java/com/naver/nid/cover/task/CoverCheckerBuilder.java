package com.naver.nid.cover.task;

import com.naver.nid.cover.Messages;
import com.naver.nid.cover.model.CoverageType;
import groovy.util.logging.Slf4j;
import hudson.EnvVars;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.EnvironmentList;
import hudson.tasks.BuildWrapper;
import hudson.tasks.BuildWrapperDescriptor;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.util.Map;

@Slf4j
@AllArgsConstructor(onConstructor_= {@DataBoundConstructor})
public class CoverCheckerBuilder extends BuildWrapper {

    private CoverageType coverageType;
    private String coverageReport;
    private int threshold;
    private int fileThreshold;

    @Override
    public Environment setUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {

        EnvironmentList environments = build.getEnvironments();

        return new Environment() {
            @Override
            public boolean tearDown(AbstractBuild build, BuildListener listener) throws IOException, InterruptedException {
                EnvVars environment = build.getEnvironment(listener);

                return false;
            }
        };
    }

    @Extension
    public static final class DescriptorImpl extends BuildWrapperDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.CoverCheckerBuilder_DescriptorImpl_DisplayName();
        }

        @Override
        public void calcFillSettings(String field, Map<String, Object> attributes) {
            if (StringUtils.equals(field, "githubUrl")) {
                attributes.putIfAbsent("github", "api.github.com");
            }
        }

        @Override
        public boolean isApplicable(AbstractProject<?, ?> abstractProject) {
            return true;
        }
    }

}
