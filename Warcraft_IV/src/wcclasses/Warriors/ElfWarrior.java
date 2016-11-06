package wcclasses.Warriors;

import wcclasses.Character;
import wcclasses.Fractions.Alliance;

public class ElfWarrior extends Character  implements Alliance {
    public ElfWarrior(boolean privileged) {
        super(privileged);
        setChClass("Воин эльфов");
    }

    @Override
    public String move(Character character) {
        return attack(character);
    }

    /**
     * Skills below
     */
    public String attack(Character enemy){
        enemy.setHp(enemy.getHp() - 15 * getMultiplier());
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует мечом (нанесение урона " + 15 * getMultiplier() + " HP) " + enemy.getChClass() + "\r\n";
    }

}
