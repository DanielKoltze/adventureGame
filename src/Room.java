public class Room {
    Room east = null;
    Room west = null;
    Room south = null;
    Room north = null;
    String description;
    String name = null;
    Room currentRoom = null;


    public Room(String name, String desciption, Room north, Room east, Room south, Room west){
        this.description = desciption;
        this.name= name;
        this.north = north;
        this.east = east;
        this.west = west;
        this.south = south;

    }


    public Room getEast() throws InterruptedException {
        System.out.println(name + " walking east...");
        Thread.sleep(1000);
        return east;
    }

    public Room getNorth() throws InterruptedException {
        System.out.println(name + " walking north...");
        Thread.sleep(1000);
        return  north;
    }

    public Room getWest() throws InterruptedException {
        System.out.println(name + " walking west...");
        Thread.sleep(1000);
        return west;
    }

    public Room getSouth() throws InterruptedException {
        System.out.println(name + " walking south...");
        Thread.sleep(1000);
        return south;
    }

    public String getDescription() {
        return description;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }
}
