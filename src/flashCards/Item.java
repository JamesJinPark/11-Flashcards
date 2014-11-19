/**
 * 
 */
package flashCards;

/**
 * @author James Park
 */
public class Item {
	
	String response;
	String stimulus;
	int numCorrect = 0;
	
    public Item(String stimulus, String response) {
    	this.stimulus= stimulus;
    	this.response = response;
    }
    
    public String getStimulus() {
        return stimulus;
    }
    
    public void setStimulus(String stimulus) {
         this.stimulus = stimulus;
    }
    
    public String getResponse() {
    	return response;
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    
    public int getTimesCorrect() {
    	return numCorrect;
    }
    
    public void setTimesCorrect(int times) {
        numCorrect = times;
    }
    
    @Override 
    public int hashCode() {
    	return this.stimulus.hashCode() + this.response.hashCode();
    }
    
    @Override
    public boolean equals (Object other) {
		//Check if other is an instance of Item
		if (!(other instanceof Item)) {
			return false;
		}
	
		//Cast other to an Item
		Item that = (Item) other;
	
		//Check if the Item fields are equal.
		return this.getStimulus() == that.getStimulus() && 
				this.getResponse() == that.getResponse();	
	}

}
