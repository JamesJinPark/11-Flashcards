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
public class ItemTest {

	Item out;
	private static String DEFAULT_STIMULUS = "What is your name?";
	private static String DEFAULT_RESPONSE = "James Park";
	
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {    	
    	out = new Item (DEFAULT_STIMULUS, DEFAULT_RESPONSE);
    }

    /**
     * Test method for {@link flashCards.Item#Item(java.lang.String, java.lang.String)}.
     */
    @Test
    public final void testItem() {
        new Item("How old are you?", "I am 28 years old.");
    }

    /**
     * Test method for {@link flashCards.Item#setStimulus(java.lang.String)} and
     * {@link flashCards.Item#getStimulus()} (combined).
     */
    @Test
    public final void testSetAndGetStimulus() {
    	assertEquals("James Park", out.getResponse());
        String testStimulus = "Do you enjoy cooking?";
    	out.setStimulus(testStimulus);
    	assertEquals(testStimulus, out.getStimulus());
    }

    /**
     * Test method for {@link flashCards.Item#setResponse(java.lang.String)} and
     * {@link flashCards.Item#getResponse()} (combined).
     */
    @Test
    public final void testSetAndGetResponse() {
        String testResponse = "Yes, I enjoy cooking.";
        out.setResponse(testResponse);
        assertEquals(testResponse, out.getResponse());
    }

    /**
     * Test method for {@link flashCards.Item#setTimesCorrect(int)} and
     * {@link flashCards.Item#getTimesCorrect()} (combined).
     */
    @Test
    public final void testSetAndGetTimesCorrect() {
        int testTime = 0;
        out.setTimesCorrect(testTime);
        assertEquals(testTime, out.getTimesCorrect());
    }

}