import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Item> items;
    private ArrayList<Order> orders;

    public void addItem(String itemName, double itemPrice, int itemQuantity)
    {
        Item item = new Item(items.size() + 1, itemName, itemPrice, itemQuantity);
        items.add(item);
    }

    public void createOrder(Item item)
    {
        Order order = new Order(item);
        order.setOrderID(orders.size() + 1);
        orders.add(order);
    }
}
