package com.lambda.functionimple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Andy {
	private String username;
	private String password;

	public Andy(String username) {
		this.username = username;
	}

}
