package model.element.motionless;

import contract.model.IElement;
import contract.model.Permeability;
import model.elements.Element;
import model.elements.Sprite;

public class MotionlessElement extends Element implements IElement {
	
	MotionlessElement(final Sprite sprite, final Permeability permeability) {
		super(sprite, permeability);
	}

}
