/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		
		while(frontIsClear()){
			//traverseAndFixColumn.
			fixColumn();
			
			moveToNextColumn();
		}
		fixColumn();	
	}

	private void fixColumn(){
		traverseAndFixColumn();
		moveToBottonOfColumn();
	}
	
	/*
	 * Precondition: Karel is at the bottom of the column facing east
	 * PostCondition: Karel fixes the column will be at the top of column facing north 
	 */
	private void traverseAndFixColumn(){
		
		turnLeft();
		
		while(frontIsClear()){
			if(!beepersPresent()){
				putBeeper();
			}
			move();
		}
		if(!beepersPresent()){
			putBeeper();
		}
		
	}
	
	/*
	 * Precondition: Karel is at the top of the column facing north
	 * PostCondition: Karel is at the bottom of column facing east
	 */
	private void moveToBottonOfColumn(){
		
		turnAround();
		while(frontIsClear()){
			move();
		}
		
		turnLeft();
	}
	
	/*
	 * Precondition:Karel at the bottom of column facing east
	 * PostCondition:Karel at the next column facing east
	 */
	private void moveToNextColumn(){
		
		//check if at avenue by checking if beepers are present
		//if(beepersPresent()){
			move();
			move();
			move();
			move();
		//}		
	}
	
}
