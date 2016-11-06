package wcclasses.Warriors;

import wcclasses.Character;
import wcclasses.Fractions.Alliance;

public class HumanWarrior extends Character  implements Alliance {
    public HumanWarrior(boolean privileged) {
        super(privileged);
        setChClass("Воин людей");
    }

    @Override
    public String move(Character character) {
        return attack(character);
    }

    /**
     * Skills below
     */
    public String attack(Character enemy){
        enemy.setHp(enemy.getHp() - 18 * getMultiplier());
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует мечом (нанесение урона " + 18 * getMultiplier() + " HP) " + enemy.getChClass() + "\r\n";
    }
}
