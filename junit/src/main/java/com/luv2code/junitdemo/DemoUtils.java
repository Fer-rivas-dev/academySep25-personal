package com.luv2code.junitdemo;

public class DemoUtils {

	private String academy = "Luv2Code Academy";
	//3private String academyDuplicate = "Luv2Code Academy";
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
}
