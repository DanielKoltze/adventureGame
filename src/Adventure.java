import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    public void run() throws InterruptedException {
        boolean gameIsRunning = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to KEA!\n\nIn this game you play the character of an introverted student whose greatest fear is the social contact with other people.\nYour mission is to graduate school with the least amount of social interaction as possible. Type 'help' if you need guidance.\n\nGood luck!\n\n");
        Thread.sleep(2000);
        player.setCurrentRoom(map.getRoom1());
        System.out.println(player.getCurrentRoomDescription());

        while (gameIsRunning) {
            String tekst = sc.nextLine().trim();
            if (tekst.equals("look")) {
                System.out.println("Looking around");
                Thread.sleep(1000);
                System.out.println("You are currently in " + player.getCurrentRoomName());
                printItems();
                System.out.println();
            } else if (tekst.equals("exit")) {
                System.out.println("You have exited");
                gameIsRunning = false;
            }else if (tekst.equals("help")) {
                System.out.println("\nTo move around type either one of these commands:\n " +
                    "\nNorth: go north/ north/ n" +
                    "\nSouth: go south/ south/ s" +
                    "\nEast: go east/ east/ e" +
                    "\nWest: go west/ west/ w" +
                    "\n\nTry one of them out now!");
            } else if ((tekst.equalsIgnoreCase("east") || tekst.equalsIgnoreCase("e") || tekst.equalsIgnoreCase("go east")) && player.getEastRoom() != null) {
                // go east
                    walking("east");
                    player.goEast();
                    System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                } else if ((tekst.equalsIgnoreCase("south") || tekst.equalsIgnoreCase("s") || tekst.equalsIgnoreCase("go south")) && player.getSouthRoom() != null) {
                // go south
                    walking("south");
                    player.goSouth();
                    System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                }
              else if ((tekst.equalsIgnoreCase("west") || tekst.equalsIgnoreCase("w") || tekst.equalsIgnoreCase("go west"))&& player.getWestRoom() != null) {
                // go west
                    walking("west");
                    player.goWest();
                    System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());

             } else if ((tekst.equalsIgnoreCase("north") || tekst.equalsIgnoreCase("n") || tekst.equalsIgnoreCase("go north"))&& player.getNorthRoom() != null) {
                // go north
                    walking("north");
                    player.goNorth();
                    System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
            }else if(tekst.contains("take")){
                tekst = tekst.substring(5);
                takeItem(tekst);
            }else if(tekst.equals("inventory")){
                System.out.print("Your inventory: ");
                for (int i = 0; i < player.getItems().size(); i++) {
                    System.out.print(player.getItems().get(i) + " ");
                }
                System.out.println();
            }else if(tekst.contains("drop")){
                tekst = tekst.substring(5);
                takeItem(tekst);
                dropItem(tekst);
            }
              else{
                System.out.println("You search this way, but unfortunately it goes directly into a wall. Try another way!");
            }
            }
        }

    public void walking(String direction) throws InterruptedException {
        System.out.println("Leaving " + player.getCurrentRoomName() + " and walking " + direction + "...");
        Thread.sleep(1000);
    }

    //kan gøres pænere
    public void printItems(){
        System.out.print("You take a quick look around and find: ");
        for (int i = 0; i < player.getCurrentRoom().getItems().size(); i++) {
            System.out.print(player.getCurrentRoom().getItems().get(i) + " ");
        }
    }
    public void takeItem(String tekst){
        for (int i = 0; i < player.getCurrentRoom().getItems().size(); i++) {
          if(player.getCurrentRoom().getItems().get(i).getName().equals(tekst)){
              player.takeItem(player.getCurrentRoom().getItems().get(i));
              player.getCurrentRoom().getItems().remove(i);
          }
        }
    }
    public void dropItem(String tekst){
        for (int i = 0; i < player.getItems().size(); i++) {
            if(player.getItems().get(i).getName().equals(tekst)){
                player.getCurrentRoom().getItems().add(player.getItems().get(i));
                player.getItems().remove(i);
            }
        }
    }

}
