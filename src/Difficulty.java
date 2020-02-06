public enum Difficulty {
    ROOKIE(100, 800),
    BEGINNER(75, 600),
    INTERMEDIATE(50, 400),
    ADVANCED(25, 200);

    private double skillPointAllocation;
    private int numCredits;

    Difficulty(double x, int num) {
        this.skillPointAllocation = x;
        this.numCredits = num;
    }

    public double getSkillPointAllocation() {
        return skillPointAllocation;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public String toString() {
        return this.name();
    }
}
