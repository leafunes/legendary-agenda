package dto;

public class DBCredentialsDTO {
	
	private String ip;
	private String user;
	private String port;
	private String pass;
	
	public DBCredentialsDTO(){
		
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "DBCredentialsDTO [ip=" + ip + ", user=" + user + ", port=" + port + ", pass=" + pass + "]";
	}

}
