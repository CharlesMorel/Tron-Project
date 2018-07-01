package model.element.motionless;

import contract.model.Permeability;
import model.elements.Sprite;

public class Wall extends MotionlessElement {
	
	private static final Sprite SPRITE = new Sprite('W', "wall.png");
	
	Wall() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
