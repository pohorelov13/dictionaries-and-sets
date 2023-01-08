package coffee.order;

public class Order {

    private final String name;
    private int orderNumber;

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return  name +
                ", order number - " + orderNumber;
    }
}
