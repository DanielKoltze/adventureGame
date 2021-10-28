import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;
    private Weapon weapon = new MeleeWeapon("Hands",2) {
    };

    public Weapon getWeapon() {
        return weapon;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getCurrentRoomItemList(int tal) {
        return currentRoom.getItemByIndex(tal);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getCurrentRoomItemSize() {
        return currentRoom.getItemSize();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public void goEast() {
        currentRoom = currentRoom.getEast();
    }

    public void goSouth() {
        currentRoom = currentRoom.getSouth();
    }

    public void goNorth() {
        currentRoom = currentRoom.getNorth();
    }

    public void goWest() {
        currentRoom = currentRoom.getWest();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
    }

    public Room getSouthRoom() {
        return currentRoom.getSouth();
    }

    public Room getNorthRoom() {
        return currentRoom.getNorth();
    }

    public Room getWestRoom() {
        return currentRoom.getWest();
    }

    public Room getEastRoom() {
        return currentRoom.getEast();
    }


    public boolean takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            return true;
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        // find item (in room) with itemName
        Item item = findItem(itemName);

        // if exists:
        if (item != null) {
            //  - remove from room
            currentRoom.addItem(item);
            //  - add to inventory
            inventory.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public Item findItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public boolean drink(String itemName) {
        Drink item;
        for (int i = 0; i < inventory.size(); i++) {
            //tjekker først inventory og ellers tjekker den room klassen og der skulle være en food
            if (inventory.get(i).getName().equalsIgnoreCase(itemName) && (inventory.get(i) instanceof Drink)) {
                item = (Drink) inventory.get(i);
                health = health + item.getConsumeHealth();
                inventory.remove(item);
                return true;
            }
        }
        item = currentRoom.checkDrink(itemName);
        if (item != null) {
            health = health + item.getConsumeHealth();
            return true;
        } else {
            return false;
        }
    }

    public boolean eat(String itemName) {
        Food item;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(itemName) && (inventory.get(i) instanceof Food)) {
                item = (Food) inventory.get(i);
                health = health + item.getConsumeHealth();
                inventory.remove(item);
                return true;
            }
        }
        item = currentRoom.checkEat(itemName);
        if (item != null) {
            health = health + item.getConsumeHealth();
            return true;
        } else {
            return false;
        }

    }
    public boolean equip(String itemName){
        Weapon item;
        for (int i = 0; i < inventory.size(); i++) {
        if (inventory.get(i).getName().equalsIgnoreCase(itemName) && (inventory.get(i) instanceof Weapon)) {
            if(weapon.getName().equalsIgnoreCase("hands")){
                item = (Weapon) inventory.get(i);
                weapon = item;
                inventory.remove(item);
                return true;
            }else{
                item = (Weapon) inventory.get(i);
                inventory.add(weapon);
                weapon = item;
                inventory.remove(item);
                return true;
            }
        }
    }
        return false;
    }

    public boolean openChest() {
        Item keys = findItem("Keys");
        Item chest = findItem("Chest");
        if(keys != null && chest != null ){
            inventory.remove(chest);
            inventory.remove(keys);
            inventory.add(new Food("Lasagne", 100));
            inventory.add(new ShootingWeapon("Gun", 60,3));
            return true;
        }
        return false;
    }

    public Boolean checkWeapon() {
        if(weapon.getName().equalsIgnoreCase("hands")){
            return false;
        }else{
            return true;
        }
    }

    public boolean checkEnemy() {
        return currentRoom.checkEnemyInRoom();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getEnemyHealth() {
        return currentRoom.getEnemyHealth();
    }

    public void attack() {
        currentRoom.getEnemy().setHealth(getEnemyHealth() - weapon.getDamage());
        //ammo hvis skydevåben
    }

    public Enemy getEnemy() {
        return currentRoom.getEnemy();
    }
}

