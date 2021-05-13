package ProjectPPJ.projectppj;
import java.util.Random;

public class Monster {
    private final String monsterName;
    private final int monsterMaxHealth; //Maximum amount of health a monster can have
    private int monsterHealth; //Current health of the monster
    private final int monsterMaxDamage; //Maximum amount of damage a monster can do
    private static final Random random = new Random(); //Some random random for randomising random values

    public Monster(String monsterName, int monsterMaxHealth, int monsterMaxDamage){
        this.monsterName = monsterName;
        this.monsterMaxHealth = monsterMaxHealth;
        this.monsterHealth = monsterMaxHealth; //Current health is at first equal to max health
        this.monsterMaxDamage = monsterMaxDamage;
    }

    //Method for creating a random monster to encounter, with all of the stats etc.
    public static Monster newMonsterRandom(){
        int rand = random.nextInt(5);
        Monster monster = null;
        switch(rand){
            case 0:
                monster = bandit();
                break;
            case 1:
                monster = smallWolf();
                break;
            case 2:
                monster = bigWolf();
                break;
            case 3:
                monster = angryPeasant();
                break;
            case 4:
                monster = weirdPlant();
                break;
        }
        return monster;
    }

    //name, max health, max damage
    public static Monster bandit(){
        return new Monster("Bandit", 15, 4);
    }

    public static Monster smallWolf(){
        return new Monster("Small Wolf", 25,  7);
    }

    public static Monster bigWolf(){
        return new Monster("Big Wolf", 40, 12);
    }

    public static Monster dragon(){
        return new Monster("Dragon", 90, 20);
    }

    public static Monster angryPeasant(){return new Monster( "Angry Peasant", 10, 5);}

    public static Monster weirdPlant(){return new Monster( "Weird Plant", 20, 10);}

    public int getmonsterHealth(){
        return this.monsterHealth;
    }

    public boolean isDead(){
        return this.monsterHealth <= 0;
    }

    public String getMonsterName(){
        return this.monsterName;
    }
    //Method for monster dealing damage to a player
    public int monsterAttack(){
        return random.nextInt(monsterMaxDamage);
    }

    public int getMonsterHealthMinusRangedDamage(Player player, Monster monster){
        int playerDamage = player.playerRangedAttack();
        monsterHealth -= playerDamage;
        Interface.monsterHitMessage(playerDamage, monster);
        return monsterHealth;
    }

    public int getMonsterHealthMinusMeleeDamage(Player player, Monster monster){
        int playerDamage = player.playerMeleeAttack();
        monsterHealth -=playerDamage;
        Interface.monsterHitMessage(playerDamage, monster);
        return monsterHealth;
    }

    @Override
    public String toString(){
        return monsterName;
    }

}

