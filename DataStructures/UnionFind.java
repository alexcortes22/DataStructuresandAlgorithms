public class UnionFind {
    
    //keep track of the elements in the union find
    private int size;

    //used to track the sizes of each of the components
    private int[] componentSizes;

    //tracks the parent node id 
    private int[] id;

    //tracks the number of components in the union find
    private int numOfComponents;

    /*
        Constructor Method
        @param: int, the size of the UnionFind
    */

    public UnionFind(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Size <= 0 is not allowed");
        }

        //set the size of the union find to the parameter and set the components(groups) to that same num
        this.size = numOfComponents = size;
        componentSizes = new int[size];
        id = new int[size];

        for(int i = 0; i < size; i++){
            id[i] = i; //the parent node of each node is itself
            componentSizes[i] = 1; //every component is size of 1 
        }
    }

    /*
        Find: This method finds the root node of a given node. After it finds the root node, it 
               will compress the path it takes from the given node to the parent node to provide 
               amortized constant time complexity.

        @param: int, the node you want to find the parent of 
        @return: int, the root node
    */
    public int find(int node){
        int root = node;

        //this self loops helps us find the parent node of the given node
        while(root != id[root]){
            root = id[root];
        }

        //Path Compression: Provides amortized constant time complexity
        while(node != root){
            int next = id[node];
            id[node] = root;
            //this moves the pointer to the next node so that it will change the pointer to parent
            node = next;
        }

        return root;
    }

    /*
        connected: This method will determine if two nodes are in the same component. It does this
                   by comparing the root node of each node. If they are the same, they are connected

        @param: int, node A
                int, node B
        @return: Boolean, True if connected. False if not
    */
    public boolean connected(int nodeA, int nodeB){
        return find(nodeA) == find(nodeB);
    }

    /*
        componentSize: A method to find the size of a component that the target node is in. It does
                       this by finding the parent node of the target node and getting the size in 
                       the corresponding index of the componentSizes array.

        @param: int, the node thats in the component that size is being looked for
        @return: int, the size of the component
    */
    public int componentSize(int node){
        return componentSizes[find(node)];
    }

    public int size(){
        return size;
    }

    public int components(){
        return numOfComponents;
    }

    /*
        Unify: This method merges two components together. It gets tha parent nodes of each given node.
               If the parents nodes are equal, they are already in the same component. We find which 
               component is larger and then merge the smaller component into the larger one and change
               the parent node for the smaller component and update the component sizes array.

        @param: int, nodeA
                int, nodeB
        
        @return: void. Nothing is returned.
    */
    public void unify(int nodeA, int nodeB){
        int root1 = find(nodeA);
        int root2 = find(nodeB);

        if(root1 == root2){
            return;
        }

        if(componentSizes[root1] < componentSizes[root2]){
            //add the sizes of the components
            componentSizes[root2] += componentSizes[root1];
            id[root1] = root2;
        }else{
            componentSizes[root1] += componentSizes[root2];
            id[root2] = root1;
        }

        numOfComponents--;
    }
    public static void main(String args[]){
        
    }
}
