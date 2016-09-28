package example.app2.adapter;

import java.io.Serializable;

public class Images implements Serializable {
	private String title;
	private String medium, large;
	private int id;

	public Images() {
		super();
	}

	public Images(String title, String medium, String large, int id) {
		super();
		this.title = title;
		this.medium = medium;
		this.large = large;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}