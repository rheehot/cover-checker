package com.naver.nid.cover.config;

import jenkins.model.GlobalConfiguration;
import org.apache.commons.lang.StringUtils;

public class CoverCheckerPluginConfig extends GlobalConfiguration {
    private static final String DEFAULT_HOST = "api.github.com";

    private String githubHost;
    private int threshold;
    private int fileThreshold;


    public String getGithubHost() {
        return StringUtils.defaultIfBlank(githubHost, DEFAULT_HOST);
    }

    public void setGithubHost(String githubHost) {
        this.githubHost = githubHost;
    }
}
