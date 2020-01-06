package com.jintu.authorization.config;

import com.jintu.authorization.config.exception.AuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/23 9:31
 * @Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    /**
     * 密码加密工具
     */
    private final BCryptPasswordEncoder passwordEncoder;
    /**
     * 注入用于支持 password 模式
     */
    private final AuthenticationManager authenticationManager;

    /**
     * 注入redis
     */
    private final RedisConnectionFactory redisConnectionFactory;

    private final AuthExceptionEntryPoint authExceptionEntryPoint;

    /**
     *     token 保存在内存也可以是数据库
      */
    /*@Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }*/

    @Bean
    public TokenStore tokenStore() {
        // token 保存到redis
        return new RedisTokenStore(redisConnectionFactory);
    }

    public AuthorizationServerConfiguration(AuthenticationManager authenticationManager, BCryptPasswordEncoder passwordEncoder, RedisConnectionFactory redisConnectionFactory, AuthExceptionEntryPoint authExceptionEntryPoint) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.redisConnectionFactory = redisConnectionFactory;
        this.authExceptionEntryPoint = authExceptionEntryPoint;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 用于支持密码模式
                .authenticationManager(authenticationManager)
                // token
                .tokenStore(tokenStore());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 允许客户端访问 /oauth/check_token 检查 token
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients()
                .authenticationEntryPoint(authExceptionEntryPoint);
    }
    /**
     * 配置客户端
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                // client_secret
                .secret(passwordEncoder.encode("secret"))
                // 授权类型，密码模式和刷新令牌
                .authorizedGrantTypes("password", "refresh_token")
                // 授权范围
                .scopes("backend")
                // 可以设置对哪些资源有访问权限，不设置则全部资源都可以访问
                .resourceIds("backend-resources")
                // 设置访问令牌的有效期，这里是 1 天
                .accessTokenValiditySeconds(60 * 60 * 24)
                // 设置刷新令牌的有效期，这里是 30 天
                .refreshTokenValiditySeconds(60 * 60 * 24 * 30);
    }
}
