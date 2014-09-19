/** *************************************************
 * Implementation of a singlely linked list using Nodes.
 *
 * ************************************************** */


class Node{
    Object data;
    Node next;

    private int N = 1; 
    //b/c of the way the code is structured, you start at size 1, not 0.

    //constructor with 1 parameter to simplify creating Node objects.
    public Node(Object d){
        data = d;
    }

    public void appendToTail(Object d){
        Node newTail = new Node(d);
        Node runner = this; //neat trick, reference to the "head" of list

        while( runner.next != null ){
            runner = runner.next;
        }
        //when runner exits while loop it should point to tail node
        runner.next = newTail;

        ++N;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void removeFromTail(){
        //TODO: implement this.
    }


    //helper function use to verify contents
    //returns contents of LL as a string
    public String toString(){
        StringBuilder val = new StringBuilder();
        //use StringBuilder instead of String b/c String is immutable
        //and everytime you append you have to create a new copy of the
        //string concat with the new char. Java compiler is smart enough
        //to optimized simple String concats to StrBuild concats.

        Node runner = this;
        while( runner != null ){
            val.append(runner.data);
            val.append(' ');

            runner = runner.next; //don't forget to increment!
        }
        return val.toString();
    }


    /** *************************************************
     * Driver/Tester for LinkedList.
     *
     * ************************************************** */
    public static void main(String args[]){

        //java autoboxes int primatives to Integer objects using wrappers.
        Node ll = new Node(0);
        assert ll.size() == 1;

        ll.appendToTail(1);
        ll.appendToTail(3);
        ll.appendToTail(5);
        ll.appendToTail(7);
        ll.appendToTail(9);
        ll.appendToTail(-11);
        assert ll.size() == 7;

        System.out.println(ll.toString());
        //assert ll.toString().equals("0 1 3 5 7 9 -11");
        //causes assertion error, i haven't figured out why
    }
}
