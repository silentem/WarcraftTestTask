package wcclasses.Archers;

import wcclasses.Character;
import wcclasses.Fractions.Alliance;

public class HumanArcher extends Character  implements Alliance {

    public HumanArcher(boolean privileged) {

        super(privileged);
        setChClass("Арбалетчик людей");
    }

    @Override
    public String move(Character character) {
        return (random.nextBoolean())? shot(character) : hit(character);
    }

    /**
     * Skills below
     */
    public String shot(Character enemy){
            enemy.setHp(enemy.getHp() - 5 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " стреляет из арбалета (нанесение урона " + 5 * getMultiplier() + " HP) в " + enemy.getChClass() + "\r\n";
    }
    public String hit(Character enemy){
            enemy.setHp(enemy.getHp() - 3 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует (нанесение урона " + 3 * getMultiplier()+ " HP) " + enemy.getChClass() + "\r\n";
    }

}
