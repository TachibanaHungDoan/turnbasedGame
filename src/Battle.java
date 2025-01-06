public class Battle {
    Player player;
    Player[] teams;
    Enemy[] enemies;

    public Battle(Player player, Player[] teams, Enemy[] enemies) {
        this.player = player;
        this.teams = teams;
        this.enemies = enemies;
    }

    public void start() {
        int turnCount = 0;
        boolean battleOver = false;

        while (!battleOver) {
            System.out.println("\nTurn " + (turnCount + 1));

            //Enemy info
            System.out.println("Enemies Info:");
            for (int i = 0; i < enemies.length; i++) {
                if (!enemies[i].isAlive()) {
                    System.out.println(i + 1 + ". " + enemies[i].getName() + " (" + enemies[i].getElement() + " - " + enemies[i].getHealth() + ")" + " - dead");
                } else {
                    System.out.println(i + 1 + ". " + enemies[i].getName() + " (" + enemies[i].getElement() + " - " + enemies[i].getHealth() + ")");
                }
            }

            for (Player player : teams) {
                player.takeTurn(enemies, teams);
            }

            for (Enemy enemy : enemies) {
                if (enemy.isAlive()) {
                    int damage = enemy.getAttack();
                    Player attackedPlayer = null;
                    while (attackedPlayer == null || !attackedPlayer.isAlive()) {
                        int attackedPlayerIndex = (int) (Math.random() * teams.length);
                        attackedPlayer = teams[attackedPlayerIndex];
                    }
                    System.out.println(enemy.getName() + " attacks " + attackedPlayer.name + " for " + damage + " damage.");
                    attackedPlayer.takeDamage(damage);
                }
            }

            battleOver = isGameOver();
            turnCount++;

            if (turnCount % 5 == 0 && player.getElement().equals("Water")) {
                System.out.println("Water Element - Healing 20% health.");
                //player.heal(20);
            }

            if (battleOver) {
                System.out.println("Battle Over!");
                if (player.isAlive()) {
                    System.out.println(player.getName() + " wins!");
                } else {
                    System.out.println(player.getName() + " has fallen!");
                }
            }
        }
    }

    public boolean isGameOver() {
        boolean allAlliesDead = true;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].isAlive()) {
                allAlliesDead = false;
                break;
            }
        }
        if (allAlliesDead) {
            return true;
        }
        boolean allEnemiesDead = true;
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isAlive()) {
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
