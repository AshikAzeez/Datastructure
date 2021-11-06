package Datastructure;

class SinglyLinkedList {

    private static ListNode<Integer> head = null; //By default head will be null;


    public static ListNode<Integer> getHead() {
        return head;
    }

    public static void setHead(ListNode<Integer> head) {
        SinglyLinkedList.head = head;
    }

    public static void main(String[] args) {
        //Add value into head
        head = new ListNode<>();
        head.data = 10;

        //Second list node created
        ListNode<Integer> second = new ListNode<>();
        second.data = 20;
        second.next = null;
        head.next = second; //set value for Head next

        //Third list node
        ListNode<Integer> third = new ListNode<>();
        third.data = 30;
        second.next = third;
        third.next = null;

        ListNode<Integer> fourth = new ListNode<>();
        fourth.data = 40;
        fourth.next = null;
        third.next = fourth;

        printOnlyTheDataFromListNode();
        findLengthOfLinkedList();
        insertNewNodeIntoListNodeAtBeginning();

        System.out.println("List node after insertion at first:");
        printOnlyTheDataFromListNode();

        insertNewNodeAtTheEnd(new ListNode<>(50));
        System.out.println("List node after insertion at the end:");
        printOnlyTheDataFromListNode();
    }


    public static void insertNodeAtGivenPosition(int position) {
        //Take position=4
        //Here i'm taking position from 1. not fom zero
        //Create new node to add
        ListNode<Integer> newNode = new ListNode<>(34);
        if (position == 1) {
            insertNewNodeIntoListNodeAtBeginning(newNode);
        } else if (position == returnLenghtOfLinkedList()+1) {
            insertNewNodeAtTheEnd(newNode);
        } else {
            ListNode<Integer> previousNode = head;
            int count = 1;//Starting from position 1
            while (count < position - 1) {
                previousNode = previousNode.next;
                count++;
            }
            newNode.next = previousNode.next;
            previousNode.next = newNode;


        }

    }

    public static void printOnlyTheDataFromListNode() {
        ListNode<Integer> current = head;
        while (current != null) {//Whether it is reached to last list node. last list node always null in Singly linked list
            System.out.print(current.data + "--->");
            current = current.next;
        }
        System.out.println("null");

    }


    public static int returnLenghtOfLinkedList() {
        int count = 0;
        ListNode<Integer> current = head;
        if (current == null) return 0;

        while (current != null) {
            current = current.next;
            count = count + 1;
        }
        return count;
    }

    public static void findLengthOfLinkedList() {
        int count = 0;
        ListNode<Integer> current = head;
        if (current == null) return;

        while (current != null) {
            current = current.next;
            count = count + 1;
        }
        System.out.println("length of the node" + count);
    }


    public static void insertNewNodeAtTheEnd(ListNode<Integer> node) {//Looping from start to end

        if (head == null) {
            head = node;
            head.next = null;//Always null for single node
            return;
        }
        ListNode<Integer> current = head;
        while (current.next != null) {
            current = current.next;//This will change both data and next value
        }
        current.next = node;
    }


    //method overloading
    public static void insertNewNodeIntoListNodeAtBeginning() {
        ListNode<Integer> newNode = new ListNode<>(5);
        newNode.next = head;
        head = newNode;
    }

    //method overloading
    public static void insertNewNodeIntoListNodeAtBeginning(ListNode<Integer> newNode) {
        newNode.next = head;
        head = newNode;
    }

    public static class ListNode<T> {
        private T data; //
        private ListNode<T> next;//Null by default

        public ListNode() {
        }

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public void setNext(ListNode<T> next) {
            this.next = next;
        }
    }


}
