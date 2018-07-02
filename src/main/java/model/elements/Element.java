
package model.elements;

import java.awt.Image;

import contract.model.IElement;
import contract.model.ISprite;
import contract.model.Permeability;

public class Element implements IElement {
	
	protected Sprite sprite;
	
	private Permeability permeability;
	
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}



	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}



    @Override
	public ISprite getSprite() {
        return (ISprite) this.sprite;
	}

    @Override
	public Permeability getPermeability() {
        return this.permeability;
	}

    @Override
	public Image getImage() {
        return this.getSprite().getImage();
	}

}
