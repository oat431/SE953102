public class LinkedList {
    private Node head;
    private int size;
    private Node last;

    // LinkedList standard constructor
    public LinkedList(){
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    // LinkedList define value of head node constructor
    public LinkedList(int data){
        this.head = new Node(data);
        this.last = head;
        this.size = 1;
    }

    // add element to the last 
    public void add(int data){
        if(head == null){
            head = new Node(data);
            this.size = 1;
            return ;
        } 

        Node cur = head;

        while(cur.next != null){
            cur = cur.next;
        }

        cur.next = new Node(data);
        this.last = cur.next;
        this.size++;
    }

    // check whether there is a Element in LinkedList or node
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    public Node getHead() {
        return head;
    }

    public Node getLast() {
        return last;
    }

    // add the element at specific index
    public void insertAt(int index,int data){
        if(isEmpty()){
            System.out.println("Don't have any element yet"); 
            return ;
        } 
        if(size < index){
            System.out.println("Don't have that much array"); 
            return ;
        }

        Node cur = head;
        Node cur2 = cur.next;

        while(--index > 0){
            cur = cur.next;
            cur2 = cur2.next;
        }

        Node newNode = new Node(data);
        cur.next = newNode;
        newNode.next = cur2;
        
        this.size++;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteAll(){
        head = null; 
        this.size = 0;
    }

    public void deleteFirst(){
        head = head.next;
    }

    public void deleteAt(int index){
        if(isEmpty()){
            System.out.println("Don't have any element yet"); 
            return ;
        } 
        if(size < index){
            System.out.println("Don't have that much array"); 
            return ;
        }

        Node cur = head;
        Node cur2 = cur.next;

        while(--index > 0){
            cur = cur.next;
            cur2 = cur2.next;
        }

        cur.next = cur2.next;
        this.size--;
    }

    public void deleteLast(){
        this.last = null;
    }

    // travel though the LinkedList from the head node to last node
    public void travel(){
        Node cur = head;
        int index = 0;
        while(cur != null){
            System.out.println(index++ + " " + cur.data);
            cur = cur.next;
        }
    }

}

class Main {
    public static void main(String[] args) {
        LinkedList link = new LinkedList(12);
        link.add(13);
        link.add(14); 
        link.add(15); 
        link.add(16); 
        link.add(17); 
        link.travel();
       
        System.out.println();
        link.insertAt(4, 11);
        link.travel();

        System.out.println();
        link.deleteAt(3);
        link.travel();

        System.out.println();
        link.deleteFirst();
        link.travel();

        System.out.println();
        link.addFirst(10);
        link.travel();

    }
}
