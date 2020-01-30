public class Player {
    private String name;
    private static double skillPointsPilot;
    private static double skillPointsFighter;
    private static double skillPointsMerchant;
    private static double skillPointsEngineer;
    private static double totalSkillPoints;
    private static Difficulty difficultyLevel;

    public void setName(String s) {
        this.name = s;
    }

    public void setDifficultyLevel(Difficulty f) {
        this.difficultyLevel = f;
    }
    public void setTotalSkillPoints (double b) {
        this.totalSkillPoints = b;
    }
    public void setSkillPointsPilot(double b){
        this.skillPointsPilot = b;
    }
    public void setSkillPointsFighter(double b){
        this.skillPointsFighter = b;
    }
    public void setSkillPointsMerchant(double b){
        this.skillPointsMerchant = b;
    }
    public void setSkillPointsEngineer(double b){
        this.skillPointsEngineer = b;
    }

    public double getSkillPointsEngineer() {
        return skillPointsEngineer;
    }

    public double getTotalSkillPoints() {
        return totalSkillPoints;
    }

    public double getSkillPointsMerchant() {
        return skillPointsMerchant;
    }

    public double getSkillPointsPilot() {
        return skillPointsPilot;
    }

    public double getSkillPointsFighter() {
        return skillPointsFighter;
    }

    public String getName() {
        return name;
    }
}
