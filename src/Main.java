import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        System.out.println("Choose your elemental affinity:");
        System.out.println("1. Water (Healer - Have the ability to heal all your allies 20% health)");
        System.out.println("2. Earth (Tanker - Have the ability to increase your allies defense in 3 turns)");
        System.out.println("3. Fire (Warrior - 40% chance for critical hit that deals double damage)");
        System.out.println("4. Air (Quick - Have the ability to attack all the enemies)");

        int choice = scanner.nextInt();

        if (choice == 1) {
            player.setElement("Water");
        } else if (choice == 2) {
            player.setElement("Earth");
        } else if (choice == 3) {
            player.setElement("Fire");
        } else if (choice == 4) {
            player.setElement("Air");
        } else {
            System.out.println("Invalid choice, defaulting to Water.");
            player.setElement("Water");
        }

        Enemy[] enemies = { new Enemy("Wolf1", 100, 500, 0, "Fire"), new Enemy("Wolf2", 100, 500, 0, "Fire") };
        Player[] teams = { player };

        Battle battle = new Battle(teams, enemies);
        battle.start();

        scanner.close();*/
        Game game = new Game();
        game.start();
    }
}
