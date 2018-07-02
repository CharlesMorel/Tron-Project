package model;

import java.io.IOException;
import java.sql.SQLException;

import contract.model.IMap;
import contract.model.IMobile;
import contract.model.IModel;
import model.element.mobile.LightWall1;
import model.element.mobile.LightWall2;
import model.element.mobile.Mobile;
import model.element.mobile.Player1;
import model.element.mobile.Player2;

public class Model implements IModel {
	
	private IMap map;
	
	private IMobile player1;
	
	private IMobile player2;
	
	private IMobile lightWall1;
	
	private IMobile lightWall2;
	
	public Model(final String fileName) throws IOException, SQLException {
		Mobile.setStartXPlayer1(1);
		Mobile.setStartYPlayer1(1);
		
		Mobile.setStartXPlayer2(5);
		Mobile.setStartYPlayer2(5);
		
		Mobile.setStartXLightWall1(1);
		Mobile.setStartYLightWall1(1);
		
		Mobile.setStartXLightWall2(5);
		Mobile.setStartYLightWall2(5);
		
		this.setMap(new Map(fileName));
		this.setPlayer1(new Player1(Mobile.startXPlayer1, Mobile.startYPlayer1, this.getMap()));
		this.setPlayer2(new Player2(Mobile.startXPlayer2, Mobile.startYPlayer2, this.getMap()));
	    /*this.setLightWall1(new LightWall1(Mobile.startXLightWall1, Mobile.startYLightWall1, this.getMap()));
		this.setLightWall2(new LightWall2(Mobile.startXLightWall2, Mobile.startYLightWall2, this.getMap()));*/
	}

	
	
    private void setMap(final IMap map) {
        this.map = map;
    }

    @Override
	public IMap getMap() {
        return this.map;
	}
	
    private void setPlayer1(final IMobile player1) {
        this.player1 = player1;
    }

    @Override
	public IMobile getPlayer1() {
		return player1;
	}
	
    private void setPlayer2(final IMobile player2) {
        this.player2 = player2;
    }

    @Override
	public IMobile getPlayer2() {
		return player2;
	}
	
    private void setLightWall1(IMobile lightWall1) {
		this.lightWall1 = lightWall1;
	}

    @Override
	public IMobile getLightWall1() {
		return lightWall1;
	}

    private void setLightWall2(IMobile lightWall2) {
		this.lightWall2 = lightWall2;
	}
	
    @Override
	public IMobile getLightWall2() {
		return lightWall2;
	}

}
