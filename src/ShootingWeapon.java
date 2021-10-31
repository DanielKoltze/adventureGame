public class ShootingWeapon extends Weapon{
    int ammo;
    ShootingWeapon(String name, int damage, int ammo) {
        super(name, damage);
        this.ammo = ammo;
    }
    @Override
    public boolean usesLeft() {
        if (ammo > 0) {
            decreaseAmmo();
            return true;
        } else {
            return false;
        }
    }
    public void decreaseAmmo(){
        ammo--;
    }

    public int getAmmo() {
        return ammo;
    }
}
