package com.lambda.functionimple;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
	private String username;
	private String password;
	private Integer age;
}
