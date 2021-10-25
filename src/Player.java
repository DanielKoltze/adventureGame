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
    public void takeItem(Item item){
        items.add(item);
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
}
