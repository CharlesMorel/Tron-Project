package showboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = -1561359738513452134L;
	
	
	private ISquare[][] squares;
	
	
	private final List<IPawn> pawns;
	
	
	private Dimension dimension;
	
	
	private Rectangle displayFrame;
	
	
	private final BufferedImage noImage;
	
	
	private Boolean widthLooped = false;
	
	
	private Boolean heightLooped = false;
	
	
    BoardPanel() {
        super();
        this.pawns = new ArrayList<>();
        this.noImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = this.noImage.createGraphics();
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 2, 2);
    }
    
    
    @Override
    public final void paintComponent(final Graphics graphics) {

        final Map<String, ArrayList<IPawn>> mapPawn = this.createMapPawn();

        for (int x = this.getCornerMinX(); x <= this.getCornerMaxX(); x++) {
            for (int y = this.getCornerMinY(); y <= this.getCornerMaxY(); y++) {
                this.drawSquareXY(graphics, x, y);
                this.drawPawnsXY(graphics, mapPawn, x, y);
            }
        }
    }
    
    
    @Override
    public final void update(final Observable observable, final Object object) {
        this.repaint();
    }
    
    
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.squares[x][y] = square;
    }
    
    
    public final void addPawn(final IPawn pawn) {
        this.getPawns().add(pawn);
    }
    
    
    
    
    
    private Image getImageXY(final int x, final int y, final int widthLimit, final int heightLimit) {
        Image image;
        final int realX = this.calculateRealX(x);
        final int realY = this.calculateRealY(y);
        if ((realX < 0) || (realY < 0) || (realX >= widthLimit) || (realY >= heightLimit)) {
            image = this.noImage;
        } else {
            image = this.squares[realX][realY].getImage();
            if (image == null) {
                image = this.noImage;
            }
        }
        return image;
    }
    
    
    
    
    
    private int calculateRealX(final int x) {
        if (!this.isWidthLooped()) {
            return x;
        }
        return (x + this.getDimension().width) % this.getDimension().width;
    }
    
    
    private int calculateRealY(final int y) {
        if (!this.isHeightLooped()) {
            return y;
        }
        return (y + this.getDimension().height) % this.getDimension().height;
    }
    
    
    private List<IPawn> getPawns() {
        return this.pawns;
    }
    
    
    public final Dimension getDimension() {
        return this.dimension;
    }
    
    
    public final void setDimension(final Dimension dimension) {
        this.dimension = dimension;
        this.squares = new ISquare[this.getDimension().width][this.getDimension().height];
    }

    
    public final Rectangle getDisplayFrame() {
        return this.displayFrame;
    }
    
    
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.displayFrame = displayFrame;
    }
    
    
    public Boolean isWidthLooped() {
        return this.widthLooped;
    }

    /**
     * Sets the width looped.
     *
     * @param widthLooped
     *            the new width looped
     */
    public void setWidthLooped(final Boolean widthLooped) {
        this.widthLooped = widthLooped;
    }

    /**
     * Checks if is height looped.
     *
     * @return the boolean
     */
    public Boolean isHeightLooped() {
        return this.heightLooped;
    }

    /**
     * Sets the height looped.
     *
     * @param heightLooped
     *            the new height looped
     */
    public void setHeightLooped(final Boolean heightLooped) {
        this.heightLooped = heightLooped;
    }

    /**
     * Creates the map pawn.
     *
     * @return the map
     */
    private Map<String, ArrayList<IPawn>> createMapPawn() {
        final Map<String, ArrayList<IPawn>> mapPawn = new HashMap<>();
        String key;

        for (final IPawn pawn : this.getPawns()) {
            key = this.createMapPawnKey(pawn.getX(), pawn.getY());
            ArrayList<IPawn> listPawn = mapPawn.get(key);
            if (listPawn == null) {
                listPawn = new ArrayList<>();
                mapPawn.put(key, listPawn);
            }
            listPawn.add(pawn);
        }
        return mapPawn;
    }

    /**
     * Creates the map pawn key.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the string
     */
    private String createMapPawnKey(final int x, final int y) {
        return x + ":" + y;
    }

    /**
     * Draw square XY.
     *
     * @param graphics
     *            the graphics
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void drawSquareXY(final Graphics graphics, final int x, final int y) {
        Image image;
        image = this.getImageXY(x, y, this.getWidthLimit(), this.getHeightLimit());
        graphics.drawImage(image, this.getSquareSizeWidth() * (x - this.getCornerMinX()),
                this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
                this.getSquareSizeHeight(), this);

    }

    /**
     * Draw pawns XY.
     *
     * @param graphics
     *            the graphics
     * @param mapPawn
     *            the map pawn
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void drawPawnsXY(final Graphics graphics, final Map<String, ArrayList<IPawn>> mapPawn, final int x,
            final int y) {
        final List<IPawn> listPawn = mapPawn.get(this.createMapPawnKey(this.calculateRealX(x), this.calculateRealY(y)));
        if (listPawn != null) {
            for (final IPawn pawn : listPawn) {
                graphics.drawImage(pawn.getImage(), this.getSquareSizeWidth() * (x - this.getCornerMinX()),
                        this.getSquareSizeHeight() * (y - this.getCornerMinY()), this.getSquareSizeWidth(),
                        this.getSquareSizeHeight(), this);
            }
        }
    }

    /**
     * Gets the width limit.
     *
     * @return the width limit
     */
    private int getWidthLimit() {
        return Math.min(this.getDisplayFrame().width + this.getDisplayFrame().x, this.getDimension().width);
    }

    /**
     * Gets the height limit.
     *
     * @return the height limit
     */
    private int getHeightLimit() {
        return Math.min(this.getDisplayFrame().height + this.getDisplayFrame().y, this.getDimension().height);
    }

    /**
     * Gets the corner min X.
     *
     * @return the corner min X
     */
    private int getCornerMinX() {
        return this.getDisplayFrame().x;
    }

    /**
     * Gets the corner max X.
     *
     * @return the corner max X
     */
    private int getCornerMaxX() {
        return this.getDisplayFrame().x + this.getDisplayFrame().width;
    }

    /**
     * Gets the corner min Y.
     *
     * @return the corner min Y
     */
    private int getCornerMinY() {
        return this.getDisplayFrame().y;
    }

    /**
     * Gets the corner max Y.
     *
     * @return the corner max Y
     */
    private int getCornerMaxY() {
        return this.getDisplayFrame().y + this.getDisplayFrame().height;
    }

    /**
     * Gets the square size width.
     *
     * @return the square size width
     */
    private int getSquareSizeWidth() {
        return this.getWidth() / this.getDisplayFrame().width;
    }

    /**
     * Gets the square size height.
     *
     * @return the square size height
     */
    private int getSquareSizeHeight() {
        return this.getHeight() / this.getDisplayFrame().height;
    }
    
}
