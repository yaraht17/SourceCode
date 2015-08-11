package data;

public class Data {
	private String acc,pass;

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Data(String acc, String pass) {
		super();
		this.acc = acc;
		this.pass = pass;
	}

	public Data() {
		super();
	}
	

}
