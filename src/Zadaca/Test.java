package Zadaca;

import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		
		MyQueue  m = new MyQueue();		
		
		m.push(23);
		m.push(12);
		m.push(11);
	
		
		System.out.println(m.getSize());
		System.out.println(m.pop());
		System.out.println(m.getSize());
	}
	
}
