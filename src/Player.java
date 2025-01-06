import java.util.Scanner;

public class Player {
    String name;
    int attack;
    int health;
    int defense;
    String element;

    public Player(String name) {
        this.name = name;
        this.attack = 500;
        this.health = 500;
        this.defense = 500;
    }

    public void takeTurn(Enemy[] enemies) {
        Scanner scanner = new Scanner(System.in);
        int action;
        while (true) {
            System.out.println("Choose action:");
            System.out.println("1. Attack");
            if (element.equals("Water")) {
                System.out.println("2. Heal");
            } else if (element.equals("Earth")) {
                System.out.println("2. Defense");
            }
            action = scanner.nextInt();
            if (action == 1) {
                System.out.println("Choose enemy to attack:");
                //Enemy info
                for (int i = 0; i < enemies.length; i++) {
                    System.out.println( (i+1) + ". " + enemies[i].name + " - " + enemies[i].health);
                }
                int targetIndex = scanner.nextInt() - 1;
                if (!enemies[targetIndex].isAlive()) {
                    System.out.println("This enemy is already dead.");

                    boolean foundAliveEnemy = false;

                    for (int i = targetIndex + 1; i < enemies.length; i++) {
                        if (enemies[i].isAlive()) {
                            System.out.println("Attacking next alive enemy: " + enemies[i].getName());
                            attackEnemy(enemies[i]);
                            foundAliveEnemy = true;
                            break;
                        }
                    }

                    if (!foundAliveEnemy) {
                        for (int i = targetIndex - 1; i >= 0; i--) {
                            if (enemies[i].isAlive()) {
                                System.out.println("Attacking previous alive enemy: " + enemies[i].getName());
                                attackEnemy(enemies[i]);
                                foundAliveEnemy = true;
                                break;
                            }
                        }
                    }

                    if (!foundAliveEnemy) {
                        System.out.println("No other alive enemies to attack.");
                    }
                } else {
                    attackEnemy(enemies[targetIndex]);
                }
                break;
            } else if (action == 2) {
                if (element.equals("Water")) {
                    heal(20);
                    break;
                } else if (element.equals("Earth")) {
                    //defense
                    break;
                } else {
                    System.out.println("Invalid action.");
                }
            } else {
                System.out.println("Invalid action.");
            }
        }
    }

    public void attackEnemy(Enemy enemy) {
        int damage = this.attack;
        enemy.takeDamage(damage);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage.");
    }

    public void heal(int percentage) {
        int healAmount = this.health * percentage / 100;
        this.health += healAmount;
        System.out.println(this.name + " heals for " + healAmount + " health.");
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " takes " + damage + " damage. Remaining health: " + this.health);
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
