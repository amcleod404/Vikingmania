

public enum  Item  {
    SWORD,
    HEALTHPOTION,
    METAL,
    SLEDGEHAMMER,
    WOOD,
    KNIFE,
    UNIFORM,
    AXE,
    SILVER,
    BRONZE,
    IRON,
    PORKCHOP,
    SKYR,
    DIAMOND,
    HELMET,
    BREASTPLATE,
    GAUNTLET,
    LEGARMOR,
    CHAINS,
    BOOTS,
    BOW,
    ARROW,
    RUM,
    BOOKS,
    AETHER;
    private double x;
    private double sellPrice;
    private double specialPrice;
    private Item() {
        Player player = new Player();
        this.x = 2 + this.toString().length() + 7;
        this.sellPrice = this.x - 5;
        this.specialPrice = 432;
    }

    public double getX() {
        return x;
    }

    public double getSellPrice() {
        return sellPrice;
    }
    public double getSpecialPrice() {
        return this.specialPrice;
    }

    @Override
    public String toString() {
        return this.name() + " Selling Price: " + (this.getX() - 5);
    }

}
