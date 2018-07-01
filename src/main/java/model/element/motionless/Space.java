package model.element.motionless;

import contract.model.Permeability;
import model.elements.Sprite;

public class Space extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite(' ', "space.png");
	
	public Space() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
