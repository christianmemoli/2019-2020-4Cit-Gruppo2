public class Ordine {
	private int ID;
	private String data;
	private String stato;
	private float prezzo;
	
	public Ordine (){
		ID=0;
		data=null;
		stato=null;
		prezzo=0;
	}
	public Ordine (int ID, String data, String stato, float prezzo) {
		this.ID = ID;
		this.data = data;
		this.stato = stato;
		this.prezzo = prezzo;
	}
	public void setID (int i){
		ID = i;
	}
	public void setData (String d){
		data = d;
	}
	public void setStato (String s){
		stato = s;
	}
	public void setPrezzo (float pr){
		prezzo = pr;
	}

	public int getID () {
		return ID;
	}
	public String getData () {
		return data;
	}
	public String getStato () {
		return stato;
	}
	public float getPrezzo () {
		return prezzo;
	}
}
