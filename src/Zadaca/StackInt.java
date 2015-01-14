package Zadaca;

public class StackInt {
	private IntNode head;
	private IntNode min;
	
		/**
		 * Method which adds new Node into our stack. In this method I'll be checking 
		 * for min values of our stack. I'll be connecting min values so once my min
		 * value get popped, my next min value will be correct.
		 * @param value min value in stack.
		 */
		public void push(int value){
			IntNode p = new IntNode(value);
		
			if(head == null){					//Case 1, empty stack
				min =p;
				head = p;
				
			}
			else if (p.getValue() <= min.getValue()){  //Case 2, Once we found new min.
					
				p.setPrevMin(min);					// Setting prev min value of our new min.
					min = p;						// moving min to new min	
					p.setNext(head);
					head = p;	
					
			}else{									//Case 3, no min found. Normal push.				
				
				p.setNext(head);				
				head = p;
			}
		}
		
		/**
		 * Method returns min value in our stack. How we got to min array described 
		 * at push/pop methods.
		 * @return
		 */
		public int getMin(){
			return min.getValue();
		}
		
		/**
		 * Pop method which removes first node in our stack. It also check if our node
		 * is min, so it can remove min.
		 * @return
		 */
		public int pop(){
			if(head == null)
				throw new IllegalStateException("First node is null");
			
			int result = head.getValue();
			
			if(head == min)		//Checking if our head is min.
				min = min.getPrevMin();			
			
			head = head.getNext();
			return result;
		}
	
		/**
		 * Method return value of first element in stack.
		 * @return
		 */
		public int peek(){
			if(head == null)
				throw new IllegalStateException("First node is null");
						
			return head.getValue();
		}
		
		/**
		 * Method to get size.
		 * @return size of our stack
		 */
		public int getSize(){
			if(head == null)
				return 0;			
			return getSize(head, 1);
			
		}
		/**
		 * Recursive way to get size of stack. Current will start as our head and keep going on, while we'll be increasing counter.
		 * Once our current is null, we'll return our counter.
		 * @param current
		 * @param counter
		 * @return
		 */
		private int getSize(IntNode current, int counter){
			if(current.getNext() == null)
				return counter;
			return getSize(current.next	, counter + 1);
						
		}
		
		public boolean contains(int value){
			if(head == null)
				throw new IllegalArgumentException("Its null");
			return contains(value, head);
		}
		
		/**
		 * Method which checks if sent value exists in our stack. This method use recursions.
		 * @param value
		 * @param current
		 * @return
		 */
		private boolean contains(int value, IntNode current){
				if(current == null) // IF we came to end of stack and didn't found value we return false
					return false;
			
				else if(current.getValue() == value) // If we found value in our list we return true
					return true;
			
				else // if we didnt come to end but didnt found value, we're using recursion to check for another element in list
					return contains(value, current.getNext());								
		}
	
	
	
	public static  class IntNode{
		private int value;
		private IntNode next;
		private IntNode prevMin;
		
			
		public IntNode(int value){
			this.value = value;
		}
		
		public IntNode getPrevMin() {
			return prevMin;
		}

		public void setPrevMin(IntNode prevMin) {
			this.prevMin = prevMin;
		}

		public int getValue(){
			return value;
		}
		public IntNode getNext(){
			return next;
		}
		public void setNext(IntNode next){
			this.next = next;
		}
		
	}
	
}
