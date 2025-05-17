import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        Exception ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        List<Item> list1 = new ArrayList<>();
        list1.add(new Item(null, 1, 100, 0));
        Exception ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list1, "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());

        List<Item> list2 = new ArrayList<>();
        list2.add(new Item("", 1, 100, 0));
        Exception ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(list2, "1234567890123456"));
        assertEquals("Invalid item!", ex3.getMessage());

        List<Item> list3 = new ArrayList<>();
        list3.add(new Item("ItemA", 1, 400, 0));
        double sum3 = SILab2.checkCart(list3, "1234567890123456");
        assertEquals(-30 + 400 * 1, sum3, 0.001);

        List<Item> list4 = new ArrayList<>();
        list4.add(new Item("ItemB", 2, 100, 0.1));
        double sum4 = SILab2.checkCart(list4, "1234567890123456");
        assertEquals(2 * 100 * (1 - 0.1), sum4, 0.001);

        List<Item> list5 = new ArrayList<>();
        list5.add(new Item("ItemC", 11, 100, 0));
        double sum5 = SILab2.checkCart(list5, "1234567890123456");
        assertEquals(-30 + 100 * 11, sum5, 0.001);

        List<Item> list6 = new ArrayList<>();
        list6.add(new Item("ItemD", 2, 100, 0));
        double sum6 = SILab2.checkCart(list6, "1234567890123456");
        assertEquals(2 * 100, sum6, 0.001);

        List<Item> list7 = new ArrayList<>();
        list7.add(new Item("ItemE", 1, 100, 0));
        double sum7 = SILab2.checkCart(list7, "1234567890123456");
        assertEquals(100, sum7, 0.001);

        Exception ex4 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(list7, "1234"));
        assertEquals("Invalid card number!", ex4.getMessage());

        Exception ex5 = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(list7, "12345678901234AB"));
        assertEquals("Invalid character in card number!", ex5.getMessage());

    }
    @Test
    public void testMultipleConditionAllCases() {
        List<Item> items = List.of(new Item("Pen", 1, 100, 0));
        double expected = 100;
        assertEquals(expected, SILab2.checkCart(items, "1234567890123456"));


        List<Item> items1 = List.of(new Item("TV", 1, 400, 0));
        double expected1 = -30 + 400;
        assertEquals(expected1, SILab2.checkCart(items1, "1234567890123456"));


        List<Item> items2 = List.of(new Item("Shoes", 1, 100, 0.2));
        double expected2 = -30 + 100 * 0.8;
        assertEquals(expected2, SILab2.checkCart(items2, "1234567890123456"));


        List<Item> items3 = List.of(new Item("Paper", 11, 100, 0));
        double expected3 = -30 + 100 * 11;
        assertEquals(expected3, SILab2.checkCart(items3, "1234567890123456"));

        List<Item> items4 = List.of(new Item("Phone", 1, 400, 0.1));
        double expected4 = -30 + 400 * 0.9;
        assertEquals(expected4, SILab2.checkCart(items4, "1234567890123456"));


        List<Item> items5 = List.of(new Item("Fridge", 11, 400, 0));
        double expected5 = -30 + 400 * 11;
        assertEquals(expected5, SILab2.checkCart(items5, "1234567890123456"));


        List<Item> items6 = List.of(new Item("Table", 11, 100, 0.1));
        double expected6 = -30 + 100 * 0.9 * 11;
        assertEquals(expected6, SILab2.checkCart(items6, "1234567890123456"));


        List<Item> items7 = List.of(new Item("Gold", 11, 400, 0.2));
        double expected7 = -30 + 400 * 0.8 * 11;
        assertEquals(expected7, SILab2.checkCart(items7, "1234567890123456"));

    }
}


