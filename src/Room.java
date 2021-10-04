public class Room {
    private Room east = null;
    private Room west = null;
    private Room south = null;
    private Room north = null;
    private String description;
    private String name;


    public Room(String name, String description){
        this.description = description;
        this.name= name;
    }

    public Room getEast() throws InterruptedException {
        System.out.println("Leaving " + name + " and walking east...");
        Thread.sleep(1000);
        return east;
    }

    public Room getNorth() throws InterruptedException {
        System.out.println("Leaving " + name + " and walking north...");
        Thread.sleep(1000);
        return  north;
    }

    public Room getWest() throws InterruptedException {
        System.out.println("Leaving " + name + " and walking west...");
        Thread.sleep(1000);
        return west;
    }

    public Room getSouth() throws InterruptedException {
        System.out.println("Leaving " + name + " and walking south...");
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

    public String getName() {return name;}
}
