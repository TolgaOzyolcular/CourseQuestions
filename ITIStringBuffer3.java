import java.util.Arrays;
import java.util.Iterator;

//LinkedList & Char Implementation

public class ITIStringBuffer3 {

	SinglyLinkedList<Character> linkedList;
	char[] charArray;
	
    public ITIStringBuffer3() {
    		linkedList = new SinglyLinkedList<Character>();
    		charArray = new char[1];
    }

    public ITIStringBuffer3(String firstString){
    		linkedList = new SinglyLinkedList<Character>();
    		charArray = firstString.toCharArray();
    		
    		linkedList.addFirst(charArray[0]);
    		
    		for(int i = 1; i<charArray.length; i++) {
    			linkedList.add(charArray[i]);
    		}
    		
    }

    public void append(String nextString){
    	    		
    		if((nextString.length() > charArray.length)){
            while(nextString.length() >= charArray.length){
          	  	charArray = Arrays.copyOf(charArray, charArray.length*2);
            }
         }
    		
    		charArray = nextString.toCharArray();
    		
    		if(linkedList.isEmpty())
    			linkedList.addFirst(charArray[0]);      
        else {
        		for(int i = 1; i<charArray.length; i++) {
        			linkedList.add(charArray[i]);
        		}
        }
    }

    public String toString(){
        String result = "";
        Iterator<Character> i = linkedList.iterator();
        while(i.hasNext()) {
        		result += i.next();
        }
        
        return result;
    }

}