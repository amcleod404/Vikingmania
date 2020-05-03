
public class Player {
    private static String name;
    private static double skillPointsPilot;
    private static double skillPointsFighter;
    private static double skillPointsMerchant;
    private static double skillPointsEngineer;
    private static double totalSkillPoints;
    private static int numCredits;
    private static Difficulty difficultyLevel;
    private static MarketPlace currMarket;
    private static Island currIsland;
    private static Forge forge = new Forge();

    private static Ship ship = new Ship("Kingship", 15, 100, 100);
    private static double currentWealth = 500.00;

    public void setName(String s) {
        this.name = s;
    }

    public void setDifficultyLevel(Difficulty f) {
        this.difficultyLevel = f;
    }

    public void setTotalSkillPoints(double b) {
        this.totalSkillPoints = b;
    }

    public void setSkillPointsPilot(double b) {
        this.skillPointsPilot = b;
    }

    public void setSkillPointsFighter(double b) {
        this.skillPointsFighter = b;
    }

    public static void setSkillPointsMerchant(double b) {
        skillPointsMerchant = b;
    }

    public void setSkillPointsEngineer(double b) {
        this.skillPointsEngineer = b;
    }

    public double getSkillPointsEngineer() {
        return skillPointsEngineer;
    }

    public static double getSkillPointsEngineer2() {
        return skillPointsEngineer;
    }

    public double getTotalSkillPoints() {
        return totalSkillPoints;
    }

    public double getSkillPointsMerchant() {
        return skillPointsMerchant;
    }

    public static double getSkillPointsPilot() {
        return skillPointsPilot;
    }

    public static double getSkillPointsFighter() {
        return skillPointsFighter;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int num) {
        numCredits = num;
    }

    public static double getSkillPointsMerchant2() {
        return skillPointsMerchant;
    }

    public static double getCurrentWealth2() {
        return currentWealth;
    }

    public static Ship getShip() {
        return ship;
    }

    public static void setCurrentWealth(double x) {
        currentWealth = x;
    }

    public static void setCurr(MarketPlace mkt) {
        currMarket = mkt;
    }

    public static MarketPlace getCurrMarket() {
        return currMarket;
    }

    public static void setCurrIsland(Island isl) {
        currIsland = isl;
    }

    public static Island getCurrIsland() {
        return currIsland;
    }

    public static Forge getForge() {
        return forge;
    }

}
