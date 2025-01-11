import java.util.Scanner;

public class Battle {
    AllyTeam allyTeam;
    EnemyTeam enemyTeam;

    public Battle(AllyTeam allyTeam, EnemyTeam enemyTeam) {
        this.allyTeam = allyTeam;
        this.enemyTeam = enemyTeam;
    }

    public void start() {
        int turnCount = 0;
        boolean battleOver = false;

        while (!battleOver) {
            System.out.println("\nTurn " + (turnCount + 1));

            //Enemy info
            System.out.println("Enemies Info:");
            for (int i = 0; i < enemyTeam.enemies.length; i++) {
                if (!enemyTeam.enemies[i].isAlive()) {
                    System.out.println(i + 1 + ". " + enemyTeam.enemies[i].getName() + " (" + enemyTeam.enemies[i].getElement() + " - " + enemyTeam.enemies[i].getHealth() + ")" + " - dead");
                } else {
                    System.out.println(i + 1 + ". " + enemyTeam.enemies[i].getName() + " (" + enemyTeam.enemies[i].getElement() + " - " + enemyTeam.enemies[i].getHealth() + ")");
                }
            }

            for (int i = 0; i < allyTeam.team.length; i++) {
                Player player = allyTeam.team[i];
                if (player != null && player.isAlive()) {
                    player.takeTurn(enemyTeam.enemies, allyTeam.team);
                }
            }

            for (Enemy enemy : enemyTeam.enemies) {
                if (enemy.isAlive()) {
                    int damage = enemy.getAttack();
                    Player attackedPlayer = null;
                    while (attackedPlayer == null || !attackedPlayer.isAlive()) {
                        int attackedPlayerIndex = (int) (Math.random() * allyTeam.team.length);
                        attackedPlayer = allyTeam.team[attackedPlayerIndex];
                    }
                    System.out.println(enemy.getName() + " attacks " + attackedPlayer.name + " for " + damage + " damage.");
                    attackedPlayer.takeDamage(damage);
                }
            }

            battleOver = isGameOver();
            turnCount++;

            if (battleOver) {
                System.out.println("Battle Over!");
                if (allyTeam.getMainCharacter().isAlive()) {
                    resetHealthAfterBattle();
                    System.out.println(allyTeam.getMainCharacter().getName() + " wins!");
                    enhanceMainCharacter(allyTeam.getMainCharacter());
                } else {
                    System.out.println(allyTeam.team[0].getName() + " has fallen!");
                }
            }
        }
    }

    public void resetHealthAfterBattle() {
        for (int i = 0; i < allyTeam.team.length; i++) {
            allyTeam.team[i].health = allyTeam.team[i].maxHealth;
        }
    }

    public void enhanceMainCharacter(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have to chance to upgrade yourself by increasing your stat for 50.");
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
        System.out.println("Your stats now are: Hp: " + player.health + " - Atk: " + player.attack + " - Def: " + player.defense);
    }

    public boolean isGameOver() {
        boolean allAlliesDead = true;
        for (int i = 0; i < allyTeam.team.length; i++) {
            if (allyTeam.team[i].isAlive() && allyTeam.team[i] != null) {
                allAlliesDead = false;
                break;
            }
        }
        if (allAlliesDead) {
            return true;
        }
        boolean allEnemiesDead = true;
        for (int i = 0; i < enemyTeam.enemies.length; i++) {
            if (enemyTeam.enemies[i].isAlive()) {
                allEnemiesDead = false;
                break;
            }
        }
        if (allEnemiesDead) {
            return true;
        }
        return false;
    }


}
