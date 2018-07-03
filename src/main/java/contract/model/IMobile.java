package contract.model;

import java.awt.Point;
import java.io.IOException;

import showboard.IPawn;



public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     * @throws IOException 
     */
    void moveUp() throws IOException;

    /**
     * Move left.
     * @throws IOException 
     */
    void moveLeft() throws IOException;

    /**
     * Move down.
     * @throws IOException 
     */
    void moveDown() throws IOException;

    /**
     * Move right.
     * @throws IOException 
     */
    void moveRight() throws IOException;


    

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

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();

	void alive();

	void doNothing();

}
