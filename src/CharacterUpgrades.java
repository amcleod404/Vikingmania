public enum CharacterUpgrades {
   AFTERLIFE(1000),
    INVISIBILITY(1500),
    MAXSKILL(999),
    INVESTOR(800),
    VIKINGGOD(100000),
   ALWAYS_DRUNK(1);

    private double x;

    private CharacterUpgrades(double x) {

        this.x = x;
    }

    public double getX() {
        return x;
    }
}

