/**
 * A class that represents the battle between player and monster in the world
 */

public class Battle {
    
    public boolean battleOver;  // Becomes true if battle between player and monster has ended

    // Player Stats
    private Player player;
    private String playerName;
    private int playerCurrHealth;
    private int playerMaxHealth;
    private int playerDamage;

    // Monster Stats
    private Monster monster;
    private String monsterName;
    private int monsterCurrHealth;
    private int monsterMaxHealth;
    private int monsterDamage;

    /**
     * Battle constructor
     * @param player player object
     * @param monster monster object
     */
    public Battle(Player player, Monster monster) {
        this.battleOver = false;
        this.player = player;
        this.playerName = player.getPlayerName();
        this.playerCurrHealth = player.getPlayerCurrHealth();
        this.playerMaxHealth = player.getPlayerMaxHealth();
        this.playerDamage = player.getPlayerDamage();
        this.monster = monster;
        this.monsterName = monster.getMonsterName();
        this.monsterCurrHealth = monster.getMonsterCurrHealth();
        this.monsterMaxHealth = monster.getMonsterMaxHealth();
        this.monsterDamage = monster.getMonsterDamage();
    }

    /**
     * Initiates the battle between the player and
     * monster and stops until there is a victor.
     */
    public void battleLoop() {
        while (!battleOver) {
            printStats();
            playerAttack(); // Player initiates first attack
            if (monsterCurrHealth > 0) {
                // Monster will attack if it is still alive 
                // after being attack by player
                monsterAttack();
                if (playerCurrHealth <= 0) {
                    // Player is dead and the victor is the monster
                    battleOver = true;
                    System.out.printf("%s wins!\n\n", monsterName);
                }
            } else {
                // Monster is dead and the victor is the player
                battleOver = true;
                System.out.printf("%s wins!\n\n", playerName);
            }
        }
    }
    
    /**
     * Player attacks monster and deals damage to
     * monster's health.
     */
    private void playerAttack() {
            monsterCurrHealth -= playerDamage;
            updateHealthStats();
            System.out.printf("%s attacks %s for %d damage.\n", playerName, monsterName, playerDamage);
    }

    /**
     * Monster attacks player and deals damage to 
     * player's health.
     */
    private void monsterAttack() {
        playerCurrHealth -= monsterDamage;
        updateHealthStats();
        System.out.printf("%s attacks %s for %d damage.\n", monsterName, playerName, monsterDamage);
    }

    /**
     * Prints the current stats of characters during the battle,
     * which includes their names, current/max health.
     */
    private void printStats() {
        System.out.printf("\n%s %d/%d | %s %d/%d\n", playerName, playerCurrHealth, playerMaxHealth, monsterName, monsterCurrHealth, monsterMaxHealth);
    }

    /**
     * Updates characters health after each attack
     */
    private void updateHealthStats() {
        player.setPlayerCurrHealth(playerCurrHealth);
        monster.setMonsterCurrHealth(monsterCurrHealth);
    }
}

