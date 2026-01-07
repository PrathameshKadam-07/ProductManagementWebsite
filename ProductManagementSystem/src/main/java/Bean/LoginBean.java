package Bean;

import java.io.Serializable;

public class LoginBean implements Serializable{
String uname,pass;

public LoginBean() {
	super();
}

public LoginBean(String uname, String pass) {
	super();
	this.uname = uname;
	this.pass = pass;
}

public String getuname() {
	return uname;
}

public void setuname(String uname) {
	this.uname = uname;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

}
