public class Prodotto {
	private String nome;
	private double peso;
	private float prezzo;
	private int ID;
	private int quantita;//max 50
	
	public Prodotto (){
		nome=null;
		peso=0;
		prezzo=0;
		ID=0;
		quantita=0;	
	}
	public Prodotto (String nome, double peso, float prezzo, int ID, int quantita) {
		this.nome = nome;
		this.peso = peso;
		this.prezzo = prezzo;
		this.ID = ID;
		this.quantita = quantita;
	}
	public void setNome (String n){
		nome = n;
	}
	public void setPeso (double p){
		peso = p;
	}
	public void setPrezzo (float pr){
		prezzo = pr;
	}
	public void setID (int i){
		ID = i;
	}
	public void setQuantita (int q){
		if(q>50) System.out.println ("Non puoi inserire oltre 50 elementi");
		else quantita = q;
	}
	public String getNome () {
		return nome;
	}
	public double getPeso () {
		return peso;
	}
	public float getPrezzo () {
		return prezzo;
	}
	public int getID () {
		return ID;
	}
	public int getQuantita () {
		return quantita;
	}
}
