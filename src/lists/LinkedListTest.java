package lists;
/** A Driver for the LinkedList class */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		Object obj5 = new Integer(5);

		llist.add(obj5);
		llist.add(15);
		Object obj6 = new Integer(6);
		llist.add(obj6);
		llist.add(6); //24);
		llist.add(15); //58);
		
		llist.print();
		System.out.println("Appending 47");
		llist.add(5); //47);
		System.out.println("Inserting 99 at index 3");
		llist.add(3, 99);
		llist.add(4, 99);

		System.out.println("List: ");
		llist.print();
		
	}
}
