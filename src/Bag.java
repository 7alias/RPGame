import java.util.Objects;

public abstract class Bag {
    private final String description;
    private int quantity;
    private final int increment;

    public Bag(String description, int increment) {
        this.description = description;
        this.quantity = 0;
        this.increment = increment;
    }


    abstract void use(Hero hero);

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIncrement() {
        return increment;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return description + "(" + quantity + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(description, bag.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(description);
    }

}
