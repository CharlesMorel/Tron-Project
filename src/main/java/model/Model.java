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
    
    private IMobile lightWall1;
    
    private IMobile lightWall2;
    
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
       /* Mobile.setStartXLightWall1(20);
        Mobile.setStartYLightWall1(5);
        Mobile.setStartXLightWall2(25);
        Mobile.setStartYLightWall2(10);
        this.setLightWall1(new LightWall1(Mobile.StartXLightWall1, Mobile.StartYLightWall1, this.getMap()));
        this.setLightWall2(new LightWall2(Mobile.StartXLightWall2, Mobile.StartYLightWall2, this.getMap()));*/
    }
    
    
    
    public void setLightWall2(IMobile lightWall2) {
		this.lightWall2 = lightWall2;
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

    @Override
	public IMobile getLightWall1() {
		return lightWall1;
	}

	@Override
	public IMobile getLightWall2() {
		return lightWall2;
	}
	
	public void setLightWall1(IMobile lightWall1) {
		this.lightWall1 = lightWall1;
	}

    
}
