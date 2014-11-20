/**
 * 
 */
package flashCards;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author David Matuszek and James Park
 */

public class StudyListTest {

	StudyList testList;
	private static String DEFAULT_STIMULUS = "What is your name?";
	private static String DEFAULT_RESPONSE = "James Park";
	Item testItem = new Item(DEFAULT_STIMULUS, DEFAULT_RESPONSE);
	Item testItem2 = new Item("What class are you in?", "CIT 591");
	String stringTest1 = "What is your name? || James Park";
	String stringTest2 = "What class are you in? || CIT 591 || 0";	

	
	/**
     * @throws java.lang.Exception
     */
	
	@Before
	public void setUp() throws Exception {
    	testList = new StudyList();
	}

    /**
     * Test method for {@link flashCards.StudyList#StudyList()}.
     */
	@Test
	public void testStudyList() {
        testList = new StudyList();;
	}

	/**
     * Test method for {@link flashCards.StudyList#add(flashCards.Item)}.
     */
	@Test
	public void testAdd() {
    	testList.add(testItem);
	}

    /**
     * Test method for {@link flashCards.StudyList#find(java.lang.String)}.
     */
	@Test
	public void testFind() {
    	testList.add(testItem);
    	testList.add(testItem2);
    	assertEquals(testItem, testList.find(DEFAULT_RESPONSE));
    	assertEquals(testItem, testList.find(DEFAULT_STIMULUS));
    	assertEquals(testItem2, testList.find("What class are you in?"));
    	assertEquals(testItem2, testList.find("CIT 591"));
	}

    /**
     * Test method for {@link flashCards.StudyList#delete(flashCards.Item)}.
     */
	@Test
	public void testDelete() {
    	testList.delete(testItem);
	}

    /**
     * Test method for {@link flashCards.StudyList#modify(flashCards.Item, java.lang.String, java.lang.String)}.
     */
	@Test
	public void testModify() {
    	String newStimulus = "Do you like sports?";
    	String newResponse = "Yes, I enjoy watching soccer.";
    	testList.add(testItem);
    	assertEquals(DEFAULT_STIMULUS, testItem.getStimulus());
    	assertEquals(DEFAULT_RESPONSE, testItem.getResponse());
    	testList.modify(testItem, newStimulus, newResponse);
        assertEquals(newStimulus, testItem.getStimulus());
    	assertEquals(newResponse, testItem.getResponse());
    }

    /**
     * Test method for {@link flashCards.StudyList#convertItemToString(java.lang.String)}.
     */
	@Test
	public void testConvertStringToItem() {
    	Item item1 = StudyList.convertStringToItem(stringTest1);
    	assertEquals(item1.getStimulus(), testItem.getStimulus()); 
    	assertEquals(item1.getResponse(), testItem.getResponse()); 
    }
	
    /**
     * Test method for {@link flashCards.StudyList#convertItemToString(flashCards.Item)}.
     */
    @Test
    public final void testconvertItemToString() {
    	String testString = StudyList.convertItemToString(testItem2);
    	assertEquals(testString, stringTest2);
    }
}
