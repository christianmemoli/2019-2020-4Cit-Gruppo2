
public class Utente {
	private String name;
	private String surname;
	private String password;
	private String email;
	
	public Utente(String name, String surname, String email, String password) {
		this.email=email;
		this.name=name;
		this.password=password;
		this.surname=surname;
	}
	public Utente() {
		email=null;
		name=null;
		password=null;
		surname=null;
	}
	public void setName(String n) {
		name=n;
	}
	public void setSurname(String s) {
		surname=s;	
	}
	public void setEmail(String e) {
		email=e;
	}
	public boolean controllaEmail() {
		if(email.contains("@")) {
			return true;
		}
		else {
			System.out.println("E-mail non valida!");
			return false;
		}
	}
	public boolean controllaPassword() {
		int length=password.length();
		if(length>=8) {
			return true;
		}
		else {	
			System.out.println("La password deve contenere almeno 8 caratteri!\n");
			return false;
		}
	}
	public boolean controllaPassword2(String pass2) {
		if(pass2.equals(password)) {
			return true;
		}
		else {	
			System.out.println("Le password non coincidono!");
			return false;
		}
	}
	public void setPassword(String p) {
		password=p;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
}
