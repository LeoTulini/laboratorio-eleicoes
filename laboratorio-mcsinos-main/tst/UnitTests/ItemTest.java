package UnitTests;

import Entities.Item;
import Entities.Type;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
    @Test
    public void intantiateItem_ValidArguments_NewItem(){
        // when given then
        Item item = new Item(Type.BURGUER, 2, "Hamburgão");

        Assert.assertNotNull(item);
    }

    @Test
    public void intantiateItem_InvalidArguments_NewItem(){
        // when given then
        try {
            Item item = new Item(Type.BURGUER, -1, "Hamburgão");
            Assert.fail();
        } catch (IllegalArgumentException ex){
            Assert.assertEquals("A quantidade de itens não pode ser negativa.", ex.getMessage());
        }
    }
}
