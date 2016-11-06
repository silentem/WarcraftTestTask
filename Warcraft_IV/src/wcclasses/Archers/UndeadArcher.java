package wcclasses.Archers;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class UndeadArcher extends Character  implements Horde {

    public UndeadArcher(boolean privileged) {
        super(privileged);
        setChClass("Охотник");
    }

    @Override
    public String move(Character character) {
        return (random.nextBoolean()) ? shot(character) : hit(character);
    }

    /**
     * Skills below
     */
    public String shot(Character enemy){
            enemy.setHp(enemy.getHp() - 4 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " стреляет из лука (нанесение урона " + 4 * getMultiplier() + " HP) в " + enemy.getChClass() + "\r\n";
    }
    public String hit(Character enemy){
            enemy.setHp(enemy.getHp() - 2 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует (нанесение урона " + 2 * getMultiplier()+ " HP) " + enemy.getChClass() + "\r\n";
    }
}
