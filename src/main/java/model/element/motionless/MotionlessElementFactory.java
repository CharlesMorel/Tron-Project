package model.element.motionless;

public class MotionlessElementFactory {
	
	private static final Wall wall = new Wall();
	
	private static final Space space = new Space();
	
	private static MotionlessElement[] motionlessElements = {
			wall,
			space
	};
	
    public static MotionlessElement createWall() {
        return wall;
    }
    
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return space;
    }

}
