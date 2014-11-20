/**
 * 
 */
package flashCards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import simpleIO.SimpleIO;

/**
 * @author David Matuszek and James Park
 */
public class StudyList {
	
	List<Item> studyList;
	Item currentItem;
	int itemLocation = -1;
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
    	int numCorrect;
    	String stimulus = components[0];
		String response = components[1];
    	if (string.split(" *\\|\\| *").length == 3){
    		numCorrect = Integer.parseInt(components[2]);	
    	}
    	else{
    		numCorrect = 0;
    	}
    	stimulus = stimulus.trim();
    	response = response.trim();
    	Item item = new Item(stimulus, response);
        item.setTimesCorrect(numCorrect);
    	return item;
    }
    
    public static String convertItemToString(Item item){
    	String string = item.stimulus + " || " + item.response + " || " + String.valueOf(item.numCorrect);
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
    	if (hasNext()){
    	itemLocation += 1;
    	currentItem = studyList.get(itemLocation);
    	while (currentItem.getTimesCorrect() > 3) {
    		itemLocation += 1;
    		currentItem = studyList.get(itemLocation);
    	}
    	return currentItem;
    	}
    	return null;
    }
    
    public boolean hasNext() {
    	int listCounter = this.itemLocation + 1;
    	return listCounter < studyList.size();
    }
    
    public boolean randgen() {
    	Random randNum = new Random();
    	int rand = randNum.nextInt((3 - 1) + 1) + 1;
    	return rand == 3; 
    }
    
    public void swap(){
    	Item item1; 
    	Item item2;
    	for (int i = 0; i < studyList.size() - 1; i++) {
    		item1 = studyList.get(i);
    		item2 = studyList.get(i + 1);
    		if (randgen()){
    			studyList.set(i, item2);
    			studyList.set(i + 1, item1);
    		}
    	}
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
    
    public void save(StudyGui gui) throws IOException {
    	SimpleIO.save(convertItemsToStrings(studyList));
    }
    
    public void saveAs() throws IOException {
    	SimpleIO.saveAs(convertItemsToStrings(studyList));
    }
}
