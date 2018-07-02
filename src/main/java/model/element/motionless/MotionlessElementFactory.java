package model.element.motionless;

public abstract class MotionlessElementFactory {

    /** The Constant Wall. */
    private static final Wall wall = new Wall();
    
    /** The Constant Tile (black background). */
    private static final Tile tile = new Tile();
	
    private static MotionlessElement[]       motionlessElements  = {
            wall,
            tile,
            };
    
    /**
     * Creates a new vertical bone MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWall() {
        return wall;
    }
    
    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return tile;
    }
}
