public class fenwickTree {
    //This array contains the Fenwick tree ranges
    private long[] tree;

    public fenwickTree(int sz){
        tree = new long[sz + 1];
    }

    public fenwickTree(long[] values){
        if(values == null) 
            throw new IllegalArgumentException("Values array can not be null!");

        //Make a clone of the values array since we manipulate the array in place
        this.tree = values.clone();

        for(int i = 1; i < tree.length; i++){
            int j = i + lsb(i);
            if(j < tree.length) tree[j] += tree[i];
        }
    }

    /*
        Returns the value of the least significant bit
        lsb(108) = lsb(0b1101100) = 0b100 = 4
    */
    private int lsb(int i){
        return i & -i; //faster
    }

    //Computes the prefix sum from [1, i] one based
    public long prefixSum(int i){
        long sum = 0L;
        while(i != 0){
            sum += tree[i];
            i &= ~lsb(i); //Equivalent to i-= lsb(i)
        }
        return sum;
    }

    public long sum(int i, int j){
        if(j < i) throw new IllegalArgumentException("Make sure j >= i");
        return prefixSum(j) - prefixSum(i - 1);
    }

    //Add 'k' to index 'i', one based
    public void add (int i, long k){
        while(i < tree.length){
            tree[i] += k;
            i += lsb(i);
        }
    }

    //set index i to be equal to k, one based
    public void set(int i, long k){
        long value = sum(i,i);
        add(i, k - value);
    }

    @Override public String toString(){
        return java.util.Arrays.toString(tree);
    }

}
