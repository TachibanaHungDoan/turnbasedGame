import java.util.StringJoiner;

public class Enemy {
    String name;
    int attack;
    int health;
    int defense;
    String element;

    public Enemy(String name, int attack, int health, int defense, String element) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.defense = defense;
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean canAct() {
        return this.health > 0;
    }

    public int getAttack() {
        return this.attack;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
}

