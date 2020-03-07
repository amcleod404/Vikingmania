

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
    BOOKS;
    private double x;
    private double sellPrice;
    private Item() {
        Player player = new Player();
        this.x = 2 + this.toString().length() + 7;
        this.sellPrice = this.x - 5;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return this.name() + " Selling Price: " + (this.getX() - 5);
    }

}
