import java.util.Scanner;

public class Game {
    AllyTeam allyTeam;
    Enemy[] enemies = new Enemy[3];
    Player player;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        allyTeam = new AllyTeam();
    }

    public void start() {
        System.out.println("Welcome");
        createPlayer();
        System.out.println("Chapter 1: ");
        chapter1();
    }

    public void createPlayer() {
        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        System.out.println("Choose your elemental affinity:");
        System.out.println("1. Water (Healer - Have the ability to heal all your allies 20% health)");
        System.out.println("2. Earth (Tanker - Have the ability to increase your allies defense in 3 turns)");
        System.out.println("3. Fire (Warrior - 40% chance for critical hit that deals double damage)");
        System.out.println("4. Air (Quick - Have the ability to attack all the enemies)");

        int choice = scanner.nextInt();

        if (choice == 1) {
            player.setElement("Water");
            System.out.println("Your element is water.");
        } else if (choice == 2) {
            player.setElement("Earth");
            System.out.println("Your element is earth.");
        } else if (choice == 3) {
            player.setElement("Fire");
            System.out.println("Your element is fire.");
        } else if (choice == 4) {
            player.setElement("Air");
            System.out.println("Your element is air.");
        } else {
            System.out.println("Invalid choice, defaulting to Water.");
            player.setElement("Water");
        }
        allyTeam.addPlayerToTeam(player);
    }

    public void chapter1() {
        enemies = new Enemy[2];
        enemies[0] = new Enemy("Wolf 1", 100, 500, 0, "Fire");
        enemies[1] = new Enemy("Wolf 2", 100, 500, 0, "Fire");
        Battle battle = new Battle(allyTeam, enemies);
        battle.start();
    }
}
