package wcclasses.Mages;

import wcclasses.Character;
import wcclasses.Fractions.Alliance;

public class HumanMage extends Character  implements Alliance, Mage {
    public HumanMage(boolean privileged) {
        super(privileged);
        setChClass("Маг людей");
    }

    @Override
    public String move(Character character) {
        return (character instanceof Alliance) ? buff(character) : attack(character);
    }

    /**
     * Skills below
     */
    public String buff(Character ally){
        ally.setPrivileged(true);
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " наложение улучшение на " + ally.getChClass() + "\r\n";
    }

    public String attack(Character enemy){
        enemy.setHp(enemy.getHp() - 4 * getMultiplier());
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует магией (нанесение урона " + 4 * getMultiplier() + "  HP) " + enemy.getChClass() + "\r\n";
    }
}
