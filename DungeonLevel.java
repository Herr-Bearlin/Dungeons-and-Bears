package ProjectPPJ.projectppj;

import java.util.Random;

public class DungeonLevel {
    //attributes for moving
    public static boolean northExists = false;
    public static boolean southExists = false;
    public static boolean westExists = false;
    public static boolean eastExists = false;
//creating an array of 10x10 references to DungeonRooms


    public static DungeonRoom[][] newDungeon(Player player){
        DungeonRoom[][] currentDungeon = new DungeonRoom[11][11];
        for (int x = 0; x < currentDungeon.length; x++){
            for (int y = 0; y < currentDungeon.length; y++){
                currentDungeon[x][y] = DungeonRoom.newRoom();
            }
        }
        player.setCurrentDungeonRoom(currentDungeon[5][5]); //X = 5, Y = 5, it's the middle square;
        return currentDungeon;
    }
    public boolean dungeonRoomExists(int x, int y){
        return (rowExists(x)) && (columnExists(y));
    }

    public boolean columnExists(int y){
        return (y >= 0) && (y <= 10);
    }

    public boolean rowExists(int x){
        return (x >= 0) && (x <= 10);
    }


    public void movement(Player player){
        northExists = dungeonRoomExists( player.getCurrentX(), player.getCurrentY() + 1);
        southExists = dungeonRoomExists( player.getCurrentX(), player.getCurrentY() - 1);
        westExists = dungeonRoomExists( player.getCurrentX() - 1, player.getCurrentY() );
        eastExists = dungeonRoomExists( player.getCurrentX() + 1, player.getCurrentY() );
        Interface.playerMoveAction(player);
    }
    //method which starts the battle as instructed in the Interface class
    public void battleInDungeonRoom(Player player, Monster monster, DungeonRoom[][] currentDungeon) {
        Interface.enteringRoom(player, currentDungeon[player.getCurrentX()][player.getCurrentY()]);
        Interface.battle(player, monster, currentDungeon[player.getCurrentX()][player.getCurrentY()]);
        //this is all about finding random loot in the room
        int randomLoot = Main.random.nextInt(4);
        switch (randomLoot) {
            case 0:
                System.out.println("There is no loot to be found in this room. Unlucky!");
                break;
            case 1:
                System.out.println("Someone or something left some food in this room. You pack it up.");
                player.setFoodAmount(player.getFoodAmount() + 1);
                break;
            case 2:
                System.out.println("There is something left on the ground, a shiny red crystal. You feel it can " +
                        "help you get stronger and fight better in melee combat! A good find!");
                player.setMeleeEnhancerAmount(player.getMeleeEnhancerAmount() + 1);
                break;
            case 3:
                System.out.println("There is something left on the ground, a weird-looking green crystal. You think it can " +
                        "help you with ranged precision and fight better in ranged combat! A lucky find!");
                player.setRangedEnhancerAmount(player.getRangedEnhancerAmount() + 1);
                break;
        }
    }

    public void battleMovementStop(Player player, DungeonRoom[][] currentDungeon) {
        while(!player.isDead()){
            if (!currentDungeon[player.getCurrentX()][player.getCurrentY()].getMonster().isDead() && !player.isDead()) {
                battleInDungeonRoom(player, currentDungeon[player.getCurrentX()][player.getCurrentY()].getMonster(), Main.playingDungeonRoom);
            } else if (!player.isDead()) {
                movement(player);
            }
        }
    }


    public static boolean doesNorthExist(){
        return northExists;
    }

    public static boolean doesSouthExist(){
        return southExists;
    }

    public static boolean doesWestExist(){
        return westExists;
    }

    public static boolean doesEastExist(){
        return eastExists;
    }

}

/*int randomLoot = random.nextInt(4);
        switch(randomLoot){
            case 0:
                System.out.println("There is no loot to be found in this room. Unlucky!");
            case 1:
                System.out.println("Someone or something left some food in this room. You pack it up.");
                player.setFoodAmount(player.getFoodAmount() + 1);
            case 2:
                System.out.println("There is something left on the ground, a shiny red crystal. You feel it can " +
                        "help you get stronger and fight better in melee combat! A good find!");
                player.setMeleeEnhancerAmount(player.getMeleeEnhancerAmount() + 1);
            case 3:
                System.out.println("There is something left on the ground, a weird-looking green crystal. You think it can " +
                        "help you with ranged precision and fight better in ranged combat! A lucky find!");
                player.setRangedEnhancerAmount(player.getRangedEnhancerAmount() + 1);
        }

 */