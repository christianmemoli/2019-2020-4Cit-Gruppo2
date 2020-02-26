import java.io.IOException;
import java.util.Scanner;
public class ListaOrdini {
	private static final int n=10;
	private Ordine vet[];
	Scanner input = new Scanner(System.in);
	public ListaOrdini() {
		vet = new Ordine[n];
	}
	public void setV(Ordine[] v) {
		vet = v;
	}
	public int getD() {
		return n;
	}
	public Ordine[] getV() {
		return vet;
	}

	public Ordine getOrdine(int i){
		return vet[i];
	}
	public void setOrdine(Ordine l, int i){
		vet[i]=l;
	}
	public String vedi(){
		String ap=new String();
		for (int i=0; i<n; i++) {
			try{
				ap = ap + "Ordine: " + vet[i].getID() + ", Data: " + vet[i].getData() + ", Stato: " + vet[i].getStato() + ", Prezzo: " + vet[i].getPrezzo() + '\n';
			}
			catch(java.lang.NullPointerException exception){
			}
		}
		return ap;
	}
	public double calcPrezzoOrd() throws IOException {
		String str = new String();
		double a = 0;
		for(int i=0; i<n; i++) {
			try {
				File det = new File("dettordine"+i+".txt",'R');
				if(det.exists()) {
					while(true) {
						str = det.fromFile();
						String[] app = str.split(";",5);
						a = a + Double.parseDouble(app[3]);
					}
				}
				else {
					return 0;
				}
			}
			catch(FileException exception) {
				System.out.println(exception.getMess());
			}
		}
		return a;
	}
	public void vediOrd() throws IOException{
		String str = new String();
		File o = new File("ordini.txt",'R');
		int j = 0;
		try {
			while(true) {
				Ordine ord = new Ordine();
				str = o.fromFile();
				String[] app = str.split(";",3);
				ord.setID(Integer.parseInt(app[0]));
				ord.setData(app[1]);
				ord.setStato(app[2]);
				ord.setPrezzo(calcPrezzoOrd());
				setOrdine(ord, j);
				j++;
			}
		}
		catch(FileException exception) {
			System.out.println(exception.getMess());
		}
		o.close();
	}
	public void vedidett() throws IOException{
		int s;
		String str = new String();
		DettaglioOrdine d = new DettaglioOrdine();
		System.out.println("Visualizzare nel dettaglio quale ordine?");
		s = input.nextInt();
		for(int i=0;i<n;i++)
		{
			try {
				if(s == vet[i].getID()) {
					int j=0;
					File dett = new File("dettordine"+i+".txt",'R');
					try {
						while(true) {
							Prodotto p = new Prodotto();
							str = dett.fromFile();
							String[] app = str.split(";",5);
							p.setID(Integer.parseInt(app[0]));
							p.setNome(app[1]);
							p.setPeso(Double.parseDouble(app[2]));
							p.setPrezzo(Float.parseFloat(app[3]));
							p.setQuantita(Integer.parseInt(app[4]));
							d.setProdotto(p, j);
							dett.fromFile();
							j++;
						}
					}
					catch(FileException exception) {
						System.out.println(exception.getMess());
					}
					System.out.println(d.vedi());
				}
			}
			catch(java.lang.NullPointerException exception) {
			}
		}
	}
}