package model.element.motionless;

import contract.model.Permeability;
import model.elements.Sprite;

public class Tile extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite(' ', "space.png");
	
	public Tile() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
