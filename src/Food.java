public class Food extends Item{
    private final int consumeHealth;

    Food(String name, int consumeHealth) {
        super(name);
        this.consumeHealth = consumeHealth;
    }

    public int getConsumeHealth() {
        return consumeHealth;
    }
}
