/** *************************************************
 * Stack implemenation using nodes.
 *
 * Uses Node.java from LinkedList.
 *
 * To compile, go to same dir as .java files:
 * javac -cp ../LinkedList/ StackLL.java
 *
 * To run, be in same dir as StackLL.java:
 * java StackLL
 *
 * ************************************************** */

class StackLL{
    Node top = null;

    public void push(int item){
        Node newTop = new Node(item);
        newTop.next = top;
        top         = newTop;
    }

    public Object pop(){
        if( !isEmpty() ){
            Object item = top.data;
            top      = top.next;
            return item;
        }
        //else
        return null;
    }

    public Object peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }


    //Tester/Driver for StackLL.
    public static void main(String args[]){
        StackLL stk = new StackLL();

        assert stk.isEmpty();
    }
}
