import java.util.Scanner;

public class Player {
    String name;
    int attack;
    int health;
    int maxHealth;
    int defense;
    String element;
    int defenseBoostTurns;

    public Player(String name) {
        this.name = name;
        this.attack = 500;
        this.maxHealth = 500;
        this.health = maxHealth;
        this.defense = 50;
        this.defenseBoostTurns = 0;
    }

    public void takeTurn(Enemy[] enemies, Player[] teams) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is " + this.name + " turn. " + this.name + "'s stat: " + this.health + " " + this.attack + " " + this.defense + ".");
        int action;
        while (true) {
            System.out.println("Choose action:");
            System.out.println("1. Attack");
            if (element.equals("Water")) {
                System.out.println("2. Heal");
            } else if (element.equals("Earth")) {
                System.out.println("2. DefenseBoost");
            }
            action = scanner.nextInt();
            if (action == 1) {
                if (element.equals("Air")) {
                    aoeAttack(enemies);
                } else {
                    singleTargetAttack(enemies);
                }
                break;
            } else if (action == 2) {
                if (element.equals("Water")) {
                    heal(20, teams);
                    break;
                } else if (element.equals("Earth")) {
                    boostDefense(teams);
                    break;
                } else {
                    System.out.println("Invalid action.");
                }
            } else {
                System.out.println("Invalid action.");
            }
        }

        if (defenseBoostTurns > 0) {
            defenseBoostTurns--;
        }

        if (defenseBoostTurns < 0) {
            defenseBoostTurns = 0;
        }
    }

    public void aoeAttack(Enemy[] enemies) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isAlive()) {
                attackEnemy(enemies[i]);
            }
        }
    }

    public void singleTargetAttack(Enemy[] enemies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose enemy to attack:");
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].isAlive()) {
                System.out.println((i + 1) + ". " + enemies[i].name + " - " + enemies[i].health);
            } else {
                System.out.println((i + 1) + ". " + enemies[i].name + " - " + enemies[i].health + " - dead.");
            }
        }
        int targetIndex = scanner.nextInt() - 1;
        if (enemies[targetIndex].isAlive()) {
            attackEnemy(enemies[targetIndex]);
        } else {
            System.out.println("This enemy is already dead. You lost a turn for nothing.");
        }
    }

    public void boostDefense(Player[] teams) {
        for (Player player : teams) {
            if (player != null) {
                player.defenseBoostTurns = 3;
            }
        }
    }

    public void attackEnemy(Enemy enemy) {
        int damage = this.attack;
        if (element.equals("Fire")) {
            double criticalChance = Math.random();
            if (criticalChance < 0.4) {
                damage *= 2;
                System.out.println("Critical Hit! " + this.name + " deals double damage!");
            }
        }
        if (element.equals("Air")) {
            damage = damage * 3 / 4;
        }
        enemy.takeDamage(damage);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage.");
    }

    public void heal(int percentage, Player[] teams) {
        for (Player player : teams) {
            if (player != null) {
                int healAmount = player.maxHealth * percentage / 100;
                player.health += healAmount;
                if (player.health >= player.maxHealth) {
                    player.health = player.maxHealth;
                }
                System.out.println(player.name + " heals for " + healAmount + " health. Remaining health: " + player.health);
            }
        }
    }

    public void takeDamage(int damage) {
        int actualDefense = this.defense;
        if (defenseBoostTurns > 0) {
            actualDefense += 200;
        }
        int damageTaken = (int) Math.ceil( (double) damage / ((actualDefense + 100) / 100.0));
        this.health -= damageTaken;
        if (this.health <= 0) {
            this.health = 0;
        }
        System.out.println(this.name + " takes " + damageTaken + " damage. Remaining health: " + this.health);
    }

    public String getName() {
        return this.name;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public String getElement() {
        return this.element;
    }

    public int getMaxHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
