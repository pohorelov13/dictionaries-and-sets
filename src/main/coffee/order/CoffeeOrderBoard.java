package main.coffee.order;

import main.exceptions.EmptyQueueException;
import main.exceptions.NoSuchOrderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeOrderBoard {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private int orderNumber = 0;
    private final List<Order> queue = new ArrayList<>();

    void add(Order order) {
        LOGGER.info("CALLED METHOD ADD WITH {}", order.getName());
        orderNumber += 1;
        order.setOrderNumber(orderNumber);
        queue.add(order);
        LOGGER.info("ADDING IS SUCCESS");
    }

    Order deliver() {
        Order deliver = null;
        try {
            LOGGER.info("CALLED METHOD DELIVER WITHOUT PARAM");
            if (queue.size() != 0) {
                deliver = queue.get(0);
                queue.remove(0);
                LOGGER.info("DELIVER IS SUCCESS");
            } else {
                LOGGER.error("EMPTY QUEUE IN METHOD DELIVER WITHOUT PARAM");
                throw new EmptyQueueException();
            }
        } catch (EmptyQueueException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }
        return deliver;
    }

    Order deliver(int number) {
        Order deliver = null;
        try {
            LOGGER.info("CALLED METHOD DELIVER WITH PARAM {}", number);
            if (queue.size() != 0) {
                for (Order order :
                        queue) {
                    if (order.getOrderNumber() == number) {
                        deliver = queue.get(queue.indexOf(order));
                        queue.remove(order);
                    }
                }
                if (deliver == null) {
                    LOGGER.error("TRYING CALLED METHOD DELIVER WITH WRONG PARAM {}", number);
                    throw new NoSuchOrderException();
                }
                LOGGER.info("DELIVER IS SUCCESS");
            } else {
                LOGGER.error("EMPTY QUEUE IN METHOD DELIVER WITH PARAM {}", number);
                throw new EmptyQueueException("QUEUE IS EMPTY");
            }
        } catch (EmptyQueueException | NoSuchOrderException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }
        return deliver;
    }

    void draw() {
        LOGGER.info("CALLED METHOD DRAW");
        System.out.println("Num|Name");
        for (Order order :
                queue) {
            System.out.printf("%d|%s\n", order.getOrderNumber(), order.getName());
        }
        LOGGER.info("METHOD DRAW SUCCESS");
    }
}