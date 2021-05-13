package ProjectPPJ.projectppj;
import java.util.Random;
public class Player {
    private final String playerName;
    private final int playerMaxHealth;//Maximum amount of health a player can have
    private int playerHealth;//Current amount of health of a player
    private int playerMaxMeleeDamage;//Maximum amount of damage a player can do in an attack
    private int playerMaxRangedDamage;
    private int currentX; //Current coordinate of the room (X,...)
    private int currentY;//Current coordinate of the room (...,Y)
    private int foodAmount;//Amount of food carried by a gamer
    private int meleeEnhancerAmount;
    private int rangedEnhancerAmount;
    private DungeonRoom currentDungeonRoom;
    private static final Random random = new Random();

    public Player(String playerName, int playerMaxHealth, int playerMaxMeleeDamage, int playerMaxRangedDamage, int foodAmount, int meleeEnhancerAmount, int rangedEnhancerAmount){
        this.playerName = playerName;
        this.playerMaxHealth = playerMaxHealth;
        this.playerHealth = playerMaxHealth;
        this.playerMaxMeleeDamage = playerMaxMeleeDamage;
        this.playerMaxRangedDamage = playerMaxRangedDamage;
        this.currentX =5;
        this.currentY = 5;
        this.foodAmount = foodAmount;
        this.meleeEnhancerAmount = meleeEnhancerAmount;
        this.rangedEnhancerAmount = rangedEnhancerAmount;
    }


    //creating a player's character, 3 different classes
    public static Player knight() {
        return new Player("Knight", 115, 10, 2, 2 , 0, 0);
    }

    public static Player ranger() {
        return new Player( "Ranger", 95, 8, 6, 4, 0, 0);
    }

    public static Player adventurer(){
        return new Player( "Adventurer", 105, 7, 3, 6, 0, 0);
    }

    //things to do in a fight, attack with a melee weapon, attack with a ranged weapon, eat food to heal
    public int playerMeleeAttack(){
        return random.nextInt(playerMaxMeleeDamage);
    }

    public int playerRangedAttack(){
        return random.nextInt(playerMaxRangedDamage);
    }

    public int getPlayerHealthMinusDamage(Monster monster){
        int monsterDamage = monster.monsterAttack();
        playerHealth -= monsterDamage;
        Interface.playerHitMessage(monsterDamage, monster);
        return playerHealth;
    }

    //eating food allows player to get some health back during a fight
    public void eatFood(int foodAmount){
        if(foodAmount > 0){
            if(this.playerHealth == this.playerMaxHealth){
                System.out.println("/n You have maximum health. Food cannot be consumed");
            }
            int count = 0;
            for(int i = 0; i < 25 && this.playerHealth < this.playerMaxHealth; i++){
                this.playerHealth += 1;
                count ++;
            }
            System.out.println("You have consumed one piece of food. You have gained: " + count + "health back.");
            setFoodAmount(getFoodAmount());
            System.out.println("Your hp: " + playerHealth);
            System.out.println("You have: " + getFoodAmount() + " left");
        }else{
            System.out.println("There is no food left to eat!!! Find some!");
        }
    }

    public void enhanceMeleeDamage(int meleeEnhancerAmount){
        if(getMeleeEnhancerAmount() > 0){
            this.playerMaxMeleeDamage += 2;
            setMeleeEnhancerAmount(getMeleeEnhancerAmount() - 1);
            System.out.println("You have enhanced maximum damage dealt in melee combat by 2, it is now equal to: " + this.playerMaxMeleeDamage + ". You're getting stronger!");
        }
        if (getMeleeEnhancerAmount() == 0){
            System.out.println("You have no melee enhancers. Collect some to get stronger!");
        }
    }

    public void enhanceRangedDamage(int rangedEnhancerAmount){
        if(getRangedEnhancerAmount() > 0){
            this.playerMaxRangedDamage += 2;
            setRangedEnhancerAmount(getRangedEnhancerAmount() - 1);
            System.out.println("You have enhanced maximum damage dealt in ranged combat by 2, it is now equal to: " + this.playerMaxRangedDamage + ". You're becoming more precise!");
        }
        if (getRangedEnhancerAmount() == 0){
            System.out.println("You have no ranged enhancers. Collect some to become more precise!");
        }
    }

    public int getPlayerHealth(){
        return this.playerHealth;
    }

    public boolean isDead(){ return this.playerHealth <= 0; }

    public int getPlayerMaxMeleeDamage(){
        return this.playerMaxMeleeDamage;
    }

    public int getPlayerMaxRangedDamage(){
        return this.playerMaxRangedDamage;
    }

    public int getFoodAmount(){
        return foodAmount;
    }

    public int getMeleeEnhancerAmount(){ return meleeEnhancerAmount;}

    public int getRangedEnhancerAmount(){ return rangedEnhancerAmount;}

    public int getCurrentX(){
        return currentX;
    }

    public int getCurrentY(){
        return currentY;
    }

    //movement, current room

    public void  setCurrentY(int currentY){
        this.currentY = currentY;
    }

    public void  setCurrentX(int currentX){
        this.currentX = currentX;
    }

    public void setFoodAmount(int foodAmount){this.foodAmount = foodAmount;}

    public void setMeleeEnhancerAmount(int meleeEnhancerAmount){ this.meleeEnhancerAmount = meleeEnhancerAmount;}

    public void setRangedEnhancerAmount(int rangedEnhancerAmount){this.rangedEnhancerAmount = rangedEnhancerAmount;}



    public DungeonRoom getCurrentDungeonRoom() {
        return currentDungeonRoom;
    }

    public void setCurrentDungeonRoom(DungeonRoom dungeonRoom){
        currentDungeonRoom = dungeonRoom;
    }

    @Override
    public String toString(){
        return this.playerName;
    }

}
