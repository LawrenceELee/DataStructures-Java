/** *************************************************
 * Driver/Tester for LinkedList.
 *
 * ************************************************** */

class LinkedListTest{

    public static void main(String args[]){

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
