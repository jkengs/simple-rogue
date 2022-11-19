/**
 * A class that represents the Monster and its attributes such
 * as name, health and damage.
 */

public class Monster {

    private String monsterName;
    private int monsterCurrHealth;
    private int monsterMaxHealth;
    private int monsterDamage;

    /**
     * Monster default constructor
     */
    public Monster(){
        this.monsterName = null;
        this.monsterMaxHealth = 0;
        this.monsterCurrHealth = 0;
        this.monsterDamage = 0;
    }

    /**
     * Monster constructor
     * @param monsterName string name of monster
     * @param maxMonsterHealth int maximum health of monster
     * @param monsterDamage int damage of monster
     */
    public Monster(String monsterName, int maxMonsterHealth, int monsterDamage){
        this.monsterName = monsterName;
        this.monsterMaxHealth = maxMonsterHealth;
        this.monsterCurrHealth = maxMonsterHealth;
        this.monsterDamage = monsterDamage;
    }

    /**
     * Restores monster health to full
     */
    public void restoreToFullHP() {
        this.monsterCurrHealth = this.monsterMaxHealth;
    }

    // Accessor Methods for monster
    public String getMonsterName() {
        return this.monsterName;
    }
    public int getMonsterCurrHealth() {
        return this.monsterCurrHealth;
    }
    public int getMonsterMaxHealth() {
        return this.monsterMaxHealth;
    }
    public int getMonsterDamage() {
        return this.monsterDamage;
    }

    // Mutator Methods for monster
    public void setMonsterCurrHealth(int monsterHealth) {
        this.monsterCurrHealth = monsterHealth;
    }
    public void setMonsterMaxHealth(int monsterHealth) {
        this.monsterMaxHealth = monsterHealth;
    }
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

}

