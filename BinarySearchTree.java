/**
*  @author Marcel Turcotte
*/

import java.util.NoSuchElementException;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;

    /**
    * Inserts an object into this BinarySearchTree.
    *
    * @param elem item to be added
    * @return true if the object has been added and false otherwise
    */

    public boolean add(E elem) {

        // pre-condtion:

        if (elem == null) {
            throw new NullPointerException();
        }

        // special case:

        if (root == null) {
            root = new Node<E>(elem);
            return true;
        }

        // general case:

        return add(elem, root);
    }

    // Helper method

    private boolean add(E elem, Node<E> current) {

        boolean result;
        int test = elem.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.right);
            }
        }
        return result;
    }
    
    private static int nodeCount = 0;
    
    Stack<Node<E>> myStack = new Stack<Node<E>>();
    
    public int count(E low, E high) {
    		    	
    		if (low == null || high == null) {
    			throw new NullPointerException();
    		}
    		
    		//System.out.println(currentNode.value);
    		
    		if(((root.value).compareTo(low)) >= 0 && ((root.value).compareTo(high) <= 0)) {  
    			nodeCount++;  	
    			//return 0;
    		}
			
    		if(root.left != null) {   
    			myStack.push(root);
    			root = root.left;
    			//System.out.println("LEFT: " + root.value);
    			count(low, high);
    		}
    		
    		//System.out.println("Current current Value: " + root.value);
    		
    		if(root.right != null) {
    			myStack.push(root);
    			root = root.right;
    			//System.out.println("RIGHT: " + root.value);
    			count(low, high);
    		}
    		
    		if(myStack.isEmpty()) {
    			return nodeCount;
    		}
    		root = myStack.pop();
    		
    		return nodeCount;
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> current) {

        if (current == null) {
            return "()";
        }

        return "(" + toString(current.left) + current.value + toString(current.right) + ")";
    }

}