package servis.evidencija;

import java.time.LocalDate;

import racunar.Racunar;

public class EvidencijaRacunara {
	
	private String evidencioniBroj;
	private String vlasnik;
	private LocalDate datumPrijemaServisa;
	private LocalDate datumZavrsetkaServisa;
	private Status statusServisa;  //Vuce iz enuma informacije da li je popravljen racunar ili ne.
	private Racunar racunar;      //Atribut racunar da povuce iz klase racunar informacije.
	private Naplata naplata;
	
	
	//  Ovaj konstruktor sluzi kada unesemo novi racunar da nema zavrsetak servise jer je u pitanju racunar za prijem zato stoji NULL
	//  I stoji odmah status ZA POPRAVKU jer logicno, racunar je primljen za popravku.
	public EvidencijaRacunara(String evidencioniBroj, String vlasnik, Racunar racunar) {
	this(evidencioniBroj, vlasnik, LocalDate.now(), null, Status.ZA_POPRAVKU, racunar);
	
	}

		
	public EvidencijaRacunara(String evidencioniBroj, String vlasnik, LocalDate datumPrijemaServisa,
			LocalDate datumZavrsetkaServisa, Status statusServisa, Racunar racunar) {
		super();
		this.evidencioniBroj = evidencioniBroj;
		this.vlasnik = vlasnik;
		this.datumPrijemaServisa = datumPrijemaServisa;
		this.datumZavrsetkaServisa = datumZavrsetkaServisa;
		this.statusServisa = statusServisa;
		this.racunar = racunar;
	}
	
	public void informacijeOEvidenciji() {
		System.out.println("Racunar: Ime vlasnika: " + getVlasnik() + " Evidencioni broj: " + getEvidencioniBroj() +" <== je u statusu ==> " + statusServisa + ". Racunar je primljen: " + datumPrijemaServisa);
		if(datumZavrsetkaServisa != null) {
			System.out.println("Datum zavrsetka servisa je: " + datumZavrsetkaServisa);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Racunar: Ime vlasnika: " + getVlasnik() + " Evidencioni broj: " + getEvidencioniBroj() +" <== je u statusu ==> " + statusServisa + ". Racunar je primljen: " + datumPrijemaServisa;
	}
	

	public String getEvidencioniBroj() {
		return evidencioniBroj;
	}


	public void setEvidencioniBroj(String evidencioniBroj) {
		this.evidencioniBroj = evidencioniBroj;
	}


	public String getVlasnik() {
		return vlasnik;
	}


	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}


	public LocalDate getDatumPrijemaServisa() {
		return datumPrijemaServisa;
	}


	public void setDatumPrijemaServisa(LocalDate datumPrijemaServisa) {
		this.datumPrijemaServisa = datumPrijemaServisa;
	}


	public LocalDate getDatumZavrsetkaServisa() {
		return datumZavrsetkaServisa;
	}


	public void setDatumZavrsetkaServisa(LocalDate datumZavrsetkaServisa) {
		this.datumZavrsetkaServisa = datumZavrsetkaServisa;
	}


	public Status getStatusServisa() {
		return statusServisa;
	}


	public void setStatusServisa(Status statusServisa) {
		this.statusServisa = statusServisa;
	}


	public Racunar getRacunar() {
		return racunar;
	}


	public void setRacunar(Racunar racunar) {
		this.racunar = racunar;
	}


	public Naplata getNaplata() {
		return naplata;
	}


	public void setNaplata(Naplata naplata) {
		this.naplata = naplata;
	}
	
}
