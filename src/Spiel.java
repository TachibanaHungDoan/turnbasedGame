package game;

import java.util.Scanner;

public class Spiel {
    Mitglieder steam;  
    Feinde fteam;      
    Spieler spieler;  
    Feind[] feinde;    
    Scanner scanner = new Scanner(System.in); 
    String spielerName; 

    public Spiel() {
        steam = new Mitglieder();
    }

    public void Anfang() {
        System.out.println("Bitte geben Sie Ihren Namen ein:");
        spielerName = scanner.nextLine();
        System.out.println("Herzlich willkommen, " + spielerName);
        steam.Mitgliederhinzufugen(spieler);
        System.out.println("Drücken Sie „Enter/Eingabetaste“, um unsere Reise zu beginnen.");

        //kapitel 0
        String[] kapitel0Text = Gesprach.kapitel0();
        for (int i = 0; i < kapitel0Text.length; i++) {
            String kapitel0 = kapitel0Text[i].replace("[SpielerName]", spielerName);
            System.out.println(kapitel0);
            scanner.nextLine(); 
        }
        
        //Element wählen
        HinzufugenSpieler();
        
        // entwicklen
        String[] dia3Text = Gesprach.dia3();
        for (int i = 0; i < dia3Text.length; i++) {
            String dia3 = dia3Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia3);
            scanner.nextLine(); 
        }
        MCEntwickeln(spieler);
        // Kapitel 1
        String[] dia4Text = Gesprach.dia4();
        for (int i = 0; i < dia4Text.length; i++) {
            String dia4 = dia4Text[i].replace("[SpielerName]", spielerName);
            System.out.println(dia4);
            scanner.nextLine(); 
        }
        Kampf1Kapitel1();
        MCEntwickeln(spieler);
        
        
    }

    public void HinzufugenSpieler() {
       int wahl = scanner.nextInt();
        scanner.nextLine();

        spieler = new Spieler(spielerName);

        if (wahl == 1) {
            spieler.setElement("Water");
            System.out.println("Dein Element ist Wasser.");
        } else if (wahl == 2) {
            spieler.setElement("Earth");
            System.out.println("Dein Element ist Erde.");
        } else if (wahl == 3) {
            spieler.setElement("Fire");
            System.out.println("Dein Element ist Feuer.");
        } else if (wahl == 4) {
            spieler.setElement("Air");
            System.out.println("Dein Element ist Luft.");
        } else {
            System.out.println("Ungültige Wahl. Standardmäßig wird Ihr Element Wasser gesetzt.");
            spieler.setElement("Water");
        }
    }
	public void MCEntwickeln(Spieler spieler) {
		System.out.println("Ihre Statistik: Gesundheit: " +  spieler.ges + " - Angriff: " + spieler.ang + " - Verteidigung: " + spieler.ver);
        System.out.println("Sie haben die Chance, sich zu verbessern, indem Sie Ihre Statistik um 50 erhöhen.");
        int mal = 1;
        while (mal > 0) {
            System.out.println("Wählen Sie den Wert aus, den Sie erhöhen möchten");
            System.out.println("1. Angriff + 50");
            System.out.println("2. Gesundheit + 50");
            System.out.println("3. Verteidigung + 50");
            int wahl = scanner.nextInt();
            if (wahl == 1) {
                System.out.println("Angriff + 50!");
                spieler.ang += 50;
            } else if (wahl == 2) {
                System.out.println("Gesundheit + 50!");
                spieler.ges += 50;
            } else if (wahl == 3) {
                System.out.println("Verteidigung + 50!");
                spieler.ver += 50;
            } else {
                System.out.println("Ungültige Auswahl. Sie haben Ihre Chance verpasst, Ihre Fähigkeiten zu verbessern.");
            }
            System.out.println("Ihre Statistik: Gesundheit: " +  spieler.ges + " - Angriff: " + spieler.ang + " - Verteidigung: " + spieler.ver);
            mal--;
        }
	}
	public void Kampf1Kapitel1() {
		Feind[] feinde = { new Feind("Wolf 1", 100, 500, 0, "Feuer"), new Feind("Wolf 2", 100, 500, 0, "Feuer") };
        fteam = new Feinde(feinde.length);
        fteam.Feindhinzufugen(feinde);
        Kampf kampf1 = new Kampf(steam, fteam);
        kampf1.Anfang();
	}
}