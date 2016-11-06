package wcclasses.Warriors;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class OrcWarrior extends Character  implements Horde {
    public OrcWarrior(boolean privileged) {
        super(privileged);
        setChClass("Гоблин");
    }

    @Override
    public String move(Character character) {
        return attack(character);
    }

    /**
     * Skills below
     */
    public String attack(Character enemy){
        enemy.setHp(enemy.getHp() - 20 * getMultiplier());
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует дубиной (нанесение урона " + 20 * getMultiplier() + " HP) " + enemy.getChClass() + "\r\n";
    }
}
