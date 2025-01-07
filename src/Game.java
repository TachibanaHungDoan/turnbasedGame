import java.util.Scanner;

public class Game {
    AllyTeam allyTeam;
    EnemyTeam enemyTeam;
    Player player;
    Enemy[] enemies;
    Scanner scanner = new Scanner(System.in);

    public Game() {
        allyTeam = new AllyTeam();
    }

    public void start() {
        System.out.println("Welcome");
        createPlayer();
        System.out.println("Chapter 1: ");
        chapter1();
        chapter2ToTest();
    }

    public void createPlayer() {
        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);

        System.out.println("Choose your elemental affinity:");
        System.out.println("1. Water (Healer - Have the ability to heal all your allies 20% health)");
        System.out.println("2. Earth (Tanker - Have the ability to reduce enemy damage dealing teams for 3 turns)");
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
        enhanceCharacter(player);
        allyTeam.addPlayerToTeam(player);
    }

    public void enhanceCharacter(Player player) {
        System.out.println("Your stats are: Hp: " +  player.health + " - Atk: " + player.attack + " - Def: " + player.defense);
        System.out.println("You have to chance to upgrade yourself by increasing your stat for 50.");
        int choiceCountLeft = 2;
        while (choiceCountLeft > 0) {
            System.out.println("Please choose your stat to upgrade: ");
            System.out.println("1. Increase atk 50");
            System.out.println("2. Increase hp 50");
            System.out.println("3. Increase def 50");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("You choose to increase your atk for 50!");
                player.attack += 50;
            } else if (choice == 2) {
                System.out.println("You choose to increase your hp for 50!");
                player.health += 50;
            } else if (choice == 3) {
                System.out.println("You choose to increase your def for 50!");
                player.defense += 50;
            } else {
                System.out.println("Invalid. Deo cho tang");
            }
            System.out.println("Your stats now are: Hp: " +  player.health + " - Atk: " + player.attack + " - Def: " + player.defense);
            choiceCountLeft--;
        }

    }

    public void chapter1() {
        Enemy[] enemies = { new Enemy("Wolf1", 100, 500, 0, "Fire"), new Enemy("Wolf2", 100, 500, 0, "Fire") };
        enemyTeam = new EnemyTeam(enemies.length);
        enemyTeam.addEnemy(enemies);
        Battle battle = new Battle(allyTeam, enemyTeam);
        battle.start();
    }

    public void chapter2ToTest() {
        Enemy[] enemies = { new Enemy("Wolf1", 100, 500, 0, "Fire"), new Enemy("Wolf2", 100, 500, 0, "Fire") };
        enemyTeam = new EnemyTeam(enemies.length);
        enemyTeam.addEnemy(enemies);
        Player duke = new Player("Duke");
        duke.setElement("Earth");
        allyTeam.addPlayerToTeam(duke);
        Battle battle = new Battle(allyTeam, enemyTeam);
        battle.start();
    }

}
