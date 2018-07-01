package model.element.mobile;

import java.io.IOException;

import contract.model.IMap;
import contract.model.Permeability;
import model.elements.Sprite;

public class Player1 extends Mobile {
	
	private static final Sprite sprite = new Sprite('A', "motobleubas.png");
	
	private static final Sprite spriteMoveLeft = new Sprite('A', "motobleugauche.png");
	
	private static final Sprite spriteMoveRight = new Sprite('A', "motobleudroite.png");
	
	private static final Sprite spriteMoveUp = new Sprite('A', "motobleuhaut.png");
	
	private static final Sprite spriteMoveDown = new Sprite('A', "motobleubas.png");

	
    public Player1(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.KILL);
        sprite.loadImage();
        spriteMoveLeft.loadImage();
        spriteMoveRight.loadImage();
        spriteMoveUp.loadImage();
        spriteMoveDown.loadImage();
    }
    
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteMoveLeft);
    }
    
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteMoveRight);
       
    }
    
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteMoveUp);

    }
    
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteMoveDown);
        
    }
    
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
    
	@Override
	public Boolean player1IsFacingLightWall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void playerIsFacingSomething() {
		// TODO Auto-generated method stub
		
	}	
}
