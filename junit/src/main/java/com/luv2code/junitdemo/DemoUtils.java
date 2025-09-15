package com.luv2code.junitdemo;

public class DemoUtils {

	private String academy = "Luv2Code Academy";
	// 3private String academyDuplicate = "Luv2Code Academy";
	private String academyDuplicate = academy;

	public String getAcademy() {
		return academy;
	}

	public String getAcademyDuplicate() {
		return academyDuplicate;
	}

	public int add(int a, int b) {
		return a + b;
	}

	public Object checkNull(Object obj) {
		if (obj != null) {
			return obj;
		}
		return null;
	}

	public String throwException(int a) throws Exception {
		if (a < 0) {
			//LANZAR UNA EXCEPTION
			throw new Exception("Value should be greater than or equal to 0");
		}
		return "Value is greater than or equal to 0";
	}
}
