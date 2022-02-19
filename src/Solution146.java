import java.util.HashMap;
import java.util.Map;

public class Solution146 {
}

class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(){}
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer,Node> map=  new HashMap<Integer,Node>();

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        Node head = new Node();
        Node tail = new Node();
        head.next=tail;
        tail.prev=head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        else{
            moveToHead(node);
            return node.value;

        }
    }
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node==null){
            Node newNode = new Node(key, value);
            addHead(newNode);
            map.put(key,newNode);
            size++;
            if(size>capacity){
                Node end = deleteEnd();
                map.remove(end.key);
                size--;
            }
        }
        else {
            node.value=value;
            moveToHead(node);
        }
    }
    void delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    void addHead(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    void moveToHead(Node node){
        delete(node);
        addHead(node);
    }
    Node deleteEnd(){
        Node end = tail.prev;
        delete(end);
        return end;
    }


}