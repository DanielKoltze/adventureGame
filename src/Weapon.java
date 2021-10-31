public abstract class Weapon extends Item{
    private int damage;

    Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
    public boolean usesLeft(){
        return true;
    }

}
