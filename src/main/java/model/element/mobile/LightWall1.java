package model.element.mobile;

import contract.model.IMap;
import contract.model.Permeability;
import model.elements.Sprite;

public class LightWall1 extends Mobile {
	
	private static final Sprite sprite = new Sprite('*', "lightwall1.png");

	protected LightWall1(int x, int y, Sprite sprite, IMap map, Permeability permeability) {
		super(x, y, sprite, map, Permeability.KILL);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Boolean player1IsFacingLightWall() {
		return null;
	}
	
	@Override
	public Boolean player2IsFacingLightWall() {
		return null;
		
	}
	
	@Override
	public void playerIsFacingSomething() {
		// TODO Auto-generated method stub
		
	}
	
    public int getY() {
        return this.getPosition().y;
    }
    
    public int getX() {
        return this.getPosition().x;
    }
    
}
