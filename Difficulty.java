public enum Difficulty {
    ROOKIE (100),
    BEGINNER(75),
    INTERMEDIATE(50),
    ADVANCED(25);

    private double skillPointAllocation;

    Difficulty(double x){
        this.skillPointAllocation = x;
    }

    public double getSkillPointAllocation() {
        return skillPointAllocation;
    }
}
