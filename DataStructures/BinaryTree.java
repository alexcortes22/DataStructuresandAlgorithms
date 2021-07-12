public class BinaryTree <T extends Comparable <T>>{
    
    //tracks the  number of nodes in the Binary Search Tree
    private int nodeCount = 0;

    //This BST is a rooted tree, so we mantain a handle on the root node
    private Node root = null;

    private class Node{
        T data;
        Node left, right;
        public Node(Node left, Node right, T elem){
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    //method that determines if binary tree is empty
    public boolean isEmpty(){
        return size() == 0;
    }

    //return the size of the binary tree
    public int size(){
        return nodeCount;
    }

    public boolean addNode(T element){
        if(contains(element)){
            return false;
        }else{
            root = add(root, element);
            nodeCount++;
            return true;
        }
    }

    private Node add(Node node, T elem){
        //if we find a leaf node, create a new node with the element in it
        if(node == null){
            node = new Node (null, null, elem);

        //else go left or go right
        }else{
            if(elem.compareTo(node.data) < 0){
                node.left = add(node.left, elem);
            }else{
                node.right = add(node.right, elem);
            }
        }

        return node;
    }

    public boolean removeNode(T element){
        if(contains(element)){
            root = remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem){

        if (node == null) return null;
        int cmp = elem.compareTo(node.data);

        //dig into the left subtree
        if(cmp < 0){
            node.left = remove(node.left, elem);
        //dig into the right subtree
        }else if(cmp > 0){
            node.right = remove(node.right, elem);
        }else{
            //this is the case where there's a right subtree or no sub tree.
            //We swap the node we wish to remove with right child
            if(node.left == null){
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            //this is the case where there's a right subtree or no sub tree.
            //We swap the node we wish to remove with right child
            }else if(node.right == null){
                Node leftChild = node.left;
                node.data = null; 
                node = null;
                return leftChild;
            //when removing a node with two subtrees, the successor ofthe node being 
            //removed can either be largest value in left subtree or smallest value
            //in right subtree. This implementation uses smallest value in right 
            //subtree.
            }else{
                //find the leftmore node in right subtree
                Node tmp = digLeft(node.right);

                //Swap the data
                node.data = tmp.data;

                //Go into the right subtree and remove the leftmost node we found and 
                //swapped data with. This prevents us from having two nodes in our tree 
                //with the same value.
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    //helper method to get the leftmost node 
    private Node digLeft(Node node){
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    //returns true if the element exists in the tree
    public boolean contains(T elem){
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem){
        if(node == null) return false;

        int cmp = elem.compareTo(node.data);

        //check left subtree
        if(cmp < 0) return contains(node.left, elem);
        //check right subtree
        else if(cmp > 0) return contains(node.right, elem);
        else return true;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void traverse(TreeTraversalOrder order, Node root){
        switch(order){
            case PRE_ORDER:  preOrderTraversal(root);
            case IN_ORDER:  inOrderTraversal(root);
            case POST_ORDER:  postOrderTraversal(root);
            case LEVEL_ORDER:  levelOrderTraversal(root);
            default:  System.out.println("Please provide a valid order.");
        }
    }

    //traverse the tree in preorder
    private void preOrderTraversal(Node node){
        if (node == null) System.out.println("No node");
        System.out.println(node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.left);
    }

    //traverse the tree in inorder
    private void inOrderTraversal(Node node){
        if (node == null) System.out.println("No node");
        preOrderTraversal(node.left);
        System.out.println(node.data);
        preOrderTraversal(node.left);
    }

    //traverse the tree in postorder
    private void postOrderTraversal(Node node){
        if (node == null) System.out.println("No node");
        preOrderTraversal(node.left);
        preOrderTraversal(node.left);
        System.out.println(node.data);
    }

    //traverse the tree in level order
    private void levelOrderTraversal(Node node){
        if (node == null) System.out.println("No node");
    }
}
