package listsLevel2;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arr1 = {10, 20, 30, 40, 50, 60, 70};
        int[] arr2 = {1, 2, 3, 4, 5, 2, 6, 7};

        Node<Integer> L1 = buildList(arr);
        Node<Integer> L2 = buildList(arr1);
        Node<Integer> L3 = buildList(arr2);

        System.out.println(ex1(L1, L2));
        System.out.println(bubbleSort_ex2(L1));
        System.out.println(distancesBetweenNum(L3, 2));
        System.out.println("the list without the same values: " + diffValues(L3));
        System.out.println(delSameValuesL(L3));
    }

    public static Node<Integer> buildList(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;
        for (int i = 1; i < arr.length; i++) {
            current.setNext(new Node<>(arr[i]));
            current = current.getNext();
        }
        return head;
    }
    
    
    
    	 public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
    		    Node<Integer> dummy = new Node<>(-1);
    		    Node<Integer> current = dummy;

    		    while (l1 != null && l2 != null) {
    		        if (l1.getValue() <= l2.getValue()) {
    		            current.setNext(l1);
    		            l1 = l1.getNext();
    		        } else {
    		            current.setNext(l2);
    		            l2 = l2.getNext();
    		        }
    		        current = current.getNext();
    		    }

    		    if (l1 != null) {
    		        current.setNext(l1);
    		    } else if (l2 != null) {
    		        current.setNext(l2);
    		    }

    		    return dummy.getNext();
    	 }
    	 
    	 
    	 
    	 public static Node<Integer> bubbleSort_ex2(Node<Integer> head) {
    		    if (head == null || head.getNext() == null) {
    		        return head;
    		    }

    		    Node<Integer> current = head;
    		    Node<Integer> next = null;
    		    int temp;

    		    while (current != null) {
    		        next = current.getNext();
    		        while (next != null) {
    		            if (current.getValue() > next.getValue()) {
    		                temp = current.getValue();
    		                current.setValue(next.getValue());
    		                next.setValue(temp);
    		            }
    		            next = next.getNext();
    		        }
    		        current = current.getNext();
    		    }

    		    return head;
    		}
    	 
    	 
    	 
    	 public static int distancesBetweenNum(Node<Integer> L1, int num) {
    	        Node<Integer> current = L1;
    	        int distance = 0;
    	        int prevValue = -1;

    	        while (current != null) {
    	            if (current.getValue() == num) {
    	                if (prevValue != num) {
    	                    distance += prevValue == -1 ? 0 : distance;
    	                    distance = 0;
    	                }
    	            } else {
    	                distance++;
    	            }
    	            prevValue = current.getValue();
    	            current = current.getNext();
    	        }

    	        if (distance == 0) {
    	            return -1;
    	        } else {
    	            return distance;
    	        }
    	    }

    	    public static boolean diffValues(Node<Integer> head) {
    	        Node<Integer> current = head;
    	        while (current != null) {
    	            Node<Integer> temp = current.getNext();
    	            while (temp != null) {
    	                if (current.getValue().equals(temp.getValue())) {
    	                    return false;
    	                }
    	                temp = temp.getNext();
    	            }
    	            current = current.getNext();
    	        }
    	        return true;
    	    }

    	    public static Node<Integer> delSameValuesL(Node<Integer> head) {
    	        Node<Integer> current = head;
    	        Node<Integer> prev = null;

    	        while (current != null) {
    	            Node<Integer> temp = current.getNext();
    	            while (temp != null && current.getValue().equals(temp.getValue())) {
    	                temp = temp.getNext();
    	            }
    	            if (prev != null && prev.getValue().equals(current.getValue())) {
    	                prev.setNext(temp);
    	            } else {
    	                prev = current;
    	            }
    	            current = temp;
    	        }

    	        return head;
    	    }
    	}
