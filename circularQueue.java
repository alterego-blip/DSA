import java.util.Scanner;

class Link {
    int data;
    Link next, prev;

    public Link (int d) {
        data = d;
    }
}

class circularQueue {
    Link first, last;

    public circularQueue() {
        first = last = null;
    }

    public void insert(int d) {
        Link nl = new Link(d);
        if (first == null) {
            first = last = nl;
            nl.next = nl;
            nl.prev = nl;
        } else {
            nl.next = first;
            first.prev = nl;
            nl.prev = last;
            last.next = nl;
            first = nl; 
        }
    }

    public void delete() {
        if (first == null) {
            System.out.println("The queue is empty!");
            return;
        } else if (first == last) {
            first = last = null; // There's only a single element in the list
        } else {
            last = last.prev;
            first.prev = last;
        }
        System.out.println("Deleted the element");
    }

    public void display() {
        Link cur = first;
        if (cur == null) {
            System.out.println("The queue is empty!");
        } else if (first == last) {
            System.out.println("The queue is " + first.data);
        } else {
            System.out.println("The elements are : ");
            while (cur != last) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println(cur.data); // Printing the last element
        }
    }
}

class Driver {
    public static void main(String[] args) {
        int op;
        circularQueue cq = new circularQueue();

        Scanner obj = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an option to continue");
            System.out.println("0. Quit");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Display the queue");
            op = obj.nextInt();
            obj.nextLine(); // Consuming trailing newline
            switch (op) {
                case 0:
                    return; 
                case 1:
                    System.out.print("Enter data to insert : ");
                    int data = obj.nextInt();
                    obj.nextLine(); // To consume the trailing newline
                    cq.insert(data);
                    break;
                case 2:
                    cq.delete();
                    break;
                case 3:
                    cq.display();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
   }
}
