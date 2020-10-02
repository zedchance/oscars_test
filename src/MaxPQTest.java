import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MaxPQTest
{
    @Test
    void insert()
    {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPQ<String> test = new MaxPQ(a);
        assertEquals(test.toString(), "X T S P L R A M O E E ");
        test.insert("W");
        assertEquals(test.toString(), "X T W P L S A M O E E R ");
    }

    @Test
    void insert2()
    {
        MaxPQ<Integer> test = new MaxPQ(5);
        test.insert(1);
        assertEquals(test.toString(), "1 ");
        test.insert(2);
        assertEquals(test.toString(), "2 1 ");
        test.insert(3);
        assertEquals(test.toString(), "3 1 2 ");
        assertEquals(test.delMax(), 3);
    }

    @Test
    void delMax()
    {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPQ<String> test = new MaxPQ(a);
        assertEquals(test.delMax(), "X");
    }

    @Test
    void delMax2()
    {
        MaxPQ<Integer> test = new MaxPQ(5);
        test.insert(1);
        test.insert(2);
        test.insert(3);
        assertEquals(test.delMax(), 3);
    }

    @Test
    void isEmpty()
    {
        MaxPQ<Integer> test = new MaxPQ<>(5);
        assertEquals(test.isEmpty(), true);
        test.insert(1);
        assertEquals(test.isEmpty(), false);
    }

    @Test
    void size()
    {
        MaxPQ<Integer> test = new MaxPQ<>(5);
        assertEquals(test.size(), 0);
        test.insert(1);
        assertEquals(test.size(), 1);
        test.insert(1);
        assertEquals(test.size(), 2);
    }

    @Test
    void size2()
    {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPQ<String> test = new MaxPQ(a);
        assertEquals(test.size(), 11);
    }

    @Test
    void testHeapify()
    {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPQ<String> test = new MaxPQ(a);
        assertEquals(test.toString(), "X T S P L R A M O E E ");
    }
}
