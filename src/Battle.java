public class Battle {
    AllyTeam allyTeam;
    Enemy[] enemies;

    public Battle(AllyTeam allyTeam, Enemy[] enemies) {
        this.allyTeam = allyTeam;
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

            for (Player player : allyTeam.team) {
                if (player != null) {
                    player.takeTurn(enemies, allyTeam.team);
                }
            }

            for (Enemy enemy : enemies) {
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
                if (allyTeam.team[0].isAlive()) {
                    System.out.println(allyTeam.team[0].getName() + " wins!");
                } else {
                    System.out.println(allyTeam.team[0].getName() + " has fallen!");
                }
            }
        }
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
