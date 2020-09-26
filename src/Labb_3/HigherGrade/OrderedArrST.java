package Labb_3.HigherGrade;

public class OrderedArrST
{
    private int[] keys;
    private LinkedList[] values;
    private int n = 0;
    private static final int init_size = 5000;

    public OrderedArrST()
    {
        keys = new int[init_size];
        values = new LinkedList[init_size];
        for(int i = 0; i < values.length; i++)
        {
            values[i] = new LinkedList();
        }
    }

    private void resize(int capacity)
    {
        int[] tempk = new int[capacity];
        LinkedList[] tempv = new LinkedList[capacity];
        for (int i = 0; i < n; i++)
        {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public int rank(int key)
    {
        int lo = 0, hi = n-1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            int cmp = key - keys[mid];
            if(cmp < 0)
                hi = mid - 1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public String[] get(int key)
    {
        int i = rank(key);
        if(i < n && keys[i] == key)
            return values[i].getAll();

        return null;
    }

    public int getFrequency(int k)
    {
        if(k >= n)
            k = n;
        return keys[n-k];
    }
    public String[] findKthMost(int k)
    {
        if(k >= n)
            k = n;
        return values[n-k].getAll();
    }

    public String[] max()
    {
        return values[n-1].getAll();
    }

    public String[] min()
    {
        return values[0].getAll();
    }



    public void put(int key, String value)
    {
        int i = rank(key);

        // key is already in table
        if (i < n && keys[i] == key)
        {
            values[i].add(value);
            return;
        }

        // insert new key-value pair
        if (n == keys.length)
            resize(2*keys.length);

        for (int j = n; j > i; j--)
        {
            keys[j] = keys[j-1];
            values[j].clear();
            values[j].addAll(values[j-1].getAll());
            values[j-1].clear();
        }
        keys[i] = key;
        values[i].add(value);
        n++;
    }

}
