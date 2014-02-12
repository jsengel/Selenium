package fr.jeromesengel.selenium.common;

public enum Page {

	HOME("home.jsp");

	private String view;

	private Page(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}
}