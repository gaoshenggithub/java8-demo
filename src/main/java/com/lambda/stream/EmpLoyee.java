package com.lambda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpLoyee {
	private String username;
	private double money;
	private Long age;
	private Status status;

	public enum Status {
		BUSY, FREE, VOCATION;
	}
}
