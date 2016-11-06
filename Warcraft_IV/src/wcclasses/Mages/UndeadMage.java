package wcclasses.Mages;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class UndeadMage extends Character  implements Horde {
    public UndeadMage(boolean privileged) {
        super(privileged);
        setChClass("Некромант");
    }

    @Override
    public String move(Character character) {
        return (random.nextBoolean()) ? debuff(character) : attack(character);
    }


    /**
     * Skills below
     */
    public String debuff(Character enemy){
        enemy.setCursed(true);
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " проклинает " + enemy.getChClass() + "\r\n";
    }

    public String attack(Character enemy){
        enemy.setHp(enemy.getHp() - 5 * getMultiplier());
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует (нанесение урона " + 5 * getMultiplier() + " HP) " + enemy.getChClass() + "\r\n";
    }
}
