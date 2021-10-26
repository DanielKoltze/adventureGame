import java.util.ArrayList;

public class Map {
    private Room room1;
    private Room room2;
    private Room room3;
    private Room room4;
    private Room room5;
    private Room room6;
    private Room room7;
    private Room room8;
    private Room room9;


    Map(){
        init();
    }
    public void init(){
        //Sætter vores run op og kører med metoden i konstruktør
        room1 = new Room("Hallway", "You have entered the hallway of the school you're attending. Many foes lies lurking around. Be careful!");
        room2 = new Room("Staircase", "Be careful when walking up the staircase. It is almost inevitable to meet another student.");
        room3 = new Room("Codelab", "Many students vacay the room, and getting a spot alone may prove to be difficult");
        room4 = new Room("Elevator", "Empty right now. Press the 'close door' button fast!");
        room5 = new Room("Examination room", "The dark room seems to be empty. Maybe you should look around.");
        room6 = new Room("Design building", "This building is full of wild designers. Be careful.");
        room7 = new Room("Classroom", "A few students hang around here. Be careful not to make eye contact.");
        room8 = new Room("Courtyard", "Full of smokers");
        room9 = new Room("Fredagsbar", "Over-crowded place with a way too long queue for buying beverages.");
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setEast(room8);
        room7.setNorth(room4);
        room8.setWest(room7);
        room8.setEast(room9);
        room8.setNorth(room5);
        room9.setNorth(room6);
        room9.setWest(room8);

        room1.addItemToRoom(new Item("Wallet"));
        room1.addItemToRoom(new Item("Studentcard"));
        room1.addItemToRoom(new Food("Apple",5));
        room2.addItemToRoom(new Drink("Coffee", 5));
        room2.addItemToRoom(new Item("Socks"));
        room3.addItemToRoom(new Item("Computer"));
        room3.addItemToRoom(new Drink("Sanitizer", -50));
        room4.addItemToRoom(new Item("Keys"));
        room5.addItemToRoom(new Item ("Jacket"));
        room6.addItemToRoom(new Item("Paper"));
        room6.addItemToRoom(new Food("Cake", 10));
        room7.addItemToRoom(new Item("Book"));
        room7.addItemToRoom(new Item("Laptop"));
        room8.addItemToRoom(new Food("Proteinbar", 20));
        room8.addItemToRoom(new Item("Keychain"));
        room9.addItemToRoom(new Item("Chair"));
        room9.addItemToRoom(new Drink("Beer", 10));


    }
    public Room getRoom1() {
        return room1;
    }
}
