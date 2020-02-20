  
import java.util.Scanner;
import java.io.IOException;
public class Main {
	public static void main(String[] args) throws IOException, FileException {
		int s;
		Scanner x =new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Premi 1 per registrarti. ");
			System.out.println("Premi 2 per loggarti ");
			System.out.println("Premi 3 per uscire");
			s=x.nextInt();
			switch(s) {
			case 1:{
				File list = new File("Utenti.txt",'W');
				Utente p=new Utente();
				String Password2= new String();
				System.out.println("############################################");
				System.out.println("REGISTRAZIONE");
				System.out.println("############################################");
				System.out.println("Inserire il nome: ");
				p.setName(input.nextLine());
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
				Password2=input.nextLine();
				}while(p.controllaPassword2(Password2)!=true);
				System.out.println("Registrazione effetuata corretamente!");	
				list.toFile(p.getName()+";"+p.getSurname()+";"+p.getEmail()+";"+p.getPassword());
				list.close();
				
			}break;
			case 2:{
				//LETTURA DAL FILE I DATI DELL'UTENTE REGISTRATO
				File list2 = new File("Utenti.txt",'R');
				String str = new String();
				str = list2.fromFile();//legge
				String[] a = str.split(";", 4);
				String nome = a[0];
				String cognome = a[1];
				//Email & passowrd
				String email = a[2];
				String pass2 = a[3];
				boolean found = false;
				String user;
				String pass;
				x.nextLine();
				System.out.println("############################################");
				System.out.println("Log in:");
				System.out.println("############################################");
				System.out.println("Inserisci l'email: ");
				user=x.nextLine();
				System.out.println("Inserisci la password: ");
				pass=x.nextLine();
				if(user.equals(email) && pass.equals(pass2))
				{
					found = true;
					if(found == true) {
						System.out.println("Accesso effettuato");
						ListaOrdini l = new ListaOrdini();
						l.vediOrd();
						System.out.println(l.vedi());
						l.vedidett();
					}
				}
				if(found == false) System.out.println("Accesso non effettuato");
				
			}break;
			}
		}while(s!=3);	
	}
}