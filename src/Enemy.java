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

    public int getAttack() {
        return this.attack;
    }

    public void takeDamage(int damage) {
        int damageTaken = (int) Math.ceil( (double) damage / ((this.defense + 100) / 100.0));
        this.health -= damageTaken;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }
}

