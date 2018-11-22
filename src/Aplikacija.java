import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import racunar.LapTop;
import racunar.Racunar;
import servis.evidencija.EvidencijaRacunara;
import servis.evidencija.Naplata;
import servis.evidencija.Servis;

public class Aplikacija {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Priprema podataka
		Servis servisSasa = new Servis();
		
		Racunar djoletovRacunar = new LapTop("4234124", 2.5D, "Toshiba", 15.6);
		EvidencijaRacunara djoletovaEvidencija = new EvidencijaRacunara("1A", "Djordje", djoletovRacunar);
		
		servisSasa.dodajRacunarNaServis(djoletovaEvidencija);
		
		Racunar tanjinRacunar = new LapTop("7657567", 2.4D, "Dell", 15.6);
		EvidencijaRacunara tanjinaEvidencija = new EvidencijaRacunara("3A", "Tanja", tanjinRacunar);
		
		servisSasa.dodajRacunarNaServis(tanjinaEvidencija);
		
		Scanner ulaz = new Scanner(System.in);
		
		while(true) {
		System.out.println("Komande za rad sa servisom: ");
		System.out.println("   0 <==> izlazak iz aplikacije");
		System.out.println("   1 <==> pregled racunara na servisu");
		System.out.println("   2 <==> unos nove evidencije");
		System.out.println("   3 <==> uzmi na obradu");
		System.out.println("   4 <==> zavrsi servis");
		System.out.println("   5 <==> otpremi racunar");
		System.out.println("   7 <==> racunari u radu");
		System.out.println("   8 <==> pregled Desktop racunara");
		System.out.println("   9 <==> pregled LapTop racunara ");
		
		
		int ulaznaKomanda = ulaz.nextInt();
		if(ulaznaKomanda == 0) {
			System.out.println("<==> Izlaz iz aplikacije <==>");
			break;
		}
		if(ulaznaKomanda == 1) {
			servisSasa.racunariNaServisu();
		}
		if(ulaznaKomanda == 2) {
			EvidencijaRacunara er = Helper.unesiEvidenciju(ulaz);
			servisSasa.dodajRacunarNaServis(er);
			System.out.println("<==> Uspesno ste dodali racunar za servis <==>");
			System.out.println("");
		}
		if(ulaznaKomanda == 3) {
			System.out.println("Unesi evidencioni broj: ");
			String evidencioniBroj = ulaz.next();
			servisSasa.preuzmiURad(evidencioniBroj);
		}
		if(ulaznaKomanda == 4) {
			System.out.println("Unesi evidencioni broj: ");
			String evidencioniBroj = ulaz.next();
			System.out.println("Unesi iznos: ");
			long iznos = ulaz.nextLong();
			System.out.println("Unesi valutu: ");
			String valuta = ulaz.next();
			Naplata naplata = new Naplata(iznos, valuta);
			servisSasa.zavrsiServis(evidencioniBroj, naplata);
		}
		if(ulaznaKomanda == 5) {
			System.out.println("Unesi evidencioni broj: ");
			String evidencioniBroj = ulaz.next();
			System.out.println("Da li je placeno true/false ");
			Boolean placeno = ulaz.nextBoolean();
			servisSasa.otpremiRacunar(evidencioniBroj, placeno);
		}
		
		if(ulaznaKomanda == 7) {
			 servisSasa.racunariURadu();
			 
		}
		if(ulaznaKomanda == 8) {
			  servisSasa.desktopRacunariNaServisu();
			  
		}
		if(ulaznaKomanda == 9) {
			  servisSasa.laptopRacunariNaServisu();
			  
		}
		if(ulaznaKomanda == 7) {
				  servisSasa.racunariURadu();
		}
	}
	}
}


