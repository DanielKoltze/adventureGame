public class Player {
    private Room currentRoom;

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }




    public Room getCurrentRoom() {
        return currentRoom;
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
}
