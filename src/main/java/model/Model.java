package model;

import java.io.IOException;

import contract.model.IMap;
import contract.model.IMobile;
import contract.model.IModel;
import model.element.mobile.Player1;
import model.element.mobile.Player2;

public class Model implements IModel {

	   /** The road. */
    private IMap  map;

    /** The my vehicle. */
    private IMobile player1;
    
    private IMobile player2;
    
    /**
     * Instantiates a new model.
     *
     * @param fileName
     *            the file name
     *            
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Model(final String fileName) throws IOException {
        this.setMap(new Map(fileName));
        this.setPlayer1(new Player1(21, 6, this.getMap()));
        this.setPlayer2(new Player2(22, 10, this.getMap()));
    }
    
    /**
     * get level
     * @return level
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the level.
     *
     * @param level
     * 
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /**
     * get lorann
     * 
     *@return lorann
     */
    @Override
    public final IMobile getPlayer1() {
        return this.player1;
    }

    /**
     * Sets lorann.
     *
     * @param lorann
     *
     */
    private void setPlayer1(final IMobile player1) {
        this.player1 = player1;
    }

	@Override
	public IMobile getPlayer2() {
		// TODO Auto-generated method stub
		return this.player2;
	}
	
    private void setPlayer2(final IMobile player2) {
        this.player2 = player2;
    }

}
