public class Pyromancer implements Hero {
    private int life;
    private Heroes name;
    private int x, y;
    private int id;
    public Pyromancer(int life, Heroes name, int x, int y , int id){
        this.life = life;
        this.name = name;
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public Heroes getName(){
        return name;
    }
    int getLife(){
        return life;
    }
    void setLife(int life){
        this.life =life;
    }
    @Override
    public void Hero_Strategy(Hero hero) {
        if(hero.getName() == Heroes.P){
            if(this.getLife() < 1000){
                this.setLife(this.getLife()/2);
            }else{
                this.setLife((int) (0.75 * this.getLife()));
            }
        }else if(hero.getName() == Heroes.W){
            if(this.getLife() > 1000){
                this.setLife(this.getLife()/3);
            }else{
                this.setLife((int) (0.66 * this.getLife()));
            }
        }else if(hero.getName() == Heroes.R){
            if(this.getLife() > 1000){
                this.setLife(this.getLife()/5);
            }else{
                this.setLife((int) (0.5 * this.getLife()));
            }
        }
        System.out.println("Hero " + this.getName() + " " + this.id + " has " + this.getLife() + " points left");
    }
}
