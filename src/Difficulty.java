public enum Difficulty {
    ROOKIE(100, 500),
    BEGINNER(75, 500),
    INTERMEDIATE(50, 500),
    ADVANCED(25, 500);

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
