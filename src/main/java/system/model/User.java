package system.model;

public class User {
	private int userid;
	private String user_first_name;
	private String user_last_name;
	private String user_uname;
	private String user_phone;
	private String user_email;
	private String user_pass;
	private double user_wallet;
	
	public User() {
		setUserid(0);
		setUser_first_name("first_default");
		setUser_last_name("last_default");
		setUser_uname("uname_default");
		setUser_phone("phone_default");
		setUser_email("default@default.dft");
		setUser_pass("");
		setUser_wallet(0.00);
	}
	
	public User (int id, String firstName, String lastName, String username, String phoneNum, String email, String pass, double wallet) {
		setUserid(id);
		setUser_first_name(firstName);
		setUser_last_name(lastName) ;
		setUser_uname(username);
		setUser_phone(phoneNum);
		setUser_email(email) ;
		setUser_pass(pass) ;
		setUser_wallet(wallet);
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_uname() {
		return user_uname;
	}

	public void setUser_uname(String user_uname) {
		this.user_uname = user_uname;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public double getUser_wallet() {
		return user_wallet;
	}

	public void setUser_wallet(double user_wallet) {
		this.user_wallet = user_wallet;
	}
	
	public String toString() {
		return "toString";
	}
}
