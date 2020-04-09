package com.naver.nid.cover;

import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;
import hudson.model.Label;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class CoverCheckerBuilderTest {

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    final String name = "Bobby";

    @Test
    public void testConfigRoundtrip() throws Exception {
    }

    @Test
    public void testConfigRoundtripFrench() throws Exception {
    }

    @Test
    public void testBuild() throws Exception {
    }

    @Test
    public void testBuildFrench() throws Exception {
    }

    @Test
    public void testScriptedPipeline() throws Exception {

    }

}