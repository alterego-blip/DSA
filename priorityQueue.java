import java.util.Scanner;

class Link {
    int data;
    Link next;

    public Link(int d) {
        data = d;
    }
}

class PriorityQueue {
    Link first;

    public PriorityQueue() {
        first = null;
    }
    
    //While pushing an element into the queue,
    //Find the correct position and insert the element
    //Can assume the elements are in the sorted order.
    public void push(int d) {
        Link nl = new Link(d);
        Link cur;        
        // It's an empty queue
        if (first == null)
            first = nl;
        else {
            Link prev = null;
            cur = first;
            while (cur != null && cur.data < nl.data) {
                prev = cur;
                cur = cur.next;
            }

            // Link needs to be inserted after prev and before cur
            // If prev is null, it means that the node has to be inserted first.
            if (prev == null) {
                nl.next = first;
                first = nl;
            } else {
                nl.next = prev.next;
                prev.next = nl;
            }
        }
    }
    // Basically, delete the last node
    public int pop() {
        Link cur, prev;
        cur = first;
        prev = null; // To remove prev might not have been initialised error
        if (first == null)
            System.out.println("Empty Queue!");
        else {
            int data;
            while (cur.next!= null) { // Find the second last element 
                prev = cur;
                cur = cur.next;
            }
            if (prev == null) {
                data = first.data;
                first = null;
            } else {
                data = cur.data;
                prev.next = null;// Which means, cur.next is null i.e cur is the last element.
            }
            return data;
        }
        return -1;
    }

    public void display() {
        Link cur = first;
        if (cur == null) {
            System.out.println("Empty Queue!");
        } else {
            System.out.print("The priority queue is : ");
        }
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        } 
        System.out.println();
    }
}


class Driver {
    public static void main(String[] args) {
        int op;
        PriorityQueue pq = new PriorityQueue();

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
                    pq.push(data);
                    break;
                case 2:
                    System.out.println("Deleted element : " + pq.pop());
                    break;
                case 3:
                    pq.display();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
   }
}
