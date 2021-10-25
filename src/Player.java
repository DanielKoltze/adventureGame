import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public String getCurrentRoomItemList(int tal){
        return currentRoom.getItemByIndex(tal);
  }
    public ArrayList getCurrentroomItems(){
        return currentRoom.getItems();
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public ArrayList<Item> getItems() {
        return items;
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
    public ArrayList<Item> getItemsInRoom(){
        return currentRoom.getItems();
    }


    public boolean takeItem(String itemName){
        Item item = currentRoom.findItem(itemName);
        if(item != null) {
            items.add(item);
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
            items.remove(item);
            return true;
        } else {
            return false;
        }
    }
    public Item findItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equalsIgnoreCase(itemName)){
                return items.get(i);
            }
        }
        return null;
    }


}
