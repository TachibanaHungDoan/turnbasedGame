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

    public void applyElementResonance() {
        if (elementResonance.waterfalls) {
            for (Player player : team) {
                if (player != null && player.isAlive()) {
                    int hpIncrease = player.maxHealth * 20 / 100;
                    player.health += hpIncrease;
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
