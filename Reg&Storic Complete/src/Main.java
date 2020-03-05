  
import java.util.Scanner;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException, FileException {
		int s;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Premi 1 per registrarti");
			System.out.println("Premi 2 per loggarti ");
			System.out.println("Premi 3 per uscire");
			s=input.nextInt();
			switch(s) {
			case 1:{
				File list = new File("Utenti.txt",'W');
				Utente p=new Utente();
				String password = new String();
				System.out.println("############################################");
				System.out.println("(Premere 0 per ritornare al menù precedente)");
				System.out.println("REGISTRAZIONE");
				System.out.println("############################################");
				System.out.println("Inserire il nome: ");
				p.setName(input.nextLine());
				if(p.getName().equals("0")) {
					break;
				}
				System.out.println("Inserire il cognome: ");
				p.setSurname(input.nextLine());
				do {
					System.out.println("Inserire l'email: ");
					p.setEmail(input.nextLine());
				}while(p.controllaEmail()!=true);
				do {
					System.out.println("Inserire la password: ");
					p.setPassword(input.nextLine());
				}while(p.controllaPassword()!=true);
				do {
					System.out.println("Conferma password: ");
					password=input.nextLine();
				}while(p.controllaPassword2(password)!=true);
				System.out.println("Registrazione effetuata corretamente!");	
				list.toFile(p.getName()+";"+p.getSurname()+";"+p.getEmail()+";"+p.getPassword());
				list.close();
			}
			break;
			case 2:{
				//login
				input.nextLine();
				File list = new File("Utenti.txt",'R');
				String str = new String();
				String user;
				String pass;
				System.out.println("############################################");
				System.out.println("(Premere 0 per ritornare al menù precedente)");
				System.out.println("Login:");
				System.out.println("############################################");
				System.out.println("Email: ");
				user=input.nextLine();
				if(user.equals("0")) break;
				System.out.println("Password: ");
				pass=input.nextLine();
				while(true) {
					str = list.fromFile();
					String[] a = str.split(";", 4);
					String email = a[2];//assegna email
					String pass2 = a[3];//assegna password
					if(user.equals(email) && pass.equals(pass2))
					{
						System.out.println("Login effettuato");
						ListaOrdini l = new ListaOrdini();
						l.vediOrd();
						l.vedidett();
						break;
					}
					else(user!=email && pass !=pass2) {
						System.out.println("Login fallito!");
						break;
					}
				}

			}
			break;
		}
	}while(s!=3);
	input.close();
}
}