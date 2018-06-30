package contract.model;

import java.awt.Image;

import showboard.ISquare;

public interface IElement extends ISquare {
	
	ISprite getSprite();
	
	Permeability getPermeability();
	
	@Override
	Image getImage();

}
