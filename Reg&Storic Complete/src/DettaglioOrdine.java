public class DettaglioOrdine {
	private static final int n=10;
	private Prodotto vet[];
	public DettaglioOrdine() {
		vet = new Prodotto[n];
	}
	public void setV(Prodotto[] v) {
		vet = v;
	}
	public int getD() {
		return n;
	}
	public Prodotto[] getV() {
		return vet;
	}

	public Prodotto getProdotto(int i){
		return vet[i];
	}
	public void setProdotto(Prodotto l, int i){
		vet[i]=l;
	}
	public String vedi(){
		String ap = " ";
		for (int i=0; i<n; i++) {
			try{
				ap = ap + "ID: " + vet[i].getID() + ",Articolo: " + vet[i].getNome() + ",Peso: " + vet[i].getPeso() + "kg, Prezzo: " + vet[i].getPrezzo() + "€, Quantità:" + vet[i].getQuantita() + '\n';
			}
			catch(java.lang.NullPointerException exception){
			}
		}
		return ap;
	}
}