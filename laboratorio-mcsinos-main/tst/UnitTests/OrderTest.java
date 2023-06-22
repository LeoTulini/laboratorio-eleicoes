package UnitTests;

import Entities.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void instantiateOrder_ValidArguments_NewOrder(){
        Item item = new Item(Type.BURGUER, 2, "Hamburgão");
        Item[] orderedItems = {item};
        Order order = new Order(orderedItems);
        Assert.assertNotNull(order);
        Assert.assertArrayEquals(orderedItems, order.getOrdered());
    }

    @Test
    public void instantiateOrder_NullArgument_NullPointerException(){
        try {
            Order order = new Order(null);
            Assert.fail();
        } catch (NullPointerException ex){
            Assert.assertEquals("Ordered items cannot be null.", ex.getMessage());
        }
    }
}
