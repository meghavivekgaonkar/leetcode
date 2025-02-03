import java.util.HashMap;
import java.util.Map;

class LRUString {
    class Node{
        int key;
        String val;
        Node left;
        Node right; 
        public Node(int key, String val, Node left, Node right){
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int capacity;
    Map<Integer, Node> hashMap = new HashMap<>();
    Node head = null;
    Node tail = head;

    public LRUString(int capacity) {
      this.capacity = capacity;
    }
    
    public String get(int key) {
        if(hashMap.containsKey(key)){
            Node temp = hashMap.get(key);
            //update Node head here 
            if(head != temp){
                if( tail != temp){
                    temp.left.right = temp.right;
                    temp.right.left = temp.left;       
                }else{
                    temp.left.right = null;
                    tail = temp.left;
                }
                head.left = temp;
                temp.right = head;
                temp.left = null;
                head = temp;
            }
            return head.val;
        }else{
            return null;
        }
    }
    
    public void put(int key, String value) {
       if(hashMap.containsKey(key)){
            //get the element from map
            Node temp = hashMap.get(key);
            //update lru
            temp.val = value;
            if(temp != head){
                if(temp == tail){
                temp.left.right = null;
                tail = temp.left;

                }else if(temp != head){
                    temp.left.right = temp.right;
                    temp.right.left = temp.left;  
                }
                head.left = temp;
                temp.right = head;
                temp.left = null;
                head = temp;
            }

       }else{
            //check if hash map size has reached capacity
            //evict the least recent used from cache
            if(hashMap.size()==capacity){
                evict();
            }
          
            if(hashMap.isEmpty()){
                Node newNode = new Node(key, value, null,  null);
                head = newNode;
                tail = newNode;
            }else
            {
                Node newNode = new Node(key, value, null,  head);
                if(hashMap.size() == 1){
                    tail = head;
                    tail.left = newNode;
                    tail.right = null;
                }else{
                    head.left = newNode;
                }
                head = newNode;
            }
            hashMap.put(key, head);
       }
    }

    public void evict(){
        hashMap.remove(tail.key);
        tail = tail.left;
        tail.right = null;
    }


    public static void main(String[] args) {
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        LRUString obj = new LRUString(3);
        obj.put(1, "Avi");
        obj.put(2, "Coco");
        obj.put(3, "Megha");
        obj.put(4, "Avi");
        System.out.println(obj.get(4));  //4
        System.out.println(obj.get(3));  //3
        System.out.println(obj.get(2));  //2
        System.out.println(obj.get(1));  //-1 
        obj.put(5, "Coco");           
        System.out.println(obj.get(1));  // -1
        System.out.println(obj.get(2));  // 2
        System.out.println(obj.get(3));  // 3
        System.out.println(obj.get(4));  // -1 
        System.out.println(obj.get(5)); // 5
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

