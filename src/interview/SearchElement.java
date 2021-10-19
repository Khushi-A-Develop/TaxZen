package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchElement {
	private int arr[];
	private int arrLength;
	static private List<String> Actions= new ArrayList<String>();

	public static void main(String[] args) {
		SearchElement obj  =  new SearchElement();
		obj.getUserInput();
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("You have two options : 1. Modify array \n 2. Search Element \n3 3. Exit");
			 choice = sc.nextInt();
			 
			if(choice == 1) {
				Actions.add("You choosed to modify array");
				System.out.println("You can perform 2 operations : 1. Update an  Element \n 2. Replace all element");
				int choice2 =sc.nextInt();
				if(choice2 == 1) {
					System.out.println("Enter position to be replaced");
					int pos = sc.nextInt();
					System.out.println("Enter new element");
					int newElement = sc.nextInt();
					obj.updateElement(newElement, pos);
					Actions.add("You choosed to update element at index "+pos + " with "+ newElement);
				}else if(choice2 == 2 ) {
					obj.replaceAllElement();
					Actions.add("You are replacing all the elements of the array");
				}
			}
			else if(choice == 2) {
				System.out.println("enter element to be searched");
				int element = sc.nextInt();
				obj.searchUserElement(element);
				Actions.add("You are searching for element : "+element);
			} else if(choice == 3) {
				System.out.println("Thank you !! This is your logs \n");
				Actions.add("You choosed to exist");
				System.out.println(Actions);
				
			}
		}while(choice!=3);
		
	}
	
	
	public void getUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Element in an Array");
		arrLength = sc.nextInt();
		System.out.println("User Enteres " + arrLength + " number of elements in an array");
		int arr[] = new int[arrLength];
		Actions.add("Array Size is : "+ arrLength);
		for(int i = 0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
			Actions.add("Added "+ arr[i] + " at "+ i);
		}
		this.arr=arr;
	}
	
	public int searchUserElement(int element) {
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]==element) {
				System.out.println(element + " found at position "+i);
				Actions.add(element + " found at position "+i);
				return i;
			}
		}
		System.out.println(element + " not found");
		Actions.add(element + " not found");
		return arrLength;
	}
	
	public void updateElement(int newElement, int pos) {
		if(pos < arrLength) {
			System.out.println(newElement + " Update at position "+pos);
			Actions.add(newElement + " Updated at position "+pos);
			arr[pos]=newElement;
		}else {
			System.out.println(newElement + " Cannot be updated at " + pos );
			Actions.add(newElement + " cannot be replaced");
		}
	}
	public void replaceAllElement() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<arrLength;i++) {
			System.out.println("Enter new element for position "+ i);
			arr[i]=sc.nextInt();
			Actions.add("Replaces "+ arr[i] + " at "+ arrLength);
		}
	}
	
	

}
