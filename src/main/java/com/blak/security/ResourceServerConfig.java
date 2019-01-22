package com.blak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/main/**")
                .and()
                .authorizeRequests()
                .antMatchers
                        (HttpMethod.GET,"/main/**")
                .access("#oauth2.hasScope('doctor') and#oauth2.hasScope('read')")
                .antMatchers
                        (HttpMethod.POST,"/main/**")
                .access("#oauth2.hasScope('doctor') and #oauth2.hasScope('write')")
                .antMatchers("/login/**").permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
                .and()
                .csrf().disable();
    }
    @Override
    public void configure(final ResourceServerSecurityConfigurer
                                  config) {
        final DefaultTokenServices defaultTokenServices = new
                DefaultTokenServices();
        defaultTokenServices.setTokenStore(this.tokenStore);
        config.tokenServices(defaultTokenServices);
    }
}
