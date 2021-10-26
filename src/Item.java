public class Item {

  private String name;

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
