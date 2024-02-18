import java.util.Arrays;

/**
 * This is the class represents the ArrayListInOrder object that holds Comparable elements objects.
 */
public class ArrayListInOrder<E extends Comparable<E>>{

    E[] data;
    int size;
    static final int INITIAL_SIZE = 10;

    /**
     * Default constructor that creates a new ArrayListInOrder.
     */
    public ArrayListInOrder() {
        this.data = (E[]) new Comparable[INITIAL_SIZE];
        this.size = 0;
    }

    /**
     * Check if all elements in the ArrayListInOrder are in a non-descending order
     * @return true if all elements are in a non-descending order; otherwise return false
     */
    public boolean isInOrder() {
        for (int i = 1; i < size; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) return false;
        }
        return true;
    }

    /**
     * Add a new object to the current list of array
     * @param element the object to be added to the current arraylist
     */
    public void add(E element) {
        if (!isInOrder()) throw new IllegalStateException("The current array is not in order!");
        if (!(element instanceof Coordinates)) throw new IllegalArgumentException("This is not a valid Coordinate Object!");
        E[] newArray;
        if (size == data.length) newArray = (E[]) new Comparable[data.length * 2];
        else newArray = (E[]) new Comparable[data.length];
        int i = 0;
        while (i < size && data[i].compareTo(element) <= 0) newArray[i] = data[i++];
        newArray[i] = element;
        while (i < size) newArray[i+1] = data[i++];
        data = newArray;
        size++;
    }

    /**
     * Get the data array.
     * @return the data array
     */
    public E[] getData() {
        return data;
    }

    /**
     * Get the size of the arraylist
     * @return the size of the arrayList
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the capability of the current data array
     * @return the current length of data array
     */
    public int getCapability() {
        return getData().length;
    }

    /**
     * Generates new String representation of the ArrayListInOrder objects
     * @return the String representation of the ArrayListInOrder
     */
    @Override
    public String toString() {
        return "ArrayListInOrder{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
