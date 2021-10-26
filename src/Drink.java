public class Drink extends Item{
    private int consumeHealth;

    Drink(String name, int consumeHealth) {
        super(name);
        this.consumeHealth = consumeHealth;
    }

    public int getConsumeHealth() {
        return consumeHealth;
    }
}
