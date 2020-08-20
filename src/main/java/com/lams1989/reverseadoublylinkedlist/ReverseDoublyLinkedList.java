package com.lams1989.reverseadoublylinkedlist;

public class ReverseDoublyLinkedList {
	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}
	}

	public static void main(String args[]) {

		DoublyLinkedList llist = new DoublyLinkedList();
		int[] llistItem = { 530, 474, 302, 164, 141 };
		for (int i = 0; i < llistItem.length; i++) {
			DoublyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem[i]);
			llist.head = llist_head;
		}

		printLinkedList(reverse(llist.head));

	}

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			head.prev = null;
			return head;
		} else {
			DoublyLinkedListNode newHead = reverse(head.next);
			head.next.next = head;
			head.prev = head.next;
			head.next = null;

			return newHead;
		}
	}

	static DoublyLinkedListNode insertNodeAtHead(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode nodeInsert = new DoublyLinkedListNode(data);
		if (head == null) {
			return nodeInsert;
		}
		nodeInsert.next = head;

		return nodeInsert;
	}

	static void printLinkedList(DoublyLinkedListNode head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}
}
