import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortedComparableList {
	@Test
	public void testInsert(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		assertEquals(-3, list.head);
		assertEquals(0, list.tail.head);
		assertEquals(5, list.tail.tail.head);
		list.insert(-6);
		assertEquals(-6,list.head);
	}

	@Test
	public void testGet(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		assertEquals(0, list.get(1));
		assertEquals(-3, list.get(0));
		assertEquals(5, list.get(2));		
	}
	
	@Test
	public void testExtend(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);

		SortedComparableList list2 = new SortedComparableList();
		list2.insert(7);
		list2.insert(8);

		list.extend(list2);

		assertEquals(-3, list.get(0));
		assertEquals(0, list.get(1));
		assertEquals(0, list.get(2));
		assertEquals(5, list.get(3));
		assertEquals(7, list.get(4));
		assertEquals(8, list.get(5));

		list = new SortedComparableList();
		list2 = new SortedComparableList();
		list2.insert(10);
		list.extend(list2);
		assertEquals(0, list.get(0));
		assertEquals(0, list.get(1));
		assertEquals(10, list.get(2));

		list = new SortedComparableList();
		list.insert(4);
		list2 = new SortedComparableList();
		list.extend(list2);
		assertEquals(0, list.get(0));
		assertEquals(0, list.get(1));
		assertEquals(4, list.get(2));
	}

	@Test
	public void testSubTail(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		list.insert(9);
		SortedComparableList result = SortedComparableList.subTail(list, 1);
		assertEquals(0, result.get(0));
		assertEquals(5, result.get(1));

		list = null;
		result = SortedComparableList.subTail(list, 1);
		assertEquals(null, result);

		list = new SortedComparableList();
		result = SortedComparableList.subTail(list, 5);
		assertEquals(null, result);
	}

	@Test
	public void testSublist(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		list.insert(6);
		list.insert(10);
		list.insert(15);
		SortedComparableList result = SortedComparableList.sublist(list, 2, 4);
		assertEquals(5, result.get(0));
		assertEquals(6, result.get(1));
		assertEquals(10, result.get(2));	

		list = null;
		result = SortedComparableList.sublist(list, 0, 2);
		assertEquals(null, result);	
	}

	@Test
	public void testExpungeTail(){
		SortedComparableList list = new SortedComparableList();
		list.insert(-3);
		list.insert(5);
		list.insert(4);
		list.insert(9);
		list.insert(11);
		SortedComparableList.expungeTail(list, 3);
		assertEquals(-3, list.get(0));
		assertEquals(0, list.get(1));
		assertEquals(4, list.get(2));
		assertEquals(5, list.tail.tail.tail.head);
		assertEquals(null, list.tail.tail.tail.tail);
		list = null;
		SortedComparableList.expungeTail(list, 3);
		assertEquals(null, list);	

		// list = new SortedComparableList();
		// SortedComparableList.expungeTail(0);
		// assertEquals(null, list);	
	}

	@Test
	public void testSquish(){
		SortedComparableList list = new SortedComparableList();
		list.insert(0);
		list.insert(3);
		list.insert(4);
		list.insert(4);
		list.squish();
		assertEquals(0, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(4, list.get(2));
		assertEquals("(0, 3, 4)", list.toString());	
	}

	@Test
	public void testTwin(){
		SortedComparableList list = new SortedComparableList();
		list.insert(3);
		list.insert(4);
		list.twin();
		assertEquals("(0, 0, 3, 3, 4, 4)", list.toString());		
	}

	public static void main(String[] args){
		jh61b.junit.textui.runClasses(TestSortedComparableList.class);

	}
}
