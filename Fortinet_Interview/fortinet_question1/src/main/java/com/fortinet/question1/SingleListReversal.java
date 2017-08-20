package com.fortinet.question1;

public class SingleListReversal {
	
	public Node reverseList(Node head){
		// Give resolution here. Please make sure your resolution covers all above-listed test cases.
		// JUnit test cases are not required but you are welcome to provide it to save my time to verify your resolution. 
		// It is a good habit for the software engineer to prepare JUnit test cases.
		Node pre = null;
		Node current = head;
		Node next = null;
		
		while(current!=null){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

}
