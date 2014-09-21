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
    private int N = 0;

    public void push(int item){
        Node newTop = new Node(item);
        newTop.next = top;
        top         = newTop;

        ++N;
    }

    public Object pop(){
        if( !isEmpty() ){
            Object item = top.data;
            top      = top.next;
            --N;
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

    public int size(){
        return N;
    }


    //Tester/Driver for StackLL.
    public static void main(String args[]){
        StackLL stk = new StackLL();

        assert stk.isEmpty();

        //push odd numbers onto stack
        for( int i=1; i < 10; i+=2 ){
            stk.push(i);
        }

        assert stk.peek() == 9;

    }
}
