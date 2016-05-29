/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run(){
		
		boolean lastSpotBeeperDrop = false;
		
		while(!checkEnd()){
		//	traverseRow();
			while(frontIsClear()){
				if(lastSpotBeeperDrop){
					move();
					lastSpotBeeperDrop = false;
				}else{
					putBeeper();
					lastSpotBeeperDrop = true;
				}
			}
			
		moveToNextRow();	
			
		/*	if(!checkEnd()){
				moveToNextRow();
				traverseRow(); //added to address OBOB
			}
			*/
		
		}		
	}
	
	//Precondition: None
	//PostCondition: Checks if Karel has reached the top end of the grid and blocked
	public boolean checkEnd(){
		//Face north and check if front is blocked
		if(facingNorth()){
			return frontIsBlocked();
		}
		if(facingEast()){
			return leftIsBlocked();
		}
		if(facingWest()){
			return rightIsBlocked();
		}else{
			turnAround();
			if(frontIsBlocked()){
				turnAround();
				return false;
			}
			return true;
			
		}
	}
	
	public void traverseRow(){
		//if(!PrevRowLastBeeperDrop){
			putBeeper();
		//}
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
		}
	}
	
	public void moveToNextRow(){
		while(!facingNorth()){
			turnLeft();
		}
		move();
		if(rightIsClear()){
			turnRight();
		}else{
			turnLeft();
		}
	}
	
	
		/*while(!facingNorth()){
			turnLeft();
		}
		
		return frontIsBlocked();
	
	*/
	}
