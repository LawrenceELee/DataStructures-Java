/** *************************************************
 * Dynamically resizing array (ArrayList) implmented using array.
 *
 * Stores generics.
 * A subset of operations avaiable in Java ArrayList API.
 *
 * ************************************************** */

import java.util.Iterator;

class ArrayList<AnyType> implements Iterable<AnyType>{
    private AnyType[] a = null;
    private int N = 0; //keeps track of count of elments

    public ArrayList(){
        this(5); //if no starting size give, then set as 10.
    }

    public ArrayList(int size){
        //can not create generic arrays, so have to do ugly cast
        a = (AnyType[]) new Object[size];
    }

    public AnyType get(int idx){
        return a[idx];
    }

    public void add(AnyType item){
        if( N == a.length )     resize(2*a.length);
        a[N++] = item;
    }

    public AnyType remove(int idx){
        AnyType item = a[--N];
        a[N] = null;

        //check of removing elmt reduces array to 1/4 original size
        //if so, resize array accordingly. Do this on 1/4 instead of 1/2
        //because 1/2 might contribute to thrashing of that boundry (i.e.
        //adding and removing at the 1/2 boundry will call resize too much).
        if( N > 0 && N == a.length/4)   resize(a.length/2);
        return item;
    }

    public int size(){ return N; }

    public boolean isEmpty(){ return N == 0; }

    private void resize(int max){
        AnyType[] copy = (AnyType[]) new Object[max];
        for( int i=0; i < a.length; ++i ){
            copy[i] = a[i];
        }
        a = copy;
    }

    //these methods must be implemented if 'implements Iterable'
    public Iterator<AnyType> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType>{
        private int i = 0;
        public boolean hasNext(){ return i < N; }
        public AnyType next(){ return a[i++]; }
        //needs to be implemented, but keep it empty b/c never used.
        public void remove(){ };
    }


    //tester/driver
    public static void main(String args[]){

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                          'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                          's', 't', 'u', 'v', 'w', 'x', 'y', 'z'       };


        ArrayList<Character> myArrayList = new ArrayList<>();

        int N = letters.length;

        System.out.println("initial arraylist size: " + myArrayList.size());

        System.out.println("adding letters a to z: ");
        for( int i=0; i < N; ++i ){
            myArrayList.add(letters[i]);
        }

        System.out.println("printing using iterator: ");
        Iterator it = myArrayList.iterator();
        while( it.hasNext() ){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("printing using foreach loop: ");
        for( Character c : myArrayList ){
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("after adding elmts size: " + myArrayList.size());

        for( int i=0; i < myArrayList.size(); i+=3 ){
            System.out.println("removing: " + myArrayList.remove(i));
        }
        System.out.println("after removeing elmts size: " + myArrayList.size());
    }
}
