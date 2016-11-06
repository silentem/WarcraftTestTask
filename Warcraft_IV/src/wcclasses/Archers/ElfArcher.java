package wcclasses.Archers;

import wcclasses.Character;
import wcclasses.Fractions.Alliance;

public class ElfArcher extends Character implements Alliance{

    public ElfArcher(boolean privileged) {
        super(privileged);
        setChClass("Лучник эльфов");
    }

    @Override
    public String move(Character character) {
        return (random.nextBoolean()) ? shot(character) : hit(character);
    }

    /**
     * Skills below
     */
    public String shot(Character enemy){
            enemy.setHp(enemy.getHp() - 7 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " стреляет из лука (нанесение урона " + 7 * getMultiplier() + " HP) в " + enemy.getChClass() + "\r\n";
    }
    public String hit(Character enemy){
            enemy.setHp(enemy.getHp() - 3 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " атакует (нанесение урона " + 3 * getMultiplier()+ " HP) " + enemy.getChClass() + "\r\n";
    }

}
