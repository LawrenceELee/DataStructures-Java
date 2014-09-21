/** *************************************************
 * Stack implemenation using nodes.
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

    public String toString(){
        StringBuilder val = new StringBuilder();
        
        Node runner = top;
        while(runner != null){
            val.append( runner.data );
            val.append(' ');

            runner = runner.next;
        }

        return val.toString();
    }


    //Tester/Driver for StackLL.
    public static void main(String args[]){
        StackLL stk = new StackLL();

        assert stk.isEmpty();

        //push odd numbers onto stack
        for( int i=1; i < 10; i+=2 ){
            System.out.println(stk.toString());
            stk.push(i);
        }

        System.out.println(stk.toString());
        assert stk.peek() == 9;

        while( !stk.isEmpty() ){
            stk.pop();
            System.out.println(stk.toString());
        }

    }
}
