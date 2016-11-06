package wcclasses.Logic;

import wcclasses.Character;
import wcclasses.Mages.Shaman;
import wcclasses.Archers.ElfArcher;
import wcclasses.Mages.ElfMage;
import wcclasses.Warriors.ElfWarrior;
import wcclasses.Gang;
import wcclasses.Archers.HumanArcher;
import wcclasses.Mages.HumanMage;
import wcclasses.Warriors.HumanWarrior;
import wcclasses.Mages.Mage;
import wcclasses.Archers.OrcArcher;
import wcclasses.Mages.OrcShaman;
import wcclasses.Warriors.OrcWarrior;
import wcclasses.Archers.UndeadArcher;
import wcclasses.Mages.UndeadMage;
import wcclasses.Warriors.UndeadWarrior;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class GameController {
    /**
     * String contains all logs of fight
     */
    private String logStr = "";

    /**
     * Contains Alliance gang
     */
    private Gang allianceGang;
    /**
     * Contains Horde gang
     * Lok'Tar Ogar
     */
    private Gang hordeGang;

    /**
     * Randimizer
     */
    private Random random;

    /**
     * Method starts fight
     */
    public void start(){

        random = new Random();

        logStr += "\r\nИгра началась!\r\n";

        /**
         * Initializing gangs
         */
        hordeGang = new Gang();

        allianceGang = new Gang();

        /**
         * Randomly filling gangs with races
         */
        /**
         * Horde : Undead / Orcs
         */
        if (random.nextBoolean()){
            hordeGang.add(new UndeadMage(random.nextBoolean()));
            hordeGang.add(new UndeadArcher(random.nextBoolean()));
            hordeGang.add(new UndeadArcher(random.nextBoolean()));
            hordeGang.add(new UndeadArcher(random.nextBoolean()));
            hordeGang.add(new UndeadWarrior(random.nextBoolean()));
            hordeGang.add(new UndeadWarrior(random.nextBoolean()));
            hordeGang.add(new UndeadWarrior(random.nextBoolean()));
            hordeGang.add(new UndeadWarrior(random.nextBoolean()));
            logStr += "\r\nСилы Орды - нежить!\r\n";
        }
        else {
            hordeGang.add(new OrcShaman(random.nextBoolean()));
            hordeGang.add(new OrcArcher(random.nextBoolean()));
            hordeGang.add(new OrcArcher(random.nextBoolean()));
            hordeGang.add(new OrcArcher(random.nextBoolean()));
            hordeGang.add(new OrcWarrior(random.nextBoolean()));
            hordeGang.add(new OrcWarrior(random.nextBoolean()));
            hordeGang.add(new OrcWarrior(random.nextBoolean()));
            hordeGang.add(new OrcWarrior(random.nextBoolean()));
            logStr += "\r\nСилы Орды - орки!\r\n";
        }

        /**
         * Alliance : Elfs / Humans
         */
        if (random.nextBoolean()){
            allianceGang.add(new ElfMage(random.nextBoolean()));
            allianceGang.add(new ElfArcher(random.nextBoolean()));
            allianceGang.add(new ElfArcher(random.nextBoolean()));
            allianceGang.add(new ElfArcher(random.nextBoolean()));
            allianceGang.add(new ElfWarrior(random.nextBoolean()));
            allianceGang.add(new ElfWarrior(random.nextBoolean()));
            allianceGang.add(new ElfWarrior(random.nextBoolean()));
            allianceGang.add(new ElfWarrior(random.nextBoolean()));
            logStr += "\r\nСилы Альянса - эльфы!\r\n";
        }
        else {
            allianceGang.add(new HumanMage(random.nextBoolean()));
            allianceGang.add(new HumanArcher(random.nextBoolean()));
            allianceGang.add(new HumanArcher(random.nextBoolean()));
            allianceGang.add(new HumanArcher(random.nextBoolean()));
            allianceGang.add(new HumanWarrior(random.nextBoolean()));
            allianceGang.add(new HumanWarrior(random.nextBoolean()));
            allianceGang.add(new HumanWarrior(random.nextBoolean()));
            allianceGang.add(new HumanWarrior(random.nextBoolean()));
            logStr += "\r\nСилы Альянса - люди!\r\n";
        }

        logStr += "\r\nДа начнеться сражение!\r\n";

        /**
         * Cycle ends while one of gangs will have zero members
         */
        for (int i = 1; ; i++){
            String log = "";
            if (allianceGang.getAllMembers().size() == 0){
                log += "\r\nПОБЕДА ОРДЫ!\r\n";
                System.out.print(log);
                logStr += log;
                break;
            }
            if (hordeGang.getAllMembers().size() == 0){
                log += "\r\nПОБЕДА АЛЬЯНСА\r\n";
                System.out.print(log);
                logStr += log;
                break;
            }

            if (random.nextBoolean()) {
                log += "\r\n(Ход " + i + ") " + "АЛЬЯНС НАЧАЛ ХОД!\r\n";
                log += nextTurn(allianceGang, hordeGang);
                log += "АЛЬЯНС ЗАКОНЧИЛ ХОД!\r\n";
            }
            else {
                log += "\r\n(Ход " + i + ") " + "ОРДА НАЧАЛА ХОД!\r\n";
                log += nextTurn(hordeGang, allianceGang);
                log += "ОРДА ЗАКОНЧИЛА ХОД!\r\n";
            }
            System.out.print(log);
            logStr += log;
        }

        try(FileWriter writer = new FileWriter("log.txt", false)){
            writer.write(logStr);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Character getNextMember(Gang gang){
        Character character = null;
        int characterPos;
        if (gang.getNonMovedPrivilageMembers().size() != 0){
            characterPos = random.nextInt(gang.getNonMovedPrivilageMembers().size());
            character = gang.getNonMovedPrivilageMembers().get(characterPos);
        }
        else if (gang.getNonMovedDefaultMembers().size() != 0){
            characterPos = random.nextInt(gang.getNonMovedDefaultMembers().size());
            character = gang.getNonMovedDefaultMembers().get(characterPos);
        }
        return character;
    }

    /**
     * Logic for gang turn
     * Returns string with log of turn
     */
    public String nextTurn(Gang allyGang, Gang enemyGang){
        Character character;
        Character enemy;
        Character ally;
        String turnLog = "";
        while (!allyGang.isAllMoved()) {
            if (enemyGang.getAllMembers().size() == 0) return turnLog;

            character = getNextMember(allyGang);

            int enemyPos = enemyGang.getTargetPosition();
            enemy = enemyGang.getAllMembers().get(enemyPos);

            int allyPos = allyGang.getTargetPosition();
            ally = allyGang.getAllMembers().get(allyPos);

            if (character instanceof Mage)
                turnLog += (random.nextBoolean()) ? character.move(enemy) : character.move(ally);
            else if (character instanceof Shaman){
                if (enemyGang.getPrivilegedMembers().size() != 0 && random.nextBoolean()){
                    int privilegedEnemyPos = random.nextInt(enemyGang.getPrivilegedMembers().size());
                    enemy = enemyGang.getPrivilegedMembers().get(privilegedEnemyPos);
                    turnLog += character.move(enemy);
                }
                else
                    turnLog += character.move(ally);
            }
            else turnLog += character.move(enemy);

            character.setMoved(true);
            character.setPrivileged(false);

            if (enemy.isDead()) {
                turnLog += enemy.getChClass() + " БЫЛ УБИТ!\r\n";
                enemyGang.getAllMembers().remove(enemyPos);
            }
        }
        allyGang.pullOffAllDebuffs();
        allyGang.setAllMembersNonCursed();
        allyGang.setAllMembersNonMoved();

        return turnLog;
    }

}
