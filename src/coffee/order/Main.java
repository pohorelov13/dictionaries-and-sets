package coffee.order;

public class Main {


    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add(new Order("Walter White"));
        coffeeOrderBoard.add(new Order("Saul Goodman"));
        coffeeOrderBoard.add(new Order("Heisenberg"));
        coffeeOrderBoard.add(new Order("Jon Snow"));
        coffeeOrderBoard.add(new Order("Daenerys Targaryen"));
        coffeeOrderBoard.add(new Order("Harry Potter"));
        coffeeOrderBoard.add(new Order("Ron Weasley"));
        coffeeOrderBoard.add(new Order("Lord Voldemort"));

        coffeeOrderBoard.draw();
        System.out.println(coffeeOrderBoard.deliver());
        System.out.println(coffeeOrderBoard.deliver(7));
        coffeeOrderBoard.draw();

        coffeeOrderBoard.add(new Order("Joey"));

        coffeeOrderBoard.draw();
    }
}
