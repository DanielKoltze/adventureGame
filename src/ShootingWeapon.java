public class ShootingWeapon extends Weapon{
    int ammo;
    ShootingWeapon(String name, int damage, int ammo) {
        super(name, damage);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }
    public int shoot(){
        ammo = ammo - 1;
        return ammo;
    }
}
