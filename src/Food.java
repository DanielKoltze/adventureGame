public class Food extends Item{
    private int consumeHealth;

    Food(String name, int consumeHealth) {
        super(name);
        this.consumeHealth = consumeHealth;
    }

    public int getConsumeHealth() {
        return consumeHealth;
    }
}
