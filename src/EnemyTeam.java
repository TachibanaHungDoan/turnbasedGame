public class EnemyTeam {
    int numberOfEnemies;
    Enemy[] enemies;
    ElementResonance elementResonance;

    public EnemyTeam(int numberOfEnemies) {
        this.numberOfEnemies = numberOfEnemies;
        enemies = new Enemy[numberOfEnemies];
        elementResonance = new ElementResonance();
    }

    public void addEnemy(Enemy[] enemies) {
        this.enemies = enemies;
        for (int i = 0; i < enemies.length; i++) {
            elementResonance.addElement(enemies[i].element);
        }
        applyElementResonance();
    }

    public void applyElementResonance() {
        if (elementResonance.waterfalls) {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null && enemies[i].isAlive()) {
                    int hpIncrease = enemies[i].health * 20 / 100;
                    enemies[i].health += hpIncrease;
                }
            }
        }

        if (elementResonance.blazing) {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null && enemies[i].isAlive()) {
                    int atkIncrease = enemies[i].attack * 20 / 100;
                    enemies[i].attack += atkIncrease;
                }
            }
        }

        if (elementResonance.sandstorm) {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null && enemies[i].isAlive()) {
                    int defIncrease = enemies[i].defense * 20 / 100;
                    enemies[i].defense += defIncrease;
                }
            }
        }
    }

}
