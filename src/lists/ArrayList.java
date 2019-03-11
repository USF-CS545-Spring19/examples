package lists;

public class ArrayList implements List {

	/*----------------------------------------------------- */
	/* Private Data Members -- ArrayList */
	/*----------------------------------------------------- */

    private static final int DEFAULT_MAX_SIZE = 10;
    private int maxsize;
    private int currentSize;
    private Object data[];

	/*----------------------------------------------------- */
	/* Constructors -- ArrayList */
	/*----------------------------------------------------- */

    ArrayList() {
        maxsize = DEFAULT_MAX_SIZE;
        currentSize = 0;
        data = new Object[maxsize];
    }

    ArrayList(int maximumSize) {
        maxsize = maximumSize;
        currentSize = 0;
        data = new Object[maxsize];
    }

	/*----------------------------------------------------- */
	/* Public Methods -- ArrayList */
	/*----------------------------------------------------- */

    public void clear() {
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    /** Append the element to the list */
    public void add(Object elem) {
        if (currentSize >= maxsize) {
            System.out.println("List is full");
            return;
        }
        data[currentSize] = elem;
        currentSize++;
    }

    /** Insert an element at a given index */
    public void add(int index, Object elem) {
        // is index valid?
        if ((index >= currentSize) || (index < 0)) {
            System.out.println("Index out of bounds");
            return;
        }
        // is there space in the list?
        else if (currentSize >= maxsize) {
            System.out.println("List is full");
            return;
        }
        // shift all elements starting at index to the right
        for (int i = currentSize; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = elem;
        currentSize++;
    }

    /** Return the element of the list at the given index */
    public Object get(int index) {
        if (index < 0 || index < currentSize) {
            System.out.println("Index out of bounds");
            return null;
        }
        return data[index];
    }

    /** Remove the element of the list at the given index */
    public void remove(int index) {
        if (index < 0 || index < currentSize) {
            System.out.println("Index out of bounds");
            return;
        }
        // shift all elements starting at index + 1 to the left
        for (int i = index + 1; i < currentSize; i++) {
            data[i - 1] = data[i];
        }
        currentSize--;
    }

    /**
     * Remove the first occurrence of a given element.
     */
    public void remove(Object elem) {
        int removeIndex;
        // first find the index of the first occurrence of the element
        for (removeIndex = 0; removeIndex < currentSize && !elem.equals(data[removeIndex]); removeIndex++)
            ;
        if (removeIndex < currentSize) {
            remove(removeIndex);
        }
    }

    public void print() {
        ListIterator it = listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "  ");
        }
        System.out.println();
    }

    /**
     * Return an iterator for the list. Iterator starts from the beginning of
     * the list.
     */
    public ListIterator listIterator() {
        return new InnerIterator(0);
    }

    /**
     * Return an iterator for the list. Iterator starts from a given position.
     */
    public ListIterator listIterator(int index) {
        return new InnerIterator(index);
    }

	/*----------------------------------------------------- */
	/* Nested class -- InnerIterator */
	/*----------------------------------------------------- */

    private class InnerIterator implements ListIterator {

		/*----------------------------------------------------- */
		/* Private Data Members -- InnerIterator */
		/*----------------------------------------------------- */

        private int nextIndex; // the index of the "next" element

		/*----------------------------------------------------- */
		/* Constructor -- InnerIterator */
		/*----------------------------------------------------- */

        public InnerIterator(int startingIndex) {
            nextIndex = startingIndex;
        }

		/*----------------------------------------------------- */
		/* Public Methods -- InnerIterator */
		/*----------------------------------------------------- */

        public Object next() {
            if (nextIndex >= currentSize) {
                System.out.println("No next element");
                return null;
            }
            Object objectToReturn = data[nextIndex]; // the "next" element
            nextIndex++;
            return objectToReturn;

            // return data[nextIndex++]; // alternatively we could done this
        }

        /** Return true if there is a next element, false otherwise */
        public boolean hasNext() {
            return (nextIndex < currentSize && nextIndex >= 0);
        }

        /** Return the "previous" element */
        public Object previous() {
            if (nextIndex <= 0) {
                System.out.println("No previous element");
                return null;
            }
            nextIndex = nextIndex - 1;
            return data[nextIndex];

            // return data[--nextIndex]; //alternatively, we could have done
            // this
        }

        /**
         * Return true if there is a previous element (on the left of the
         * iterator)
         */
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /** Change the value of the element at the current position
         *
         * @param value new value
         */
        public void set(Object value) {
            if (nextIndex < 0) { // =
                System.out.println("No current element to set");
                return;
            }
            data[nextIndex] = value;
        }

        /** Insert the element right before "next" */
        public void add(Object elem) {
            int i;
            if (currentSize >= maxsize)  {
                System.out.println("List is full");
                return;
            }
            else if (nextIndex < 0 || nextIndex > currentSize) {
                System.out.println("Iterator not in list");
                return;
            }

            // shift elements starting at index nextIndex to the right
            for (i = currentSize; i > nextIndex; i--)
                data[i] = data[i - 1];
            // insert a new element at nextIndex
            data[nextIndex] = elem;
            nextIndex++; // move to the next element
            currentSize++;
        }

        /** Remove the element to the left of the iterator */
        public void remove() {
            if (currentSize <= 0) {
                System.out.println("List is empty");
                return;
            }
            if (nextIndex <= 0 || nextIndex > currentSize) {
                System.out.println("No current element to delete");
                return;
            }
            // Shift all the elements starting at nextIndex to the left
            for (int i = nextIndex; i < currentSize; i++)
                data[i - 1] = data[i];
            currentSize--;
            nextIndex--;
        }

    }


}
