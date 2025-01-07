public class AllyTeam {
    Player[] team;
    ElementResonance elementResonance;

    public AllyTeam() {
        team = new Player[0];
        elementResonance = new ElementResonance();
    }

    public void addPlayerToTeam(Player player) {
        Player[] newTeam = new Player[team.length + 1];
        for (int i = 0; i < team.length; i++) {
            newTeam[i] = team[i];
        }
        newTeam[team.length] = player;
        team = newTeam;
        elementResonance.addElement(player.element);
        applyElementResonance();
    }

    public Player getMainCharacter() {
        return team[0];
    }

    public void applyElementResonance() {
        if (elementResonance.waterfalls) {
            System.out.println("Water and Earth Resonance: Increase 20% of max hp!");
            for (Player player : team) {
                if (player != null && player.isAlive()) {
                    int hpIncrease = player.maxHealth * 20 / 100;
                    player.health += hpIncrease;
                }
            }
        }

        if(elementResonance.vaporize) {
            for (Player player : team) {
                if (player != null && player.isAlive()) {
                    player.criticalHitChance = 0.6;
                }
            }
        }

        if (elementResonance.blazing) {
            for (Player player : team) {
                if (player != null && player.isAlive()) {
                    int atkIncrease = player.attack * 20 / 100;
                    player.attack += atkIncrease;
                }
            }
        }

        if (elementResonance.sandstorm) {
            for (Player player : team) {
                if (player != null && player.isAlive()) {
                    int defIncrease = player.defense * 20 / 100;
                    player.defense += defIncrease;
                }
            }
        }
    }

}
