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
		llist.add(24);		
		llist.add(58);
		
		llist.print();
		System.out.println("Appending 47");
		llist.add(47);
		System.out.println("Inserting 99 at index 3");
		llist.add(3, 99);
		System.out.println("List: ");
		llist.print();
		System.out.println("Remove n-th node from the end");
		llist.removeNthFromEnd(1);
		llist.print();
		//llist.remove(obj5);
		//System.out.println("After removing 5: ");
		//llist.print();
		
		ListIterator it = llist.listIterator();
		/*xwhile (it.hasNext()) {
			System.out.println(it.next());
		}*/
		System.out.println("Calling it.next(): " + it.next());
		System.out.println("Calling it.next(): " + it.next());
		System.out.println("Calling it.previous(): " + it.previous());
		System.out.println("Calling it.next(): " + it.next());
		it.add(38);
		System.out.println("Calling it.add(38): ");
		llist.print();
		it.add(101);
		System.out.println("Calling it.add(101): ");
		llist.print();


		
	}
}
