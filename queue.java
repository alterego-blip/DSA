import java.util.Scanner;

class Link {
    int data;
    Link next;

    public Link(int d) {
        data = d;
    }
}

class Queue {
    Link first;

    public Queue() {
        first = null;
    }

    public void insert(int d) {
        Link nl = new Link(d);
        if (first == null)
            first = nl;
        else {
            nl.next = first;
            first = nl;
        }
    }

    public void delete() {
        Link cur = first;
        Link prev = null;

        if (cur == null) {
            System.out.println("The queue is empty!");
            return;
        }
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }
    }

    public void display() {
        Link cur = first;
        if (cur == null)
            System.out.println("The queue is empty!");
        else {
            System.out.println("The queue is : ");
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
class Driver {
    public static void main(String[] args) {
        int op;
        Queue q = new Queue();

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
                    q.insert(data);
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.display();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
   }
}
