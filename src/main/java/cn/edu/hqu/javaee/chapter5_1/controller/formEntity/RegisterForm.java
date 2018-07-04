package cn.edu.hqu.javaee.chapter5_1.controller.formEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{firstName.size}")
	private String firstName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=1,max=30,message="{lastName.size}")
	private String lastName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=5,max=16,message="{userName.size}")
	private String userName;
	
	@Getter
	@Setter
	@NotEmpty
	@Size(min=4,max=25,message="{password.size}")
	private String password;
	
	
	@Getter
	@Setter
	@NotEmpty(message="邮箱不能为空")
	@Email(message="{email.valid}")
	private String email;
	
	@Getter
	@Setter
	private MultipartFile picFile;

};
