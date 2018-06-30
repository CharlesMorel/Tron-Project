package contract.model;

import java.awt.Image;
import java.io.IOException;

public interface ISprite {
	
	Image getImage();
	
	void loadImage() throws IOException;
	
	char getConsoleImage();
	
	
	String getImageName();
	
	boolean isImageLoaded();
	
	void setImageLoaded(final boolean isImageLoaded);

}
