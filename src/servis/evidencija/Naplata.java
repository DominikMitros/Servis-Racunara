package servis.evidencija;

public class Naplata {

	private long iznos;
	private String valuta;
	private Boolean naplaceno;
	
	public Naplata(long iznos, String valuta) {
		super();
		this.iznos = iznos;
		this.valuta = valuta;
		this.naplaceno = false;
	}
	
	public long getIznos() {
		return iznos;
	}
	public void setIznos(Long iznos) {
		this.iznos = iznos;
	}
	public String getValuta() {
		return valuta;
	}
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}
	public Boolean getNaplaceno() {
		return naplaceno;
	}
	public void setNaplaceno(Boolean naplaceno) {
		this.naplaceno = naplaceno;
	}
	
}
	
