package com.naver.nid.cover.task;

import com.naver.nid.cover.Messages;
import com.naver.nid.cover.model.CoverageType;
import groovy.util.logging.Slf4j;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.EnvironmentList;
import hudson.tasks.BuildWrapper;
import hudson.tasks.BuildWrapperDescriptor;
import lombok.AllArgsConstructor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

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
                return super.tearDown(build, listener);
            }
        };
    }

    @Extension
    public static final class DescriptorImpl extends BuildWrapperDescriptor {

        @Override
        public String getDisplayName() {
            return Messages.HelloWorldBuilder_DescriptorImpl_DisplayName();
        }



        @Override
        public boolean isApplicable(AbstractProject<?, ?> abstractProject) {
//            abstractProject.
            return false;
        }
    }

}
