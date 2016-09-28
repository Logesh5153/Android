package example.app2.adapter;

import java.io.Serializable;

public class Albums implements Serializable {
	private String title;
	private String userId;
	private String id;

	public Albums() {
		super();
	}

	public Albums(String title, String userId, String id) {
		super();
		this.title = title;
		this.userId = userId;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}