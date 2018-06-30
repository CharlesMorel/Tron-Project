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
    
    Boolean isFacingLightWall1();
    
    Boolean isFacingLightWall2();
    
	Boolean Win();
	
    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();
    
    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();
    
    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isCrashed();
    
    Point getPosition();
    
    void alive();
    
	void setY(final int y);
	
	void setX(final int x);
	
	int getStartxPlayer1();

	int getStartyPlayer1();
	
	int getStartxPlayer2();

	int getStartyPlayer2();
	
	Object getMap();
	
	void die();
	
	Boolean win();
	
	
}
