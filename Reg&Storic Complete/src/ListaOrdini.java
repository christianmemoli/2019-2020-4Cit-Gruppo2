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
	public void vediOrd() throws IOException{
		float[] pr = new float[n];
		for(int i=0; i<n; i++) {
			try {
				File det = new File("dettordine"+i+".txt",'R');
				try {
					int j = 0;
					while(true) {
						det.fromFile();
						det.fromFile();
						det.fromFile();
						pr[j] = pr[j] + Float.parseFloat(det.fromFile());
						j++;
					}
				}
				catch(FileException exception) {
					System.out.println(exception.getMess());
				}
			catch(java.lang.NumberFormatException exception) {
			}
				File o = new File("ordini.txt",'R');
				try {
					int j = 0;
					while(true) {
						Ordine ord = new Ordine();
						ord.setID(Integer.parseInt(o.fromFile()));
						ord.setData(o.fromFile());
						ord.setStato(o.fromFile());
						ord.setPrezzo(pr[j]);
						o.fromFile();
						setOrdine(ord, j);
						o.fromFile();
						j++;
					}
				}
				catch(FileException exception) {
					System.out.println(exception.getMess());
				}
				det.close();
				o.close();
			}
			catch(java.lang.NullPointerException | java.io.FileNotFoundException exception) {
				return;
			}
		}
	}
	public void vedidett() throws IOException{
		int s;
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
							p.setID(Integer.parseInt(dett.fromFile()));
							p.setNome(dett.fromFile());
							p.setPeso(Double.parseDouble(dett.fromFile()));
							p.setPrezzo(Float.parseFloat(dett.fromFile()));
							p.setQuantita(Integer.parseInt(dett.fromFile()));
							d.setProdotto(p, j);
							dett.fromFile();
							j++;
						}
					}
					catch(FileException exception) {
						System.out.println(exception.getMess());
					}
					dett.close();
					System.out.println(d.vedi());
				}
			}
			catch(java.lang.NullPointerException exception) {
			}
		}
	}
}