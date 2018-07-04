package cn.edu.hqu.javaee.chapter5_1.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;;
@Configuration
public class InMemorySecurityConfig {
	@Bean
	public InMemoryUserDetailsManager  inMemoryUserDetailsManager() {
		//默认采用BCryptPasswordEncoder编码
		PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		final Properties users = new Properties();
		//创建一个zhangsan、密码：8888,具有ROLE_USER权限、有效用户
		users.put("zhangsan", passwordEncoder.encode("8888")+",ROLE_USER,enabled");
		users.put("lisi", passwordEncoder.encode("123456")+",ROLE_USER,enabled");
		return new InMemoryUserDetailsManager(users);
	    }
}
