package pkgfinal.quest.battleTest;

/**
 *
 * @author satch
 */
public class Combatant extends Statable {
    
    public Combatant(String _name, int _hp, int _atk, int _def) {
        setHP(_hp);
        setAtk(_atk);
        setDef(_def);
        changeName(_name);
    }
    
}
