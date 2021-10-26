import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health = 100;


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public String getCurrentRoomItemList(int tal){
        return currentRoom.getItemByIndex(tal);
  }
    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public int getCurrentRoomItemSize(){
        return currentRoom.getItemSize();
    }
    public String getCurrentRoomDescription(){
        return currentRoom.getDescription();
    }
    public void goEast(){
        currentRoom = currentRoom.getEast();
    }
    public void goSouth(){
        currentRoom = currentRoom.getSouth();
    }
    public void goNorth(){
        currentRoom = currentRoom.getNorth();
    }
    public void goWest(){
        currentRoom = currentRoom.getWest();
    }
    public String getCurrentRoomName(){
        return currentRoom.getName();
    }
    public Room getSouthRoom(){
        return currentRoom.getSouth();
    }
    public Room getNorthRoom(){
        return currentRoom.getNorth();
    }
    public Room getWestRoom(){
        return currentRoom.getWest();
    }
    public Room getEastRoom(){
        return currentRoom.getEast();
    }


    public boolean takeItem(String itemName){
        Item item = currentRoom.findItem(itemName);
        if(item != null) {
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
        if(item != null) {
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
            if(inventory.get(i).getName().equalsIgnoreCase(itemName)){
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

    public boolean eat(String tekst){

        Food item = eatFood(tekst);

        if(item != null) {
            health = health + item.getConsumeHealth();
            return true;
        } else {
            return false;
        }
    }

    public Food eatFood(String tekst) {
        Food food = null;
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(tekst) && inventory.get(i) instanceof Food) {
                food = (Food) inventory.get(i);
                return food;
            }
        }
        return food;
    }
}
