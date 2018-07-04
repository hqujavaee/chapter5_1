package cn.edu.hqu.javaee.chapter5_1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String KEY="hqu.edu.cn";
	@Autowired
	UserDetailsManager userDetailsManager;
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//密码编码器必须和存储到memeory中的密码编码器一样
		PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.userDetailsService(userDetailsManager).passwordEncoder(passwordEncoder);
		//super.configure(auth);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//H2数据库不需要用户登录
		http.authorizeRequests().antMatchers("/","/index","/css/**","/js/**","/fonts/**","/users").permitAll()// 都可以访问
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/hquer/**").permitAll()//登陆及注册请求路径所有人都能访问
		.antMatchers("/message/**").authenticated()
		.antMatchers("/hquer/hquer_profile").authenticated()
		.and()
		.rememberMe().key(KEY)
		.and()
		.logout()
		.deleteCookies(KEY)
		.invalidateHttpSession(true)
		.logoutUrl("/logout")
		.logoutSuccessUrl("/index")
		.and()
		.formLogin()
		.loginPage("/hquer/login")//登陆路径
		.defaultSuccessUrl("/hquer/hquer_profile");
		//没有该配置H2控制台登录不了
		http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
		//没有该配置H2控制台登录不了
		http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求
	}
}