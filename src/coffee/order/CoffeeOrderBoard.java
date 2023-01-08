package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private int orderNumber = 0;
    private final List<Order> queue = new ArrayList<>();

    void add(Order order) {
        orderNumber += 1;
        order.setOrderNumber(orderNumber);
        queue.add(order);
    }

    Order deliver() {
        Order deliver = null;
        if (queue.size() != 0) {
            deliver = queue.get(0);
            queue.remove(0);
        } else System.out.println("Empty queue");
        return deliver;
    }

    Order deliver(int number) {
        Order deliver = null;
        if (queue.size() != 0) {
            for (Order order :
                    queue) {
                if (order.getOrderNumber() == number) {
                    deliver = queue.get(queue.indexOf(order));
                    queue.remove(order);
                }
            }
            if (deliver == null) {
                System.out.println("No order with this number");
            }
        } else {
            System.out.println("Empty queue");
        }
        return deliver;
    }

    void draw() {
        System.out.println("Num|Name");
        for (Order order :
                queue) {
            System.out.printf("%d|%s\n", order.getOrderNumber(), order.getName());
        }
    }
}