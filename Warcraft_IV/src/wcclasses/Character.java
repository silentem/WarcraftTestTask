package wcclasses;

import java.util.Random;

public abstract class Character {
    private double hp = 100;

    protected Random random;

    private boolean privileged ;

    private boolean cursed;

    private boolean debuffed;
    /**
     * Class of character
     */
    private  String chClass;

    private boolean moved;

    public Character(boolean privileged){
        random = new Random();
        this.privileged = privileged;
    }

    /**
     * Checks is dead character or not
     */
    public boolean isDead(){
        if (hp <= 0) return true;
        return false;
    }

    /**
     * Returns current hp
     */
    public double getHp() {
        return hp;
    }

    /**
     * Check is privileged character or not
     */
    public boolean isPrivileged() {
        return privileged;
    }

    public abstract String move(Character character);

    /**
     * Checks was character moved or not
     */
    public boolean isMoved() {
        return moved;
    }

    /**
     * Mostly points that character was moved
     */
    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void setDebuffed(boolean debuffed) {
        this.debuffed = debuffed;
    }

    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    /**
     * Returns multiplier according to is privileged character of not
     * Protected because it wont be used outside hierarchy
     */
    protected double getMultiplier(){
        return (this.isPrivileged() ? 1.5 : 1) * (isCursed() ? 0.5 : 1);
    }

    /**
     * Returns character class
     */
    public String getChClass() {
        return chClass;
    }

    /**
     * Mostly decreases hp by taking damage
     */
    public void setHp(double hp) {
        this.hp = hp;
    }

    /**
     * Set privilege
     */
    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    /**
     * Sets character class
     */
    protected void setChClass(String chClass){
        this.chClass = chClass;
    }
}
