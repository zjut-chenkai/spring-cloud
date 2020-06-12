package org.com.ck.config;

import org.com.ck.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired
	@Qualifier("jwtTokenStore")
	private TokenStore tokenStore;

	@Autowired
	private JwtTokenEnhancer jwtTokenEnhancer;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	/**
	 * 使用密码模式需要配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints//
				.authenticationManager(authenticationManager)//
				.userDetailsService(userService).accessTokenConverter(jwtAccessTokenConverter).tokenStore(tokenStore)
				.accessTokenConverter(jwtAccessTokenConverter).tokenEnhancer(jwtTokenEnhancer);//
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()//
				.withClient("admin")// 配置client_id
				.secret(passwordEncoder.encode("admin123456"))// 配置client_secret
				.accessTokenValiditySeconds(3600)// 配置访问token的有效期
				.refreshTokenValiditySeconds(864000)// 配置刷新token的有效期
				.authorizedGrantTypes("password", "refresh_token");// 配置grant_type，表示授权类型
	}

}