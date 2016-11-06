package wcclasses.Archers;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class OrcArcher extends Character implements Horde{

    public OrcArcher(boolean privileged) {
        super(privileged);
        setChClass("Лучник орков");
    }

    @Override
    public String move(Character character) {
        return (random.nextBoolean()) ? shot(character) : hit(character);
    }

    /**
     * Skills below
     */
    public String shot(Character enemy){
            enemy.setHp(enemy.getHp() - 3 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " стреляет из лука (нанесение урона " + 3 * getMultiplier() + " HP) в " + enemy.getChClass() + "\r\n";
    }
    public String hit(Character enemy){
            enemy.setHp(enemy.getHp() - 2 * getMultiplier());
            return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " бьет клинком (нанесение урона " + 2 * getMultiplier()+ " HP) " + enemy.getChClass() + "\r\n";
    }
}
