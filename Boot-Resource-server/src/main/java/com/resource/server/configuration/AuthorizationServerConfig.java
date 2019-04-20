 package com.resource.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Override
	public void configure(ClientDetailsServiceConfigurer  detailsServiceConfigurer) throws Exception {
		
		detailsServiceConfigurer
						.inMemory()
						.withClient("taruntest")
						.secret(getPasswordencode().encode("testsecret"))
						.authorizedGrantTypes("authorization_code")
						.scopes("read")
						.authorities("CLIENT")
						.accessTokenValiditySeconds(120).//Access token is only valid for 2 minutes.
			            refreshTokenValiditySeconds(600);
	
	}
	private PasswordEncoder getPasswordencode()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	    oauthServer.passwordEncoder(getPasswordencode());
	}

}
