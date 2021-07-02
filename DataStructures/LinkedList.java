public class LinkedList <T> implements Iterable<T>{
    int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private static class Node<T>{
        private T data;
        private Node<T> prev, next;
        
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            return data.toString();
        }

    }

    public void add(T elem){
        addLast(elem);
    }

    public void addLast(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    //add an element to the beginning of the linked list
    public void addFirst(T elem){
        if(isEmpty()){
            head = tail = new Node<T>(elem, null, null);
        }else{
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addAt(T data, int index) throws Exception{
        if(index < 0){
            throw new Exception("Illegal Index");
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size){
            addLast(data);
            return;
        }

        Node<T> temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        Node<T> newNode = new Node<T>(data, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = head.data;
        head = head.next;
        --size;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        T data = tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    private T remove(Node<T> node){
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        //make the pointers of the adjacent nodes skip over 'node'
        node.next.prev = node.prev;
        node.prev.next = node.next;

        //temporarily store the data we want to return
        T data = node.data;

        //memory clean
        node.data = null;
        node = node.prev = node.next = null;

        --size;

        return data;
    }

    public T removeAt(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }

        int i;
        Node<T> trav;

        //traversing to get to the node we want to remove
        //here we traverse from the front
        if(index < size / 2){
            for(i = 0, trav = head; i != index; i++){
                trav = trav.next;
            }
        //here we traverse from the back
        }else{
            for(i = size - 1, trav = tail; i != index; i--){
                trav = trav.prev;
            }
        }

        return remove(trav);
    }

    public boolean remove(Object obj){
        Node<T> trav = head;

        //if theres a node thats null, support removing it 
        if(obj == null){
            for(trav = head; trav != null; trav = trav.next){
                if(trav.data == null){
                    remove(trav);
                    return true;
                }
            }
        }else{
            for(trav = head; trav != null; trav = trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object obj){
        int index = 0;
        Node<T> trav = head;

        if(obj == null){
            for(; trav != null; trav = trav.next, index++){
                if(trav.data == null){
                    return index;
                }
            }
        }else{
                for(; trav != null; trav = trav.next, index++){
                    if(obj.equals(trav.data)){
                        return index;
                    }
            }
        }

        return -1;
    }

    // method that determines if a value exists in the linked list
    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            private Node<T> trav = head;

            @Override
            public boolean hasNext(){
                return trav != null;
            }

            @Override 
            public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override 
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while(trav != null){
            sb.append(trav.data);
            if(trav.next != null){
                sb. append(", ");
            }
            trav = trav.next;
        }

        sb.append(" ]");
        return sb.toString();
    }

    //This method clears all contents of linked list
    public void clear(){
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }

        head = tail = trav = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (getSize() == 0);
    }
    private int getSize(){
        return size;
    }
}


