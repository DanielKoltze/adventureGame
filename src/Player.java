import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> items = new ArrayList<>();


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
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
    public void lookForItem(){
        System.out.print("You take a quick look around and find: ");
        for (int i = 0; i < getCurrentRoom().getItems().size(); i++) {
            System.out.print(getCurrentRoom().getItems().get(i) + " ");
        }
    }
    public void takeTheItem(String tekst){
        for (int i = 0; i < getCurrentRoom().getItems().size(); i++) {
            if(getCurrentRoom().getItems().get(i).getName().equals(tekst)){
                takeItem(getCurrentRoom().getItems().get(i));
                getCurrentRoom().getItems().remove(i);
            }
        }
    }
    public void dropItem(String tekst){
        for (int i = 0; i < getItems().size(); i++) {
            if(getItems().get(i).getName().equals(tekst)){
                getCurrentRoom().getItems().add(getItems().get(i));
                getItems().remove(i);
            }
        }
    }
}
