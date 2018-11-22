package servis.evidencija;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import racunar.Desktop;
import racunar.LapTop;

public class Servis {
	
	private List<EvidencijaRacunara> racunari;  //napravili smo listu novu.
	
	//  Konstruktor za listu i neka ostaje prazan da bi se inicijalizovao da ne bi pisali gore list array = new array list.
	
	public Servis() {
		this.racunari = new ArrayList<>();
	}
	
	public void dodajRacunarNaServis(EvidencijaRacunara racunarZaEvidenciju) throws IOException {
		racunari.add(racunarZaEvidenciju);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("c:/servisracunara/servis/"+racunarZaEvidenciju.getEvidencioniBroj()+".txt"));
		writer.write(racunarZaEvidenciju.toString());
		writer.close();
	}

	
	
	public void preuzmiURad(String evidencioniBroj) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.U_RADU);
			
		}
		}
	}
	
	public void zavrsiServis (String evidencioniBroj, Naplata naplata) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.ZAVRSEN_SERVIS);
				evidencija.setNaplata(naplata);
				evidencija.setDatumZavrsetkaServisa(LocalDate.now());
			}
		}
		
	}
	
	public void otpremiRacunar(String evidencioniBroj, Boolean naplaceno) {
		for (EvidencijaRacunara evidencija : racunari) {
			if(evidencija.getEvidencioniBroj().equals(evidencioniBroj)){
				evidencija.setStatusServisa(Status.ROBA_PREUZETA);
				evidencija.getNaplata().setNaplaceno(naplaceno);
			}
		}
	}
	
	public void racunariNaServisu() throws IOException {
		BufferedWriter pisac = new BufferedWriter(new FileWriter("c:/servisracunara/servis/RacunariNaServisu.txt"));
		for (EvidencijaRacunara evidencija : racunari) {  //prolazi kroz celu listu da ne bi rucno kucali length itd itd
			evidencija.informacijeOEvidenciji();
			pisac.write(evidencija.toString());
			pisac.newLine();
		}
		pisac.close();
		
	}
	public void laptopRacunariNaServisu() {
		for (EvidencijaRacunara evidencija : racunari) {
			if (evidencija.getRacunar() instanceof LapTop) {
				evidencija.informacijeOEvidenciji();
				}
			}
	}
	public void desktopRacunariNaServisu() {
				for (EvidencijaRacunara evidencija : racunari) {
					if (evidencija.getRacunar() instanceof Desktop) {
						evidencija.informacijeOEvidenciji();
					}
				}
	}
	public void racunariURadu() {
				for (EvidencijaRacunara evidencija : racunari) {
					if (evidencija.getStatusServisa().equals(Status.U_RADU)) {
				    evidencija.informacijeOEvidenciji();
				
			}
		}
	}
}


		
	
