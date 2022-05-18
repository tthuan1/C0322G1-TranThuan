package ss10_list.exercise.linkedList;

public class MyLinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    //Phần tử đầu tiên của danh sách liên kết
    private Node head;
    //Số lượng phàn tử trong danh sách
    private int numNodes = 0;

    public MyLinkedList() {

    }

    public void addFirst(E element) {
        //Khai báo 1 biến là temp trỏ đến giá trị của head
        Node temp = head;
        //Biến head sẽ nhận giá trị là 1 node mới
        head = new Node(element);
        //head.next trở đến temp
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        //Khai báo biến temp trỏ đến head
        Node temp = head;
        //Sẽ cho con trỏ chạy đến phần tử cuối cùng của danh sách
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        //Khai báo biến temp trỏ đến head
        Node temp = head;

        //Khai báo 1 node là holder
        Node holder;

        //cho con trỏ chạy đến vị trí index -1
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        //cho holder tham chiếu đến vị trí index
        holder = temp.next;
        //node tại vị trí index -1 sẽ trỏ tới node mới
        temp.next = new Node(element);
        //node mới sẽ trỏ đến holder
        temp.next.next = holder;
        //tăng số lượng phần tử trong danh sách lên 1
        numNodes++;
    }

    public Object get(int index) {
        //Khai báo biến temp trỏ tới head
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Error indexx: " + index);
        }
        //Khai báo biến temp trỏ đến head
        Node temp = head;
        Object data;
        //Nếu index = 0 thì sex trả về data hiện tại
        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public boolean remove(E element) {
        //remove đối tượng nếu nó là head
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            //khai báo 1 biến temp trỏ đến head
            Node temp = head;
            while (temp.next != null) {
                //nếu như tồn tại 1 phần tử có data bằng data truyền vào thì node đó sẽ bị remove
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    public MyLinkedList<E> clone() {
        //kiểm tra linkedList có phần tử hay không
        if (numNodes == 0) {
            throw new IllegalArgumentException("LinkedList null");
        }
        //Khai báo linkedList trả về
        MyLinkedList<E> returnLinkedList = new MyLinkedList<>();
        //khai báo 1 temp trỏ đến head
        Node temp = head;
        //add temp vào danh sách trả về để nó làm head
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean constrains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

}
