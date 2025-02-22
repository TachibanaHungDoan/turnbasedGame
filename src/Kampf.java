package game;
import java.util.Scanner;

public class Kampf {
	Mitglieder steam;
	Feinde fteam;
	
	public Kampf(Mitglieder mitglieder, Feinde feinde) {
		this.steam = steam;
		this.fteam = fteam;
	}
	
	public void Anfang() {
		int runden = 0;
		boolean KampfEnde = false;
		
		while(!KampfEnde) {
			 System.out.println("\nRunde(n) " + (runden + 1));
			 // Informationen der Feinde
			 System.out.println("Informationen der Feinde:");
	            for (int i = 0; i < fteam.feinde.length; i++) {
	                if (!fteam.feinde[i].Leben()) {
	                    System.out.println(i + 1 + ". " + fteam.feinde[i].getName() + " (" + fteam.feinde[i].getElement() + " - " + fteam.feinde[i].getGesundheit() + ")" + " - tot");
	                } else {
	                    System.out.println(i + 1 + ". " + fteam.feinde[i].getName() + " (" + fteam.feinde[i].getElement() + " - " + fteam.feinde[i].getGesundheit() + ")");
	                }
	            }
	            for (int i = 0; i < steam.mitglieder.length; i++) {
	                Spieler spieler = steam.mitglieder[i];
	                if (spieler != null && spieler.Leben()) {
	                	spieler.SpielerMal(fteam.feinde, steam.mitglieder);
	                }
	            }
	            for (int i = 0; i < fteam.feinde.length; i++) {
	                Feind feind = fteam.feinde[i];
	                if (feind != null && feind.Leben()) {
	                    int schaden = feind.getAngriff();
	                    Spieler sangegriffen = null;
	                    while (sangegriffen == null || !sangegriffen.Leben()) {
	                        int sangegriffenIndex = (int) (Math.random() * steam.mitglieder.length);
	                        sangegriffen = steam.mitglieder[sangegriffenIndex];
	                    }
	                    System.out.println(feind.getName() + " greift " + sangegriffen.sname + " mit " + schaden + " an.");
	                    sangegriffen.Angegriffen(schaden);
	                }
	            }
	            KampfEnde = Beenden();
	            runden++;
	            
	            if (KampfEnde) {
	                System.out.println("Der Kampf ist vorbei!!");
	                if (steam.getMC().Leben()) {
	                	NeuSetzen();
	                    System.out.println(steam.getMC().getName() + " hat gewonnen!");
	                    MCEntwickeln(steam.getMC());
	                } else {
	                    System.out.println(steam.mitglieder[0].getName() + " ist gefallen!");
	                }
	            }  
		}
		
	}
	
	 public void NeuSetzen() {
	        for (int i = 0; i < steam.mitglieder.length; i++) {
	            steam.mitglieder[i].ges = steam.mitglieder[i].maxges;
	        }
	    }
	 public void MCEntwickeln(Spieler spieler) {
		 Scanner scanner = new Scanner(System.in);
	        System.out.println("Wählen Sie den Wert aus, den Sie erhöhen möchten: ");
	        System.out.println("1. Angriff + 50");
	        System.out.println("2. Gesundheit + 50");
	        System.out.println("3. Verteidigung + 50");
	        int wahl = scanner.nextInt();
	        if (wahl == 1) {
	            System.out.println("Sie haben Ihren Angriff um 50 erhöht.");
	            spieler.ang += 50;
	        } else if (wahl == 2) {
	            System.out.println("Sie haben Ihre Gesundheit um 50 erhöht.");
	            spieler.ges += 50;
	        } else if (wahl == 3) {
	            System.out.println("Sie haben Ihre Verteidigung um 50 erhöht.");
	            spieler.ver += 50;
	        } else {
	            System.out.println("Nicht verfügbare Auswahl. Sie haben Ihre Chance, Ihre Fähigkeiten zu erhöht, leider verpasst.");
	        }
	        System.out.println("Ihre Statistik: GES: " + spieler.ges + " - ANG: " + spieler.ang + " - Def: " + spieler.ver);
	 }
	 public boolean Beenden() {
	        boolean steamtot = true;
	        for (int i = 0; i < steam.mitglieder.length; i++) {
	            if (steam.mitglieder[i].Leben() && steam.mitglieder[i] != null) {
	            	steamtot = false;
	                break;
	            }
	        }
	        if (steamtot) {
	            return true;
	        }
	        boolean fteamtot = true;
	        for (int i = 0; i < fteam.feinde.length; i++) {
	            if (fteam.feinde[i].Leben()) {
	            	fteamtot = false;
	                break;
	            }
	        }
	        if (fteamtot) {
	            return true;
	        }
	        return false;
	    }
}
