package Zadaca;

import java.util.Stack;

/**
 	* Queue class that uses two stacks to be created. One stack we use for pushing into queue
 * and second stack for popping from it.  We keep all elements in our pushStack. Once
 * we want pop we will move all elements to popStack but last element ( that will be
 * first element we pushed). Then we pop that element so our queue behave as queue.
 * After that we back all elements back into pushStack.
 * @author Vedad_2
 *
 */
	public class MyQueue {

	private  Stack<Integer> pushStack;
	private  Stack<Integer> popStack;
	
	/**
	 * Constructor where we create our stacks.
	 */
	public MyQueue(){
		pushStack = new Stack<Integer>();
		popStack = new Stack<Integer>();
	}
		
	/**
	 * Push method, instead of pushing directly to queue we push into pushStack.
	 * @param value
	 */
	public void push(int value){
		pushStack.push(value);		
	}
	
	/**
	 * pop method which pops all elements from pushStack into popStack until size of stack
	 * is 1. That means we came to first element we pushed so we pop that element.
	 * After that we'll be returning all elements into push stack and return value
	 * of poped element.
	 * @return
	 */
	public int pop(){
		if(pushStack.isEmpty())
			throw new IllegalStateException("Queue is epmty, cant pop");
		
		while(pushStack.size() > 1)
			popStack.push(pushStack.pop());			
		
		int result = pushStack.pop();
		
		while(popStack.size() >0)
			pushStack.push(popStack.pop());	
			
		return result;		
	}
	
	/**
	 * Get size method simply returns size of pushStack.
	 * @return
	 */
	public int getSize(){
		return pushStack.size();
	}
	
	/**
	 * Contains method, returns contains method of pushStack.
	 * @param value
	 * @return
	 */
	public boolean contains(int value){
		return pushStack.contains(value);
	}
	
}
