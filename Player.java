/**
 * A class that represents the Player and his/her attributes such as name, 
 * health, damage and level.
 */

public class Player {

    private String playerName;
    private int playerCurrHealth;
    private int playerMaxHealth;
    private int playerDamage;
    private int playerLevel;

    // Default Player Creation Constants
    public final static int PLAYER_STARTING_LEVEL = 1;
    private final static int MAX_HEALTH_MULTIPLIER = 3;
    private final static int MAX_HEALTH_ADDITION = 17;
    
    /**
     * Default player constructor
     */
    public Player() {
        this.playerName = null;
        this.playerMaxHealth = 0;
        this.playerCurrHealth = 0;
        this.playerDamage = 0;
        this.playerLevel = 0;
    }

    /**
     * Player constructor
     * @param playerName string name of player
     * @param playerMaxHealth int maximum health of player
     * @param playerDamage int damage of player
     */
    public Player(String playerName, int playerMaxHealth, int playerDamage) {
        this.playerName = playerName;
        this.playerMaxHealth = playerMaxHealth;
        this.playerCurrHealth = playerMaxHealth;
        this.playerDamage = playerDamage;
    }

    /**
     * Restores player's health to full
     */
    public void restoreToFullHP() {
        this.playerCurrHealth = this.playerMaxHealth;
    }

    // Accessor Methods for player
    public String getPlayerName() {
        return this.playerName;
    }
    public int getPlayerCurrHealth() {
        return this.playerCurrHealth;
    }
    public int getPlayerMaxHealth() {
        return this.playerMaxHealth;
    }
    public int getPlayerDamage() {
        return this.playerDamage;
    }
    public int getPlayerLevel() {
        return this.playerLevel;
    }

    // Mutator Methods for player
    public void setPlayerCurrHealth(int playerHealth) {
        this.playerCurrHealth = playerHealth;
    }
    public void setPlayerMaxHealth() {
        this.playerMaxHealth = (playerLevel * MAX_HEALTH_MULTIPLIER) + MAX_HEALTH_ADDITION;  
    }   
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setPlayerDamage() {
        this.playerDamage = playerLevel + 1;
    }
    public void setDefaultPlayerLevel() {
        this.playerLevel = PLAYER_STARTING_LEVEL;
    }
}
