import java.util.Scanner;

class Link {
    int data;
    Link next;

    public Link(int d){
        data = d;
    }
}

class Deque {
    Link first;
    
    public Deque() {
        first = null;
    }

    public void insertFirst(int d) {
        Link nl = new Link(d);

        if (first == null)
            first = nl;
        else {
            nl.next = first;
            first = nl;
        }
    }

    public void deleteFirst() {
        if (first != null) {
            first = first.next;
            System.out.println("Deleted the last element!");
        } else {
            System.out.println("The deque is empty!");
        }
    }

    public void insertLast(int d) {
        Link nl = new Link(d);
        Link cur = first;
        if (cur == null) { // The queue is empty
            first = nl; 
            return;
        }
            
        while (cur.next != null)
            cur = cur.next;
        cur.next = nl; 
    }

    public void deleteLast() {
        Link cur = first;
        if (cur == null) {
            System.out.println("The deque is empty!");
        } else {
            Link prev = null;
            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
            }
            if (prev != null) { // Means that the deque has only a single element
                prev.next = null;
            } else {
                first = null;
            }
            System.out.println("Deleted the last element!");
        }
    }

    public void display() {
        Link cur;
        cur = first;
        if (cur == null) {
            System.out.println("The deque is empty!");
        } else {
            System.out.print("The deque is : ");
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

class Driver {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Deque dq = new Deque();

        int op, data;
        while (true) {
            System.out.println("Enter an option to continue");
            System.out.println("0. Quit");
            System.out.println("1. Insert an element at the beginning");
            System.out.println("2. Delete the first element");
            System.out.println("3. Insert an element at the end");
            System.out.println("4. Delete the last element");
            System.out.println("5. Display the queue");
            op = obj.nextInt();
            obj.nextLine(); // Consuming trailing newline
            switch (op) {
                case 0:
                    return; 
                case 1:
                    System.out.print("Enter data to insert : ");
                    data = obj.nextInt();
                    obj.nextLine(); // To consume the trailing newline
                    dq.insertFirst(data);
                    break;
                case 2:
                    dq.deleteFirst();
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    data = obj.nextInt();
                    obj.nextLine();
                    dq.insertLast(data);
                    break;
                case 4:
                    dq.deleteLast();
                    break;
                case 5:
                    dq.display();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}
