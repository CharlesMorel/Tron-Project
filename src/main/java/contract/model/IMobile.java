package contract.model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

	void moveRight();
	
	void moveLeft();
	
	void moveUp();
	
	void moveDown();
	
	void sameDirection();
	
	void doNothing();
    
    Boolean player1IsFacingLightWall();
    
    Boolean player2IsFacingLightWall();
    
    void playerIsFacingSomething();
    
	Boolean player1Win();
	
	Boolean player2Win();
	
    /**
     * Gets the x.
     *
     * @return the x
     */
	//@Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    //@Override
    int getY();
    
    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean player1IsAlive();
    
    Boolean player2IsAlive();
    
    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isCrashed();
    
    Point getPosition();
    
    void player1Alive();
    
    void player2Alive();
    
	void setY(final int y);
	
	void setX(final int x);
	
	int getStartxPlayer1();

	int getStartyPlayer1();
	
	int getStartxPlayer2();

	int getStartyPlayer2();
	
	Object getMap();
	
	void player1Die();

	void player2Die();
	
}
