//Factory pattern for production of the heroes
public class Hero_Factory {
    public Hero getHero(int life, Heroes name, int x, int y, int id){
        if(name == Heroes.P){
            return new Pyromancer(life, name, x, y, id);
        }else if(name == Heroes.W){
            return new Wizard(life, Heroes.W, x, y, id);
        }else if(name == Heroes.R){
            return new Rogue(life, name, x, y, id);
        }else{
            return null;
        }
    }
}
