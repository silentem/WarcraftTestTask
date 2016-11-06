package wcclasses;

import java.util.ArrayList;
import java.util.Random;

public class Gang {

    /**
     * Contains all member of gang
     */
    private ArrayList<Character> allMembers;

    public Gang() {
        allMembers = new ArrayList<>();
    }

    /**
     * Refreshes all move variables to true
     */
    public void setAllMembersNonMoved(){
        for (Character character: allMembers) {
            character.setMoved(false);
        }
    }

    /**
     * Pull of curse from all members of gang
     */
    public void setAllMembersNonCursed(){
        for (Character character: allMembers) {
            character.setCursed(false);
        }
    }

    /**
     * Pull off all debuffs and return all debuffed characters their privilege
     */
    public void pullOffAllDebuffs(){
        for (Character character: allMembers) {
            if (character.isCursed()){
                character.setCursed(false);
                character.setPrivileged(true);

            }
        }
    }

    /**
     * Checks were all members of gang moved
     */
    public boolean isAllMoved(){
        for (Character character : allMembers){
            if (!character.isMoved()) return false;
        }
        return true;
    }

    /**
     * Returns all privileged == true members
     */
    public ArrayList<Character> getPrivilegedMembers() {

        ArrayList<Character> privilegedMembers = new ArrayList<>();
        for (Character character : allMembers)
            if (character.isPrivileged()) privilegedMembers.add(character);

        return privilegedMembers;
    }

    /**
     * Returns all privilaged == true moved == false members
     */
    public ArrayList<Character> getNonMovedPrivilageMembers(){
        ArrayList<Character> nonMovedPrivMembrs = new ArrayList<>();
        for (Character character : getPrivilegedMembers()) {
            if (!character.isMoved()) nonMovedPrivMembrs.add(character);
        }
        return nonMovedPrivMembrs;
    }

    /**
     * Returns all privileged == false members
     */
    public ArrayList<Character> getDefaultMembers() {
        ArrayList<Character> defaultMembers = new ArrayList<>();
        for (Character character : allMembers)
            if (!character.isPrivileged()) defaultMembers.add(character);

        return defaultMembers;
    }

    /**
     * Returns all privileged == false && moved == false members
     */
    public ArrayList<Character> getNonMovedDefaultMembers(){
        ArrayList<Character> nonMovedDefMembrs = new ArrayList<>();
        for (Character character : getDefaultMembers())
            if (!character.isMoved()) nonMovedDefMembrs.add(character);
        return nonMovedDefMembrs;
    }

    /**
     * Returns all members of gang
     */
    public ArrayList<Character> getAllMembers() {
        return allMembers;
    }

    /**
     * Adds character to gang
     */
    public void add(Character character){
        allMembers.add(character);
    }

    /**
     * Returns position of next party member who will be attacked
     *
     * Unfortunately future is already predicted =(
     */
    public int getTargetPosition(){
        Random random = new Random();
        return random.nextInt(allMembers.size());
    }
}
