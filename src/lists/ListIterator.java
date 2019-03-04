package lists;

public interface ListIterator {

    public boolean hasNext();
    public Object next();

    public boolean hasPrevious();
    public Object previous();

    public void add(Object elem);
    public void remove();
}
