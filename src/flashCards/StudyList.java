/**
 * 
 */
package flashCards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import simpleIO.SimpleIO;

/**
 * @author David Matuszek and James Park
 */
public class StudyList {
	
	List<Item> studyList;
	Item currentItem;
	/**
     * 
     */
    public StudyList() {
    	studyList = new ArrayList<Item>();
    }
    
    public void add(Item item) {
        studyList.add(item);
    }
    
    public Item find(String stimulusOrResponse) {
    	int i = 0;
    	for (i = 0; i < studyList.size(); i++){
    		Item item = studyList.get(i);
    		if(stimulusOrResponse.equals(item.stimulus)||
    				stimulusOrResponse.equals(item.response)){
    			return item = studyList.get(i);
    		}
    	}
    	return null;
    }
    
    public void delete(Item item) {
    	for (int i = 0; i < studyList.size(); i++){
        	if (item == studyList.get(i)){
        		studyList.remove(item);
        	}
    	}
    }
    
    public void modify(Item item, String newStimulus, String newResponse) {
        for (int i = 0; i < studyList.size(); i++){
        	if (item == studyList.get(i)){
        		item.setStimulus(newStimulus);
        		item.setResponse(newResponse);
        	}
        }
    }

    public static Item convertStringToItem(String string) {
    	String[] components = string.split(" *\\|\\| *"); 
    	String stimulus = components[0];
    	String response = components[1];
    	stimulus = stimulus.trim();
    	response = response.trim();
    	Item item = new Item(stimulus, response);
    	return item;
    }
    
    public static String convertItemToString(Item item){
    	String string = item.stimulus + " || " + item.response;
    	return string;
    }
    
    public ArrayList<String> convertItemsToStrings(List<Item> items) {
    	ArrayList<String> strings = new ArrayList();
    	for (int i = 0; i < studyList.size(); i++) {
    		String string = convertItemToString(studyList.get(i));
    		strings.add(string);
    	}
    	return strings;
    }
    
    public Item get() {
    	return currentItem;
    }
    
    public Item next() {
    	currentItem = studyList.remove(0);
    	return currentItem;
    }
    
    public int remaining() {
    	return studyList.size();
    }
    
    public boolean hasNext() {
    	return !studyList.isEmpty();
    }
    
    public void load(StudyGui gui) throws IOException {
        List<String> stringList = SimpleIO.load();
        if (stringList != null){
        	for (String string: stringList) {
        		Item item = convertStringToItem(string);
        		studyList.add(item);
        	}
        	gui.studyListLoaded();
        }
    }
    
    public void save() throws IOException {
    	SimpleIO.save(convertItemsToStrings(studyList));
    }
    
    public void saveAs() throws IOException {
    	SimpleIO.saveAs(convertItemsToStrings(studyList));
    }
}
