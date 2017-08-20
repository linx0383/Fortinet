package com.fortinet.question1;

import org.junit.Assert;
import org.junit.Test;

import com.fortinet.question1.Node;
import com.fortinet.question1.SingleListReversal;

public class TestReverseSingleList {
	
	public SingleListReversal singleListReversal = new SingleListReversal();
	
	@Test
	public void testReverseSingleListWithNull(){
		//Test Case 1
		Node nullNode = null;
		singleListReversal.reverseList(nullNode);
		Assert.assertEquals(null, nullNode);
	}
	
	@Test
	public void testReverseSingleListWithOnlyOneNode(){
		//Test Case 2
		Node node1 = new Node(1);
		
		int value1 = node1.value;
		singleListReversal.reverseList(node1);
		
		Assert.assertEquals(value1, node1.value);
		Assert.assertEquals(null, node1.next);
	}

	
	@Test
	public void testReverseSingleListWithMultipleNode(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		int value1 = node1.value;
		int value2 = node2.value;
		int value3 = node3.value;
		int value4 = node4.value;
		singleListReversal.reverseList(node1);
		
		Assert.assertEquals(value4, node4.value);
		Assert.assertEquals(value3, node4.next.value);
		Assert.assertEquals(value2, node4.next.next.value);
		Assert.assertEquals(value1, node4.next.next.next.value);
		Assert.assertEquals(null, node4.next.next.next.next);
		
	}
	
}
