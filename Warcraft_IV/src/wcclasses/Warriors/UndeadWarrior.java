package wcclasses.Warriors;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class UndeadWarrior extends Character  implements Horde {
    public UndeadWarrior(boolean privileged) {
        super(privileged);
        setChClass("Зомби");
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
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " бьет копьем (нанесение урона " + 18 * getMultiplier() + " HP) " + enemy.getChClass() + "\r\n";
    }
}
