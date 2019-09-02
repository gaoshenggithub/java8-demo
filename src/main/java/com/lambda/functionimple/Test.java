package com.lambda.functionimple;

public class Test {
	@Override
	public String toString() {
		return "Test{" +
				"name='" + this.getName() + '\'' +
				", password='" + this.getPassword() + '\'' +
				'}';
	}

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Test(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public static Test.TestBuilder builder(){return new Test.TestBuilder();}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Test test = (Test) o;

		if (name != null ? !name.equals(test.name) : test.name != null) return false;
		return password != null ? password.equals(test.password) : test.password == null;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}

	public static class TestBuilder {
		private String name;
		private String password;

		public Test.TestBuilder name(String name) {
			this.name = name;
			return this;
		}

		public Test.TestBuilder password(String password) {
			this.password = password;
			return this;
		}

		public Test build(){
			return new Test(this.name,this.password);

		}

		@Override
		public String toString() {
			return "TestBuilder{" +
					"name='" + this.name + '\'' +
					", password='" + this.password + '\'' +
					'}';
		}


	}

	public static void main(String[] args) {
		Test build = Test.builder().password("34").build();
		System.out.println("build = " + build);
	}
}
