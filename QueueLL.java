/** *************************************************
 * Queue implemented using list of nodes.
 * ************************************************** */

class QueueLL{
    Node first = null;
    Node last = null;

    private int N = 0;

    public void enqueue(Object item){
        if( isEmpty() ){
            first = new Node(item);
            last = first;
        } else {
            Node newLast = new Node(item);
            last.next    = newLast;
            last         = newLast;
        }
        ++N;
    }

    public Object dequeue(){
        if( !isEmpty() ){
            Object item = first.data;
            first       = first.next;
            --N;
            return item;
        }
        return null;
    }

    public boolean isEmpty(){
        return first == null; //or size() == 0;
    }

    public int size(){
        return N;
    }

    //override default toString which prints objects id/hashcode()
    //instead to print contents of data structure
    public String toString(){
        StringBuilder val = new StringBuilder();
        Node runner = first;

        while(runner != null){
            val.append(runner.data);
            val.append(' ');

            runner = runner.next;
        }
        return val.toString();
    }


    //driver/tester
    public static void main(String args[]){
        QueueLL que = new QueueLL();

        assert que.size() == 0;

        for(int i=1; i < 10; i+=2){
            que.enqueue(i);
            System.out.println(que.toString());
        }

        while( !que.isEmpty() ){
            que.dequeue();
            System.out.println(que.toString());
        }
    }

}
