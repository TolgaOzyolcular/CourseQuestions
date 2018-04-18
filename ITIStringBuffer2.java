import java.util.*;

//Just a LinkedList Implementation

public class ITIStringBuffer2 {

	SinglyLinkedList<String> linkedList;
	
    public ITIStringBuffer2() {
    		linkedList = new SinglyLinkedList<String>();
    }

    public ITIStringBuffer2(String firstString){
    		linkedList = new SinglyLinkedList<String>();
    		linkedList.addFirst(firstString);
    }

    public void append(String nextString){
    	
    		if(linkedList.isEmpty())
            linkedList.addFirst(nextString);       
        else
            linkedList.add(nextString);
        
    }

    public String toString(){
        String result = "";
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
        		result += i.next();
        }
        //System.out.println(result);
        
        return result;
    }

}