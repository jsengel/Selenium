package fr.jeromesengel.selenium.common;


public enum Result {

	SUCCESS("green"),
	PENDING("blue"),
	FAIL("red");

	private String color;

	private Result(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}