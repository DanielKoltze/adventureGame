import java.util.Scanner;

public class Adventure {
    String tekst;
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;
    Room currentRoom;
    Adventure(){
        init();
    }
    public void run() throws InterruptedException {
        boolean gameIsRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my adventure game");
        Thread.sleep(1000);
        currentRoom = room1;
        System.out.println(currentRoom.getDescription());

        while (gameIsRunning) {
            tekst = sc.next();
            if (tekst.equals("look")) {
                System.out.println(currentRoom.getDescription());

                continue;
            }
            if (tekst.equals("exit")) {
                System.out.println("You have exited");
                gameIsRunning = false;
                continue;
            }
            if (tekst.equals("help")) {
                //skriv hvilke kommandoer der er
                continue;
            }

            if (currentRoom == room1) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room1.getEast();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) {
                    currentRoom = room1.getSouth();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else {
                    System.out.println("you cant walk this way");
                }

            }
            if (currentRoom == room2) {
                if (tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) {
                    currentRoom = room2.getEast();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else if (tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west")) {
                    currentRoom = room2.getWest();
                    System.out.println(currentRoom.getDescription());
                    continue;
                } else {
                    System.out.println("you cant walk this way");
                }

            }

        }
    }
    public void init(){
        room1 = new Room("Room1", "room1 description",null,null,null,null);
        room2 = new Room("Room2", "room2 description",null,null,null,null);
        room3 = new Room("Room3", "room3 description",null,null,null,null);
        room4 = new Room("Room4", "room4 description",null,null,null,null);
        room5 = new Room("Room5", "room5 description",null,null,null,null);
        room6 = new Room("Room6", "room6 description",null,null,null,null);
        room7 = new Room("Room7", "room7 description",null,null,null,null);
        room8 = new Room("Room8", "room8 description",null,null,null,null);
        room9 = new Room("Room9", "room9 description",null,null,null,null);
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
        room9.setNorth(room6);
        room9.setWest(room8);
    }

    public static void main(String[] args) throws InterruptedException {
        Adventure adventure = new Adventure();
        adventure.run();
    }

}
