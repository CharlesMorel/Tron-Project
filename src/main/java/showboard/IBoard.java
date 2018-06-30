package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;

public interface IBoard {
	
	void addSquare(ISquare square, int x, int y);
	
	void addPawn(IPawn pawn);
	
	Observer getObserver();
	
	void setDimension(Dimension dimension);
	
	Dimension getDimension();
	
	void setDisplayFrame(Rectangle displayFrame);

}
