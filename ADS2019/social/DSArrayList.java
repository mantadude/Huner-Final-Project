/**
 * DSArrayList
 */
public class DSArrayList<E> {

    private E[] array;
    private int length;

    public DSArrayList() {
        this(10);
    }
    
    public DSArrayList(int initialCapacity) {
        array = (E[])(new Object[initialCapacity]);
        length = 0;
    }
    
    private void resize() {
        E[] newArray = (E[])(new Object[array.length*2]);
        for(int i=0; i<array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void add(E item) {
        if(length == array.length) {
            resize();
        }
        array[length] = item;
        length++;
    }

    public void remove(int idx) {
        for(int i=idx; i<length-1; i++) {
            array[i+1] = array[i];
        }
        length--;
    }

    public E get(int idx) {
        if(idx < length)
            return array[idx];
        else
            throw new ArrayIndexOutOfBoundsException(idx);
    }

    public void set(int idx, E item) {
        if(idx < length) {
            array[idx] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
    }

    public void insert(int idx, E item) {
        if(idx < length) {
            if(length == array.length) {
                resize();
            }
            for(int i=length; i>idx; i--) {
                array[i] = array[i-1];
            }
            array[idx] = item;
            length++;
        } else {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
    }

    public int size() {
        return length;
    }

    public String toString() {
        String string = "[";
        for(int i=0; i<length; i++) {
            string += get(i) + ", ";
        }
        string = string.substring(0, string.length()-2);
        return string + "]";
    }

    public DSArrayList<E> reverse() {
        DSArrayList<E> reversed = new DSArrayList<E>(length);
        for(int i=length-1; i>=0; i--) {
            reversed.add(get(i));
        }
        return reversed;
    }
}