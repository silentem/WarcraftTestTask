package wcclasses.Mages;

import wcclasses.Character;
import wcclasses.Fractions.Horde;

public class OrcShaman extends Character  implements Horde, Shaman {
    public OrcShaman(boolean privileged) {
        super(privileged);
        setChClass("Шаман");
    }

    @Override
    public String move(Character character) {
        return (character instanceof Horde) ? buff(character) : debuff(character);
    }

    /**
     * Skills below
     */
    public String buff(Character ally){
        ally.setPrivileged(true);
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " наложение улучшение на " + ally.getChClass() + "\r\n";
    }

    public String debuff(Character enemy){
        enemy.setDebuffed(true);
        enemy.setPrivileged(false);
        return ((isPrivileged())? "Улучшеный " : "") + this.getChClass() + " наложение дебаффа на  " + enemy.getChClass() + "\r\n";
    }
}
