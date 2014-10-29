package cx.studio.store.model;

public class Emails {
	private int id;
	private String content;
	private String email_name;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail_name() {
		return email_name;
	}

	public void setEmail_name(String emailName) {
		email_name = emailName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
