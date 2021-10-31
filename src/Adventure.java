import java.util.Scanner;
//Mangler stadig ammo
//kode er blevet spaghetti efter enemy er added
public class Adventure {
    private Map map = new Map();
    private Player player = new Player();
    private Enemy enemy = null;
    Scanner sc = new Scanner(System.in);
    String tekst;
    boolean gameIsRunning = true;
    public void run() throws InterruptedException {
        System.out.println("\nWelcome to KEA!\n\nIn this game you play the character of an introverted student whose " +
                "greatest fear is the social contact with other people.\nYour mission is to graduate school with the least" +
                " amount of social interaction as possible. Type 'help' if you need guidance.\n" +
                "\nGood luck!");
        dots(3);
        player.setCurrentRoom(map.getRoom1());
        System.out.println(player.getCurrentRoomDescription());
        printItemsInCurrentRoom();
        while (gameIsRunning) {
            tekst = sc.nextLine().trim();
            if (tekst.equals("look")) {
                System.out.println("Looking around...");
                Thread.sleep(1000);
                System.out.println(player.getCurrentRoomName());
                printItemsInCurrentRoom();
            } else if (tekst.equalsIgnoreCase("exit")) {
                System.out.println("You have exited");
                gameIsRunning = false;
            } else if (tekst.equalsIgnoreCase("help")) {
                System.out.println("\nTo move around type either one of these commands:\n " +
                        "\nNorth: go north/ north/ n" +
                        "\nSouth: go south/ south/ s" +
                        "\nEast: go east/ east/ e" +
                        "\nWest: go west/ west/ w" +
                        "\nTo pick something up type: 'take' + 'name of the item'" +
                        "\nTo drop the item again type: 'drop' + 'name of the item'" +
                        "\nType 'inventory' to see all your items");
                System.out.println("Type 'Attack' to attack enemy \n" +
                        "Type 'Status' to see your health and damage + enemy health and damage \n" +
                        "Type 'Auto attack' - you will attack until you or the enemy dies" + "\n\nTry one of them out now!\n");
            } else if ((tekst.equalsIgnoreCase("east")
                    || tekst.equalsIgnoreCase("e")
                    || tekst.equalsIgnoreCase("go east"))
                    && player.getEastRoom() != null) {
                // go east
                walking("east");
                player.goEast();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                checkEnemyOrNoEnemy();
            } else if ((tekst.equalsIgnoreCase("south")
                    || tekst.equalsIgnoreCase("s")
                    || tekst.equalsIgnoreCase("go south"))
                    && player.getSouthRoom() != null) {
                // go south
                walking("south");
                player.goSouth();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                checkEnemyOrNoEnemy();
            } else if ((tekst.equalsIgnoreCase("west")
                    || tekst.equalsIgnoreCase("w")
                    || tekst.equalsIgnoreCase("go west"))
                    && player.getWestRoom() != null) {
                // go west
                walking("west");
                player.goWest();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                checkEnemyOrNoEnemy();
            } else if ((tekst.equalsIgnoreCase("north")
                    || tekst.equalsIgnoreCase("n")
                    || tekst.equalsIgnoreCase("go north"))
                    && player.getNorthRoom() != null) {
                // go north
                walking("north");
                player.goNorth();
                System.out.println("Entering " + player.getCurrentRoomName() + ". " + player.getCurrentRoomDescription());
                checkEnemyOrNoEnemy();
            } else if (tekst.contains("take ")) {
                tekst = tekst.substring(5);
                takeItem(tekst);
            } else if (tekst.equals("inventory")) {
                if (player.getInventory().size() == 0) {
                    System.out.println("You have nothing in your inventory");
                } else {
                    System.out.print("Your inventory: ");
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        System.out.print(player.getInventory().get(i));
                        if (i == player.getInventory().size() - 2) {
                            System.out.print(" and ");
                        } else if (i <= player.getInventory().size() - 2) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
                if (player.checkWeapon()) {
                    System.out.println("You have a " + player.getWeapon().getName() + " equipped");
                } else {
                    System.out.println("You have no weapon equipped however you can still use your bare hands");
                }
            } else if (tekst.contains("drop ")) {
                tekst = tekst.substring(5);
                dropItem(tekst);
            } else if (tekst.equalsIgnoreCase("health")) {
                System.out.println("You currently have " + player.getHealth() + " health");
            } else if (tekst.contains("eat ")) {
                tekst = tekst.substring(4);
                eat(tekst);
            } else if (tekst.contains("drink ")) {
                tekst = tekst.substring(6);
                drink(tekst);
            } else if (tekst.contains("equip ")) {
                tekst = tekst.substring(6);
                eqiup(tekst);
                //man kan open chest hvis man har keys. så får man to gode items
            } else if (tekst.contains("open ")) {
                tekst = tekst.substring(5);
                openChest(tekst);
            } else if (tekst.equalsIgnoreCase("status")) {
                status();
            } else if (tekst.equalsIgnoreCase("attack")) {
                if (player.checkEnemy()) {
                    attackEnemy();
                    Thread.sleep(1000);
                    enemyAttack();
                } else {
                    System.out.println("There is no enemy in the room");
                }
            } else if (tekst.equalsIgnoreCase("auto attack")) {
                if (player.checkEnemy()) {
                    autoAttack();
                } else {
                    System.out.println("There is no enemy in the room");
                }
            } else {
                System.out.println("You search this way, but unfortunately it goes directly into a wall. Try another way!");
            }
            if (enemy != null) {
                //enemyAttack();
                if (enemy.getHealth() < 1) {
                    System.out.println("You have succesfully killed the enemy! Now u can loot the room");
                    player.getCurrentRoom().dropEnemyItem();
                    player.getCurrentRoom().setEnemy(null);
                    enemy = null;
                    printItemsInCurrentRoom();
                }
                if (player.getHealth() < 1) {
                    System.out.println("You died from your injuries");
                    gameIsRunning = false;
                }
            }
        }
    }
    private void checkEnemyOrNoEnemy() throws InterruptedException {
            if (player.checkEnemy()) {
                enemy = player.getEnemy();
                enemy.setPlayer(player);
                Thread.sleep(1000);
                System.out.println("You have encountered " + enemy.getDescription() + "!!! Kill it before it kills you");
                } else{
                printItemsInCurrentRoom();
                enemy = null;
                }

            }



    private void autoAttack() {
        while(player.getHealth() > 0 && enemy.getHealth() > 0){
            attackEnemy();
            enemyAttack();
        }
    }

    private void status() {
        if(player.checkEnemy()) {
            System.out.println("You have " + player.getWeapon().getDamage() + " damage and " + player.getHealth() + " health");
            System.out.println("Enemy has " + enemy.getWeapon().getDamage() + " damage and " + enemy.getHealth() + " health");
        } else{
            System.out.println("You have " + player.getWeapon().getDamage() + " damage and " + player.getHealth() + " health");
        }
    }

    private void enemyAttack() {
        if(enemy.getHealth() >= 1){
            enemy.attack();
            System.out.println("Enemy hit you for " + enemy.getWeapon().getDamage() + ". You have " + player.getHealth() + " health");
        }
    }


    private void attackEnemy() {
        boolean usesLeft = player.getWeapon().usesLeft();
        if(usesLeft){
            player.attack();
            System.out.println("You hit enemy for " + player.getWeapon().getDamage() + ". enemy has " + enemy.getHealth() + " health");
        }else{
            System.out.println("Your "+ player.getWeapon().getName() + " is out of ammo :(. Equip a new weapon");
        }

    }

    private void openChest(String tekst) {
        if(tekst.equalsIgnoreCase("Chest")){
            boolean canOpen = player.openChest();
            if(canOpen){
                System.out.println("You have successfully opened the chest!!!! \n" +
                        "Check your inventory to see what you have gotten");
            } else{
                System.out.println("You do not have a chest in your inventory");
            }
        } else{
            System.out.println("You cant open " + tekst);
        }
    }

    private void eqiup(String itemName) {
        boolean cases = player.equip(itemName);
        if(cases){
            System.out.println("You have equiped the " + itemName);
        }else{
            System.out.println("You do not have a " + itemName + " in your inventory");
        }
    }

    private void eat(String itemName) {
        boolean cases = player.eat(itemName);
        if(cases){
            System.out.println("You have eaten the " + itemName + " and your health is now " + player.getHealth());
        }else{
            System.out.println("You cant eat " + itemName);
        }
    }
    private void drink(String itemName) {
        boolean cases = player.drink(itemName);
        if(cases){
            System.out.println("You have drunk the " + itemName + " and your health is now " + player.getHealth());
        } else{
            System.out.println("You cant drink " + itemName);
        }
    }

    public void walking(String direction) throws InterruptedException {
        System.out.println("Leaving " + player.getCurrentRoomName() + " and walking " + direction + "...");
        Thread.sleep(1000);
    }
    //kan gøres pænere
    public void printItemsInCurrentRoom() {
        if (player.getCurrentRoomItemSize() == 0) {
            System.out.println("This room has no items");
        } else {
            System.out.print("You take a quick look around and find: ");
            for (int i = 0; i < player.getCurrentRoomItemSize(); i++) {
                System.out.print(player.getCurrentRoomItemList(i));
                if (i == player.getCurrentRoomItemSize() - 2) {
                    System.out.print(" and ");
                } else if (i <= player.getCurrentRoomItemSize() - 2) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public void takeItem(String tekst){
        boolean itemTaken = player.takeItem(tekst);
        if (itemTaken){
            System.out.println("You have picked up the " + tekst + " from the ground.");
        } else{
            System.out.println(tekst + " doesnt exist in this room");
        }
    }
    public void dropItem(String tekst){
        boolean itemDropped = player.dropItem(tekst);
        if (itemDropped){
            System.out.println("You dropped " +  tekst + " on the ground");
        } else{
            System.out.println(tekst + " doesnt exist in your inventory");
        }
    }
    public void dots(int tal) throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < tal; i++) {
            System.out.println("...");
            Thread.sleep(1000);
        }
        System.out.println();

    }
}


