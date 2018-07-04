package cn.edu.hqu.javaee.chapter5_1;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter51Application {
	public static final String ROOT = "D:\\upload-dir";
	public static void main(String[] args) {
		File file = new File(ROOT);
		if (!file.exists()) {
			file.mkdir();
		}
		SpringApplication.run(Chapter51Application.class, args);
	}
}
