//Strategy pattern every hero executes his strategy considering his opponent,
// in Hero_Strategy method implemented from Hero interface
public class Strategy {
    private Hero strategy;
    public Strategy(Hero strategy){
        this.strategy = strategy;
    }
    void execute_strategy(Hero adversary){
        strategy.Hero_Strategy(adversary);
    }
}
