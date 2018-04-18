import java.util.*;

//Just char implementation

public class ITIStringBuffer {

    //private SinglyLinkedList<String> linkedList;
	int index;
	char[] charArray;
    
    public ITIStringBuffer() {
        //linkedList = new SinglyLinkedList<String>(); //linkedList        
    	
    	
        charArray = new char[1];
    }

    public ITIStringBuffer(String firstString){
      
        //linkedList = new SinglyLinkedList<String>(); //linkedList
        
        
        charArray = firstString.toCharArray();
        
        
        //linkedList.addFirst(firstString); //linkedList        

        index = index + firstString.length();
        
    }

    public void append(String nextString){

        if((nextString.length() + index >= charArray.length)){
        	
          while((nextString.length() + index) >= charArray.length)        	  
        	  	charArray = Arrays.copyOf(charArray, (charArray.length * 2));
          
        }
        
        //LinkedList
        //if(linkedList.isEmpty())
        //  linkedList.addFirst(nextString);       
        //else
        //  linkedList.add(nextString);        
        
        nextString.getChars(0, nextString.length(), charArray, index);
        index = index + nextString.length();

    }


    public String toString(){
      String result = new String(charArray, 0, index);
      
      return result;
    }

}