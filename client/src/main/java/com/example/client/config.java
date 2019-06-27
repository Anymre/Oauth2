package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;
import java.util.List;

@Configuration
public class config {
    @Autowired
    private OAuth2ClientContext oauth2Context;

    @Bean
    public OAuth2RestTemplate sparklrRestTemplate() {
        return new OAuth2RestTemplate(sparklr(), oauth2Context);
    }
    @Bean
    public OAuth2ProtectedResourceDetails sparklr() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("client");
        details.setClientId("client");
        details.setClientSecret("123456");
        details.setAccessTokenUri("http://localhost:8080/oauth/token");
        details.setUserAuthorizationUri("http://localhost:8080/oauth/authorize");
        details.setScope(Arrays.asList("app"));
        return details;
    }
}
