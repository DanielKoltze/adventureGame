public class Enemy {
    private final String name;
    private final String description;
    private final Weapon weapon;
    private int health;
    private Player player = new Player();
    Enemy(String name, String description, int health, Weapon weapon){
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;

    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void attack() {
        player.setHealth(player.getHealth() - weapon.getDamage());
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
