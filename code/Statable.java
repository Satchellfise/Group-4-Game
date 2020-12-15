package pkgfinal.quest.battleTest;

/**
 *
 * @author satch
 */
public class Statable{
    private int base_hp;
    private int base_atk;
    private int base_def;
    private int hp;
    private int atk;
    private int def;
    private String name;
    
    public void setHP(int _hp){
        base_hp=_hp;
        hp=base_hp;
    }
    
    public void setAtk(int _atk){
        base_atk=_atk;
        atk=_atk;
    }
    
    public void setDef(int _def){
        base_def=_def;
        def=_def;
    }
    
    public void changeHP(int diff) {
        hp = hp + diff;
        if(hp>base_hp){
            hp=base_hp;
        }
    }
    
    public void changeAtk(int diff) {
        atk = atk + diff;
    }
    
    public void changeDef(int diff) {
        def = def + diff;
    }
    
    public void changeName(String _name) {
        name = _name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHP() {
        return hp;
    }
    
    public int getBaseHP(){
        return base_hp;
    }
    
    public int getAtk() {
        return atk;
    }
    
    public int getBaseAtk(){
        return base_atk;
    }
    
    public int getDef() {
        return def;
    }
    
    public int getBaseDef(){
        return base_def;
    }
}