/**
 * MaxPQ (maximum priority queue) implemented from Algorithms (Sedgewick, Wayne)
 * pg. 318
 */
public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq;   // heap-ordered complete binary tree
    private int n = 0;  // pq[0] is unused, heap uses pq[1..n]
    // testing a change

    /**
     * Create new empty max priority queue.
     * Useful if inserting one by one, where each element
     * is inserting at the end and "swims" up into place.
     *
     * @param max maximum size of queue
     */
    public MaxPQ(int max)
    {
        pq = (Key[]) new Comparable[max + 1];
    }

    /**
     * Creates new max priority queue from existing array.
     * Takes an existing array and "sinks" each parent into
     * place decrementing from the last parent.
     *
     * @param a array to create maxpq from
     */
    public MaxPQ(Key[] a)
    {
        n = a.length;
        pq = (Key[]) new Comparable[n * 2];
        for (int i = 1; i <= n; i++)
        {
            pq[i] = a[i - 1];
        }
        heapify(pq);
    }

    /**
     * Inserts a new item into the maxpq.
     * First adds the item to the end of the queue
     * then swims the item up into position.
     *
     * @param v item to insert
     */
    public void insert(Key v)
    {
        pq[++n] = v;
        swim(n);
    }

    /**
     * Deletes the root of the maxpq.
     * First swaps last item with root
     * then sinks the item down into position.
     *
     * @return item at root
     */
    public Key delMax()
    {
        Key max = pq[1];
        exchange(1, n--);
        pq[n + 1] = null;
        sink(1);
        return max;
    }

    /**
     * Swims item up into position.
     *
     * @param k index to swim up
     */
    private void swim(int k)
    {
        while (k > 1 && less(k / 2, k))
        {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * Sinks item down into position.
     *
     * @param k index of item to sink down
     */
    private void sink(int k)
    {
        while (2 * k <= n)
        {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    /**
     * Sinks parents in a decrementing order.
     * Orders an array into a max heap.
     *
     * @param a array to heapify
     */
    private void heapify(Key[] a)
    {
        for (int i = n / 2; i > 0; i--)
        {
            sink(i);
        }
    }

    /**
     * Checks to see if the maxpq is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty()
    {
        return n == 0;
    }

    /**
     * Returns size of maxpq.
     *
     * @return size as int
     */
    public int size()
    {
        return n;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public String toString()
    {
        String ret = "";
        for (int i = 1; i <= n; i++)
        {
            ret += pq[i] + " ";
        }
        return ret;
    }

    public static void main(String[] args)
    {
        Comparable[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPQ<String> test = new MaxPQ(a); // this constructor heapifies
        System.out.println(test);
        System.out.println("Size: " + test.size());
        System.out.println("Inserting W");
        test.insert("W");
        System.out.println(test);
        System.out.println("Inserting J");
        test.insert("J");
        System.out.println(test);
        System.out.println("Deleting: " + test.delMax());
        System.out.println(test);
        System.out.println("Deleting: " + test.delMax());
        System.out.println(test);
        System.out.println("Inserting S");
        test.insert("S");
        System.out.println(test);
    }
}
