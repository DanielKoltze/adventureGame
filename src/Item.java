public class Item {

  private final String name;

  Item(String name) {
    this.name = name;
  }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

}
