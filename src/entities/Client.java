package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date birthData;
	
	public Client () {		
	}

	public Client(String name, String email, Date birthData) {
		this.name = name;
		this.email = email;
		this.birthData = birthData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthData() {
		return birthData;
	}

	public void setBirthData(Date birthData) {
		this.birthData = birthData;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" (");
		sb.append(sdf.format(getBirthData()));
		sb.append(") - ");
		sb.append(getEmail());
		
		return sb.toString();		
	}
}
