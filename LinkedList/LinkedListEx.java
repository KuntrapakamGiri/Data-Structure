class LinkedListEx {
    ListNode head;

    // Node structure for the linked list
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert element at the beginning of the list
    public void insertFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head; // point new node to current head
        head = newNode;      // update head
    }

    // Insert element at the end of the list
    public void insertLast(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {  // if list is empty
            head = newNode;
            return;
        }

        ListNode curr = head;
        while (curr.next != null) { // traverse to last node
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Insert element at a specific position (1-based index)
    public void insertAtPos(int val, int pos) {
        ListNode newNode = new ListNode(val);

        if (pos == 1) { // insert at head
            newNode.next = head;
            head = newNode;
            return;
        }

        int cnt = 1;
        ListNode prev = head;
        while (cnt < pos - 1 && prev != null) { // move to (pos-1)th node
            prev = prev.next;
            cnt++;
        }

        if (prev == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = prev.next; // link new node
        prev.next = newNode;
    }

    // Delete first node
    public int deleteFirst() {
        if (head == null) return -1; // empty list

        ListNode temp = head;
        head = head.next;   // move head to next node
        temp.next = null;   // disconnect node
        return temp.data;
    }

    // Delete last node
    public int deleteLast() {
        if (head == null) return -1;  // empty list
        if (head.next == null) {      // only one node
            int val = head.data;
            head = null;
            return val;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr.next != null) {  // move till last node
            prev = curr;
            curr = curr.next;
        }
        prev.next = null; // remove last node
        return curr.data;
    }

    // Delete node at specific position (1-based index)
    public int deleteAtPos(int pos) {
        if (head == null) return -1; // empty list

        ListNode curr = head;
        if (pos == 1) { // delete head
            head = head.next;
            curr.next = null;
            return curr.data;
        }

        ListNode prev = null;
        int cnt = 1;
        while (cnt < pos && curr != null) { // move to pos
            prev = curr;
            curr = curr.next;
            cnt++;
        }

        if (curr == null) {
            System.out.println("Invalid position!");
            return -1;
        }

        prev.next = curr.next; // unlink node
        curr.next = null;
        return curr.data;
    }

    // Find length of list
    public int length() {
        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        return cnt;
    }

    // Display list elements
    public void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null\n");
    }

    // Reverse linked list and return new head
    public static ListNode reverseLst(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;  // save next
            curr.next = prev;  // reverse link
            prev = curr;       // move prev forward
            curr = next;       // move curr forward
        }
        return prev; // new head
    }

    // Driver code
    public static void main(String[] args) {
        LinkedListEx sll = new LinkedListEx();

        // Creating linked list manually
        sll.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Insert operations
        sll.insertFirst(0);
        sll.insertAtPos(15, 3);
        sll.insertLast(60);
        sll.insertLast(70);
        sll.insertLast(80);
        sll.insertLast(90);
        sll.insertLast(100);

        System.out.println("Initial list:");
        sll.display(sll.head);

        // Delete first
        int val3 = sll.deleteFirst();
        System.out.println("\nAfter deleting first (" + val3 + "):");
        sll.display(sll.head);

        // Delete last
        int val4 = sll.deleteLast();
        System.out.println("\nAfter deleting last (" + val4 + "):");
        sll.display(sll.head);

        // Delete at position
        int pos1 = 4;
        int val5 = sll.deleteAtPos(pos1);
        System.out.println("\nAfter deleting at pos " + pos1 + " (" + val5 + "):");
        sll.display(sll.head);

        // Length
        System.out.println("\nLength: " + sll.length());

        // Reverse list
        sll.head = reverseLst(sll.head);
        System.out.println("\nReversed list:");
        sll.display(sll.head);
    }
}
