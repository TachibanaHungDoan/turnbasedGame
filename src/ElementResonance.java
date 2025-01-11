public class ElementResonance {
    String[] teamElements;
    boolean waterfalls = false; //water + earth
    boolean vaporize = false; //water + fire
    boolean blazing = false; //fire + air
    boolean sandstorm = false; //air + earth

    public ElementResonance() {
        teamElements = new String[0];
    }

    public void addElement(String element) {
        if (containsElement(element)) {
            checkResonance();
            return;
        }
        String[] newTeamElements = new String[teamElements.length + 1];
        for (int i = 0; i < teamElements.length; i++) {
            newTeamElements[i] = teamElements[i];
        }
        newTeamElements[teamElements.length] = element;
        teamElements = newTeamElements;
        checkResonance();
    }

    public boolean containsElement(String element) {
        for (String teamElement : teamElements) {
            if (teamElement != null && teamElement.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void checkResonance() {
        waterfalls = containsElement("Water") && containsElement("L");
        vaporize = containsElement("Water") && containsElement("Fire");
        blazing = containsElement("Fire") && containsElement("Air");
        sandstorm = containsElement("Air") && containsElement("Earth");
    }
}
